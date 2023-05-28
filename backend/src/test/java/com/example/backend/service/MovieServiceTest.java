package com.example.backend.service;

import com.example.backend.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;
    @InjectMocks
    private MovieService movieService;
    @Test
    public void getAllMoviesAndScreeningsByScreeningDate_ReturnMovieResponse() {

    }

    @Test
    public void addMovie_ReturnMovie() {

    }
}
