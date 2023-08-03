package com.example.backend.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponse {
    private String title;
    private List<Screening> screenings;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Screening{
        private Long screeningId;
        private LocalDateTime startTime;
    }
}
