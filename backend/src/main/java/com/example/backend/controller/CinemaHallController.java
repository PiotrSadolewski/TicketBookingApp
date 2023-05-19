package com.example.backend.controller;

import com.example.backend.model.CinemaHall;
import com.example.backend.service.CinemaHallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemaHalls")
public class CinemaHallController {

    public final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CinemaHall>> getAllCinemaHalls() {
        return ResponseEntity.ok(cinemaHallService.getAllCinemaHalls());
    }

    @PostMapping("/add")
    public ResponseEntity<CinemaHall> addCinemaHall(@RequestBody  CinemaHall cinemaHall) {
        return ResponseEntity.ok(cinemaHallService.addCinemaHall(cinemaHall));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaHall> getCinemaHallById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cinemaHallService.getCinemaHallById(id));
    }

}
