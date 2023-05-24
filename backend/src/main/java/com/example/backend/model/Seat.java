package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer rowNumber;

    @NotNull
    private Integer seatNumber;

    @NotNull
    private Boolean isReserved;

    @ManyToOne()
    @JoinColumn(name = "screening_id")
    @JsonBackReference()
    @NotNull
    private Screening screening;
}
