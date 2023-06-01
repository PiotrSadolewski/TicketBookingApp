package com.example.backend.service;

import com.example.backend.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket addTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
}
