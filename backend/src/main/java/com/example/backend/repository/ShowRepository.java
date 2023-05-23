package com.example.backend.repository;

import com.example.backend.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    @Query("SELECT s FROM Show s WHERE s.startTime BETWEEN ?1 AND ?2")
    List<Show> getShowsByPeriod(LocalDateTime from, LocalDateTime to);

    @Query("SELECT s FROM Show s WHERE DATE(s.startTime) = ?1")
    List<Show> getShowsOnChosenDate(LocalDate date);

}
