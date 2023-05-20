package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer hallNumber;
    private Integer rowQuantity;
    private Integer seatsPerRow;

    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @PreUpdate
    @PrePersist
    public void addSeats(){
        IntStream.rangeClosed(1, rowQuantity)
                .forEach(rowNumber -> IntStream.rangeClosed(1, seatsPerRow)
                        .forEach(seatNumber -> {
                            Seat seat = new Seat();
                            seat.setRowNumber(rowNumber);
                            seat.setSeatNumber(seatNumber);
                            seat.setCinemaHall(this);
                            seats.add(seat);
                        }));
    }

}
