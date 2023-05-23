package com.example.backend.controller;

import com.example.backend.model.Movie;
import com.example.backend.model.response.MovieResponse;
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

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/all/byShowDate")
    public ResponseEntity<List<MovieResponse>> getAllMoviesAndShowsByShowDate(
            @RequestParam("showDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime showDate) {
        return ResponseEntity.ok(movieService.getAllMoviesAndShowsByShowDate(showDate));
    }
}
