package com.example.backend.repository;

import com.example.backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query("SELECT s FROM Seat s WHERE s.show.id = ?1 AND s.isReserved = false ")
    List<Seat> getAvailableSeatsByShowId(Long showId);
}
