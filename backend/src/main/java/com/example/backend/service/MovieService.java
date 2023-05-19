package com.example.backend.service;

import com.example.backend.model.Movie;

import java.util.List;

public interface MovieService {
    Movie addMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
}
