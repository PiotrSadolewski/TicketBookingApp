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
    private List<Show> shows;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Show{
        private Long showId;
        private LocalDateTime startTime;
    }
}
