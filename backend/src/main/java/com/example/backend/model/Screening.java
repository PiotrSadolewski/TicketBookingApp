package com.example.backend.model;

import constraint.FuturePlus24Hours;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
//    @FuturePlus24Hours
    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @NotNull
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screeningRoom_id")
    @NotNull
    private ScreeningRoom screeningRoom;

    @OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
    @NotEmpty
    private List<Seat> seats;

}