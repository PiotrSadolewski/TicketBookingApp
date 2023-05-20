package com.example.backend.model.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationRequest {
    private String name;
    private String surname;
    private List<Ticket> tickets;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Ticket {
        private com.example.backend.model.Ticket.TicketType ticketType;
        private Long seatId;
        private Long showId;
    }
}
