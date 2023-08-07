package com.example.backend.model.response;

import lombok.*;

import java.time.Duration;
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
    private String imageUrl;
    private String genre;
    private Long duration;

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
