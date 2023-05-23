package com.example.backend.controller;

import com.example.backend.model.Seat;
import com.example.backend.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {
    public final SeatService seatService;
    @GetMapping("byShowId/{id}")
    public ResponseEntity<List<Seat>> getAvailableSeatsByShowId(@PathVariable Long id) {
        return ResponseEntity.ok(seatService.getAvailableSeatsByShowId(id));
    }
}
