package com.example.backend.serviceImpl;

import com.example.backend.model.CinemaHall;
import com.example.backend.repository.CinemaHallRepository;
import com.example.backend.service.CinemaHallService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;

    @Override
    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
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
}
