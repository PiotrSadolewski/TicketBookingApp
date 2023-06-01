package com.example.backend.model.response;

import com.example.backend.model.TicketType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationResponse {
    private String name;
    private String surname;
    private String movieTitle;
    private Integer screeningRoomNumber;
    private LocalDateTime startTime;
    private BigDecimal totalPrice;
    private List<Ticket> tickets;
    private LocalDateTime expirationTime;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Ticket {
        private TicketType ticketType;
        private Integer row;
        private Integer seatNumber;
        private BigDecimal price;
    }

}