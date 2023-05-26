package com.example.backend.serviceImpl;

import com.example.backend.model.Movie;
import com.example.backend.model.Seat;
import com.example.backend.model.Screening;
import com.example.backend.model.requests.ScreeningRequest;
import com.example.backend.model.response.ScreeningResponse;
import com.example.backend.repository.ScreeningRoomRepository;
import com.example.backend.repository.MovieRepository;
import com.example.backend.repository.ScreeningRepository;
import com.example.backend.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ScreeningServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final ScreeningRoomRepository screeningRoomRepository;

    @Override
    public Screening addScreening(ScreeningRequest screeningRequest) {
        Movie movie = movieRepository.findById(screeningRequest.getMovieId())
                .orElseThrow(() -> new NotFoundException("Movie with ID: " + screeningRequest.getMovieId()+ " not found"));

        Screening screening = Screening.builder()
                .startTime(screeningRequest.getStartTime())
                .movie(movie)
                .screeningRoom(screeningRoomRepository.findById(screeningRequest.getScreeningRoomId())
                        .orElseThrow(() ->
                                new NotFoundException("Screening room with ID: " + screeningRequest.getScreeningRoomId() + " not found")))
                .build();


        screening.setSeats( IntStream.range(1, screening.getScreeningRoom().getRowQuantity() + 1)
                .boxed().flatMap(rowNumber -> IntStream.range(1, screening.getScreeningRoom().getSeatsPerRow() + 1)
                        .mapToObj(seatNumber -> Seat.builder()
                                .rowNumber(rowNumber)
                                .seatNumber(seatNumber)
                                .isReserved(false)
                                .screening(screening)
                                .build())
                ).collect(Collectors.toList()));


        movie.getScreenings().add(screening);
        return screeningRepository.save(screening);
    }

    @Override
    public ScreeningResponse getScreeningById(Long id) {
        Screening screening = screeningRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Screening with ID: " + id + " not found"));

        return ScreeningResponse.builder()
                .screeningRoomNumber(screening.getScreeningRoom().getNumber())
                .seats(screening.getSeats().stream()
                        .filter(seat -> !seat.getIsReserved())
                        .map(seat -> ScreeningResponse.Seat.builder()
                                .id(seat.getId())
                                .row(seat.getRowNumber())
                                .seatNumber(seat.getSeatNumber())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }
}
