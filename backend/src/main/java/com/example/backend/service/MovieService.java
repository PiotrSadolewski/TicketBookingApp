package com.example.backend.service;

import com.example.backend.model.Movie;
import com.example.backend.model.response.MovieResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieService {
    Movie addMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    List<MovieResponse> getAllMoviesAndScreeningsByScreeningDate(LocalDateTime screeningDate);
}
