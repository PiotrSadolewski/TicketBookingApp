package com.example.backend.service;

import com.example.backend.model.requests.ReservationRequest;
import com.example.backend.model.Reservation;
import com.example.backend.model.response.ReservationResponse;

import java.util.List;

public interface ReservationService {
    ReservationResponse addReservation(ReservationRequest reservationRequest);
    List<Reservation> getAllReservations();

    Reservation setReservationPaid(Long id);
    Reservation getReservationById(Long id);
}
