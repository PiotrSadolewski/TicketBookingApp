package com.example.backend.service;

import com.example.backend.model.requests.ReservationRequest;
import com.example.backend.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(ReservationRequest reservationRequest);
    List<Reservation> getAllReservations();
    Reservation getReservationById(Long id);
}
