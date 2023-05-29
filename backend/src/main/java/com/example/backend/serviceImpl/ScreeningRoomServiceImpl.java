package com.example.backend.serviceImpl;

import com.example.backend.model.ScreeningRoom;
import com.example.backend.repository.ScreeningRoomRepository;
import com.example.backend.service.ScreeningRoomService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.exception.NotFoundException;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ScreeningRoomServiceImpl implements ScreeningRoomService {
    private final ScreeningRoomRepository screeningRoomRepository;

    @Override
    public ScreeningRoom addScreeningRoom(ScreeningRoom screeningRoom) {
        return screeningRoomRepository.save(screeningRoom);
    }

    @Override
    public List<ScreeningRoom> getAllScreeningRooms() {
        return screeningRoomRepository.findAll();
    }

    @Override
    public ScreeningRoom getScreeningRoomById(Long id) {
        return screeningRoomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ScreeningRoom with ID: " + id + " not found"));
    }
}
