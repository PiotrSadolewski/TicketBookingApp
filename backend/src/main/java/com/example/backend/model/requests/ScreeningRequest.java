package com.example.backend.model.requests;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScreeningRequest {
    private LocalDateTime startTime;
    private Long movieId;
    private Long screeningRoomId;
}
