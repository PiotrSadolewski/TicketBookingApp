package com.example.backend.service;

import com.example.backend.model.ScreeningRoom;

import java.util.List;

public interface ScreeningRoomService {
    ScreeningRoom addScreeningRoom(ScreeningRoom screeningRoom);
    List<ScreeningRoom> getAllScreeningRooms();
    ScreeningRoom getScreeningRoomById(Long id);
}
