package com.example.backend.controller;

import com.example.backend.model.requests.ReservationRequest;
import com.example.backend.model.Reservation;
import com.example.backend.model.response.ReservationResponse;
import com.example.backend.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public ResponseEntity<ReservationResponse> addReservation(@Valid @RequestBody ReservationRequest reservationRequest) {
        return ResponseEntity.ok(reservationService.addReservation(reservationRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PutMapping("/setPaid/{id}")
    public ResponseEntity<Reservation> setReservationPaid(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.setReservationPaid(id));
    }
}
