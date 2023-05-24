package com.example.backend.controller;

import com.example.backend.model.ScreeningRoom;
import com.example.backend.service.ScreeningRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/screeningRooms")
public class ScreeningRoomController {

    public final ScreeningRoomService screeningRoomService;
    @GetMapping("/all")
    public ResponseEntity<List<ScreeningRoom>> getAllScreeningRooms() {
        return ResponseEntity.ok(screeningRoomService.getAllScreeningRooms());
    }

    @PostMapping("/add")
    public ResponseEntity<ScreeningRoom> addScreeningRoom(@RequestBody ScreeningRoom screeningRoom) {
        return ResponseEntity.ok(screeningRoomService.addScreeningRoom(screeningRoom));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreeningRoom> getScreeningRoomById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(screeningRoomService.getScreeningRoomById(id));
    }

}
