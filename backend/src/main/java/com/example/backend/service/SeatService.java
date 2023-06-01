package com.example.backend.service;

import com.example.backend.model.Seat;

import java.util.List;

public interface SeatService {
    Seat getSeatById(Long id);

    Seat addSeat(Seat seat);

    List<Seat> getAllSeats();

    List<Seat> getAvailableSeatsByScreeningId(Long screeningId);
}