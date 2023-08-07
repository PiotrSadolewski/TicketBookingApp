package com.example.backend.controller;

import com.example.backend.model.response.MovieResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.MovieService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    public final MovieService movieService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all/byScreeningDate")
    public ResponseEntity<List<MovieResponse>> getAllMoviesAndScreeningsByScreeningDate(
            @RequestParam("screeningDate") @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime screeningDate) {
        return ResponseEntity.ok(movieService.getAllMoviesAndScreeningsByScreeningDate(screeningDate));
    }
}
