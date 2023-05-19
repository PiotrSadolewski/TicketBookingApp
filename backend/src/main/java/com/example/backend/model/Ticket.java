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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    private double price;

    @ManyToOne()
    @JoinColumn(name = "reservation_id")
    @JsonBackReference()
    private Reservation reservation;


    @PreUpdate
    @PrePersist
    private void updatePrice() {
        switch (ticketType) {
            case ADULT -> price = 25.0;
            case CHILD -> price = 18.0;
            case STUDENT -> price = 12.50;
            default -> throw new IllegalArgumentException("Invalid ticket type");
        }

    }
}

enum TicketType {
    ADULT, CHILD, STUDENT
}