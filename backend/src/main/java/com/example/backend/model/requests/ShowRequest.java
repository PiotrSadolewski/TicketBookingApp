package com.example.backend.model.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowRequest {
    private LocalDateTime startTime;
    private Long movieId;
    private Long cinemaHallId;
}
