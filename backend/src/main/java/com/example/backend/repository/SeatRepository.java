package com.example.backend.repository;

import com.example.backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query("SELECT s FROM Seat s WHERE s.screening.id = ?1 AND s.isReserved = false ")
    List<Seat> getAvailableSeatsByScreeningId(Long screeningId);

    @Query("SELECT s FROM Seat s WHERE s.rowNumber = ?1 AND s.screening.id = ?2")
    List<Seat> getListOfSeatsByRowAndScreeningId(Long screeningId, Integer rowNumber);
}
