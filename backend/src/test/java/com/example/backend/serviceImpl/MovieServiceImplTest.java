package com.example.backend.serviceImpl;

import com.example.backend.exception.ValidationException;
import com.example.backend.model.Movie;
import com.example.backend.model.Screening;
import com.example.backend.model.response.MovieResponse;
import com.example.backend.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MovieServiceImplTest {
    @Mock
    private MovieRepository movieRepository;
    @InjectMocks
    private MovieServiceImpl movieService;

    @Test
    public void getAllMoviesAndScreeningsByScreeningDate_NullScreeningDate_ReturnsMovieResponse() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            movieService.getAllMoviesAndScreeningsByScreeningDate(null);
        });
    }
    @Test
    public void getAllMoviesAndScreeningsByScreeningDate_InvalidScreeningDate_ReturnsMovieResponse() {
        Assertions.assertThrows(ValidationException.class, () -> {
            movieService.getAllMoviesAndScreeningsByScreeningDate(LocalDateTime.now().minusSeconds(30));
        });
    }
    @Test
    public void getAllMoviesAndScreeningsByScreeningDate_ValidScreeningDate_ReturnsMovieResponse() {
        // given
        Movie movie = Movie.builder()
                .title("title")
                .screenings(List.of(Screening.builder()
                        .startTime(LocalDateTime.now().plusDays(1))
                        .build()))
                .build();

        when(movieRepository.getMoviesWithScreeningsByScreeningsDatePeriod(any(), any())).thenReturn(List.of(movie));

        // when
        List<MovieResponse> movieResponses =  movieService.getAllMoviesAndScreeningsByScreeningDate(LocalDateTime.now().plusSeconds(30));

        // then
        Assertions.assertEquals(1, movieResponses.size());
    }
}
