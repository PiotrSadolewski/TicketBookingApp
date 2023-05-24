package com.example.backend.model.requests;

import com.example.backend.model.TicketType;
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
    private Long screeningRoomId;
    private List<Ticket> tickets;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Ticket {
        private TicketType ticketType;
        private Long seatId;
    }
}
