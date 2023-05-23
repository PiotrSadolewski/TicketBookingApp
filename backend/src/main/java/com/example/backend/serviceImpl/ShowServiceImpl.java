package com.example.backend.serviceImpl;

import com.example.backend.model.Movie;
import com.example.backend.model.Seat;
import com.example.backend.model.Show;
import com.example.backend.model.requests.ShowRequest;
import com.example.backend.repository.CinemaHallRepository;
import com.example.backend.repository.MovieRepository;
import com.example.backend.repository.ShowRepository;
import com.example.backend.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final CinemaHallRepository cinemaHallRepository;

    @Override
    public Show addShow(ShowRequest showRequest) {
        Movie movie = movieRepository.findById(showRequest.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found"));

        Show show = Show.builder()
                .startTime(showRequest.getStartTime())
                .movie(movie)
                .cinemaHall(cinemaHallRepository.findById(showRequest.getCinemaHallId()).orElseThrow(() -> new RuntimeException("Hall not found")))
                .build();


        show.setSeats( IntStream.range(1, show.getCinemaHall().getRowQuantity() + 1)
                .boxed().flatMap(rowNumber -> IntStream.range(1, show.getCinemaHall().getSeatsPerRow() + 1)
                        .mapToObj(seatNumber -> Seat.builder()
                                .rowNumber(rowNumber)
                                .seatNumber(seatNumber)
                                .isReserved(false)
                                .show(show)
                                .build())
                ).collect(Collectors.toList()));


        movie.getShows().add(show);
        return showRepository.save(show);
    }

    @Override
    public Show getShowById(Long id) {
        return showRepository.findById(id).orElseThrow(() -> new RuntimeException("Show not found"));
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
}
