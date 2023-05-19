package com.example.backend.serviceImpl;

import com.example.backend.model.Movie;
import com.example.backend.repository.MovieRepository;
import com.example.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

   private final MovieRepository movieRepository;

   @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
