package com.example.backend.model.response;

import com.example.backend.model.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationResponse {
    private String name;
    private String surname;
    private String movieTitle;
    private Integer cinemaHallNumber;
    private LocalDateTime startTime;
    private Double totalPrice;
    private List<Ticket> tickets;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Ticket {
        private TicketType ticketType;
        private Integer row;
        private Integer column;
        private Double price;
    }

}