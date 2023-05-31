package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Duration;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String filmDirector;

    @NotNull
    private String genre;

    @NotNull
    private Duration duration;

    @JsonBackReference
    @OneToMany(mappedBy = "movie")
    private List<Screening> screenings;
}
