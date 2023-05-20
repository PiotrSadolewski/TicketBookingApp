package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @OneToOne
    @JoinColumn(name = "show_id")
    private Show show;

     public enum TicketType {
        ADULT,
        CHILD,
        STUDENT
    }

}

