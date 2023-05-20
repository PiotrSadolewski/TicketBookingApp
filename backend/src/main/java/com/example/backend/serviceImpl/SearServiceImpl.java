package com.example.backend.serviceImpl;

import com.example.backend.model.Seat;
import com.example.backend.repository.SeatRepository;
import com.example.backend.service.SearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearServiceImpl implements SearService {

    private final SeatRepository seatRepository;

    @Autowired
    public SearServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat getSeatById(Long id) {
        return seatRepository.findById(id).orElseThrow(() -> new RuntimeException("Seat not found"));
    }

    @Override
    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
}
