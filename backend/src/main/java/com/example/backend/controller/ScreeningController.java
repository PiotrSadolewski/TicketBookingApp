package com.example.backend.controller;

import com.example.backend.model.Screening;
import com.example.backend.model.requests.ScreeningRequest;
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

    @PostMapping("/add")
    public ResponseEntity<Screening> addScreeningWithSeats(@RequestBody ScreeningRequest screeningRequest) {
        return ResponseEntity.ok(screeningService.addScreeningWithSeats(screeningRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreeningResponse> getScreeningById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(screeningService.getScreeningById(id));
    }


}
