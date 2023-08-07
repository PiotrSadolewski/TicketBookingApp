package com.example.backend.controller;

import com.example.backend.model.response.ScreeningResponse;
import com.example.backend.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    private final ScreeningService screeningService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<ScreeningResponse> getScreeningById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(screeningService.getScreeningById(id));
    }
}
