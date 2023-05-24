package com.example.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScreeningResponse {
    private Integer screeningRoomNumber;
    private List<Seat> seats;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Seat {
        private Long id;
        private Integer row;
        private Integer seatNumber;
    }
}
