package com.example.backend.serviceImpl;

import com.example.backend.model.Ticket;
import com.example.backend.repository.TicketRepository;
import com.example.backend.service.TicketService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.exception.NotFoundException;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket with ID: " + id + "not found"));
    }
}