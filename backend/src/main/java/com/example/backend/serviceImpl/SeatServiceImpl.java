package com.example.backend.serviceImpl;

import com.example.backend.model.Seat;
import com.example.backend.repository.SeatRepository;
import com.example.backend.repository.ShowRepository;
import com.example.backend.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

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

    @Override
    public List<Seat> getAvailableSeatsByShowId(Long showId) {
        return seatRepository.getAvailableSeatsByShowId(showId);
    }

}
