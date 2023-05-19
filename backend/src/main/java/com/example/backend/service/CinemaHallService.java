package com.example.backend.service;

import com.example.backend.model.CinemaHall;

import java.util.List;

public interface CinemaHallService {
    CinemaHall addCinemaHall(CinemaHall cinemaHall);
    List<CinemaHall> getAllCinemaHalls();
    CinemaHall getCinemaHallById(Long id);
}
