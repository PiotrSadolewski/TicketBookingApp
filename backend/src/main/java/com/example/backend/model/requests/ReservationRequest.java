package com.example.backend.model.requests;

import com.example.backend.model.TicketType;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationRequest {
    private String name;
    private String surname;
    private Long screeningId;
    private List<Ticket> tickets;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Ticket {
        private TicketType ticketType;
        private Long seatId;
    }
}
