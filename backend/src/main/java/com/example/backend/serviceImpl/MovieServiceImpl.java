package com.example.backend.serviceImpl;

import com.example.backend.model.Movie;
import com.example.backend.model.Show;
import com.example.backend.model.response.MovieResponse;
import com.example.backend.repository.MovieRepository;
import com.example.backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public List<MovieResponse> getAllMoviesAndShowsByShowDate(LocalDateTime showDate){
        LocalDateTime timeTo = showDate.withHour(23).withMinute(59).withSecond(59);
        return movieRepository.getMoviesWithShowsByShowsDatePeriod(showDate, timeTo).stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .map(movie -> MovieResponse.builder()
                    .title(movie.getTitle())
                    .shows(movie.getShows().stream()
                            .sorted(Comparator.comparing(Show::getStartTime))
                            .map(show -> MovieResponse.Show.builder()
                                .showId(show.getId())
                                .startTime(show.getStartTime())
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
