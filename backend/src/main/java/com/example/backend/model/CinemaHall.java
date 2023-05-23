package com.example.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    private Integer hallNumber;

    @NotNull
    private Integer rowQuantity;

    @NotNull
    private Integer seatsPerRow;

//    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
//    private List<Show> shows;

}
