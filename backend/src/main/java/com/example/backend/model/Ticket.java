package com.example.backend.model;

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