package com.example.backend.service;

import com.example.backend.model.Seat;

import java.util.List;

public interface SearService {
    Seat getSeatById(Long id);
    Seat addSeat(Seat seat);
    List<Seat> getAllSeats();
}
