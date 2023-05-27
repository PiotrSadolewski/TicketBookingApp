package com.example.backend.serviceImpl;

import com.example.backend.model.Movie;
import com.example.backend.model.Screening;
import com.example.backend.model.response.MovieResponse;
import com.example.backend.repository.MovieRepository;
import com.example.backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.validation.MovieValidation;
import com.example.backend.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieServiceImpl implements MovieService {

   private final MovieRepository movieRepository;
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie with ID: " + id + "not found"));
    }

    @Override
    public List<MovieResponse> getAllMoviesAndScreeningsByScreeningDate(LocalDateTime screeningDate){
        MovieValidation.validateScreeningDate(screeningDate);
        LocalDateTime timeTo = screeningDate.withHour(23).withMinute(59).withSecond(59);
        return movieRepository.getMoviesWithScreeningsByScreeningsDatePeriod(screeningDate, timeTo).stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .map(movie -> MovieResponse.builder()
                    .title(movie.getTitle())
                    .screenings(movie.getScreenings().stream()
                            .sorted(Comparator.comparing(Screening::getStartTime))
                            .map(screening -> MovieResponse.Screening.builder()
                                .screeningId(screening.getId())
                                .startTime(screening.getStartTime())
                                .build())
                            .collect(Collectors.toList()))
                    .build())
                .toList();

    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
