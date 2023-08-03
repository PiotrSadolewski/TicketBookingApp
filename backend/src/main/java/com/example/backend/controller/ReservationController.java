package com.example.backend.controller;

import com.example.backend.model.requests.ReservationRequest;
import com.example.backend.model.response.ReservationResponse;
import com.example.backend.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<ReservationResponse> addReservation(@Valid @RequestBody ReservationRequest reservationRequest) {
        return ResponseEntity.ok(reservationService.addReservation(reservationRequest));
    }
}
