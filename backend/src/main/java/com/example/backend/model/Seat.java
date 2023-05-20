package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rowNumber;
    private Integer seatNumber;

    @Column(columnDefinition="bit default 0")
    private boolean isReserved;

    @ManyToOne()
    @JoinColumn(name = "cinema_hall_id")
    @JsonBackReference()
    private CinemaHall cinemaHall;
}
