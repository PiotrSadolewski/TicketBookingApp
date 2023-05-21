package com.example.backend.serviceImpl;

import com.example.backend.model.CinemaHall;
import com.example.backend.model.Seat;
import com.example.backend.repository.CinemaHallRepository;
import com.example.backend.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        addSeats(cinemaHall);
        return cinemaHallRepository.save(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAllCinemaHalls() {
        return cinemaHallRepository.findAll();
    }

    @Override
    public CinemaHall getCinemaHallById(Long id) {
        return cinemaHallRepository.findById(id).orElseThrow(() -> new RuntimeException("CinemaHall not found"));
    }

    private void addSeats(CinemaHall cinemaHall){
        IntStream.rangeClosed(1, cinemaHall.getRowQuantity())
                .forEach(rowNumber -> IntStream.rangeClosed(1, cinemaHall.getSeatsPerRow())
                        .forEach(seatNumber -> {
                            Seat seat = new Seat();
                            seat.setRowNumber(rowNumber);
                            seat.setSeatNumber(seatNumber);
                            seat.setCinemaHall(cinemaHall);
                            seat.setIsReserved(false);
                            cinemaHall.getSeats().add(seat);
                        }));
    }
}
