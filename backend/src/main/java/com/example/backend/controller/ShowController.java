package com.example.backend.controller;

import com.example.backend.model.Show;
import com.example.backend.model.requests.ShowRequest;
import com.example.backend.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shows")
public class ShowController {
    private final ShowService showService;

    @GetMapping("/all")
    public ResponseEntity<List<Show>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @PostMapping("/add")
    public ResponseEntity<Show> addShow(@RequestBody ShowRequest showRequest) {
        return ResponseEntity.ok(showService.addShow(showRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(showService.getShowById(id));
    }


}
