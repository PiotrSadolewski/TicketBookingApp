package com.example.backend.model.response;

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
public class MovieResponse {
    private String title;
    private List<Screening> screenings;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Screening{
        private Long screeningId;
        private LocalDateTime startTime;
    }
}