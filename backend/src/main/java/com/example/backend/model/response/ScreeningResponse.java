package com.example.backend.model.response;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScreeningResponse {
    private Integer screeningRoomNumber;
    private List<Seat> seats;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Seat {
        private Long id;
        private Integer row;
        private Integer seatNumber;
        private boolean isReserved;
    }
}
