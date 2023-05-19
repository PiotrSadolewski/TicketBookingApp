package com.example.backend.controller;

import com.example.backend.model.Show;
import com.example.backend.service.ShowService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Show>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @PostMapping("/add")
    public ResponseEntity<Show> addShow(@RequestBody Show show) {
        return ResponseEntity.ok(showService.addShow(show));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping
    public ResponseEntity<List<Show>> getShowByPeriod(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        List<Show> shows = showService.getShowsByPeriod(from, to);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Show>> getShowsByDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date) {
        List<Show> shows = showService.getShowsOnChosenDate(date);
        return ResponseEntity.ok(shows);
    }


}
