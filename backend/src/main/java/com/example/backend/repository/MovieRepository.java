package com.example.backend.repository;

import com.example.backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m JOIN FETCH m.shows s WHERE s.startTime BETWEEN ?1 AND ?2")
    List<Movie> getMoviesWithShowsByShowsDatePeriod(LocalDateTime timeFrom, LocalDateTime timeTo);

}

