package com.example.backend.serviceImpl;

import com.example.backend.model.TicketType;
import com.example.backend.model.requests.*;
import com.example.backend.model.Reservation;
import com.example.backend.model.Seat;
import com.example.backend.model.Ticket;
import com.example.backend.repository.ReservationRepository;
import com.example.backend.repository.SeatRepository;
import com.example.backend.repository.ShowRepository;
import com.example.backend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;
    @Override
    public Reservation addReservation(ReservationRequest reservationRequest) {

        List<Ticket> tickets = reservationRequest.getTickets().stream().map(ticketRequest -> Ticket.builder()
                .ticketType(ticketRequest.getTicketType())
                .seat(seatRepository.findById(ticketRequest.getSeatId()).orElseThrow(() -> new RuntimeException("Seat not found")))
                .show(showRepository.findById(ticketRequest.getShowId()).orElseThrow(() -> new RuntimeException("Show not found")))
                .price(setAutomaticPrice(ticketRequest.getTicketType()))
                .build()).toList();

        setSeatsAsReserved(tickets.stream().map(Ticket::getSeat).toList());

        Reservation reservation = Reservation.builder()
                .name(reservationRequest.getName())
                .surname(reservationRequest.getSurname())
                .tickets(tickets)
                .totalPrice(tickets.stream().mapToDouble(Ticket::getPrice).sum())
                .build();

        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    private void setSeatsAsReserved(List<Seat> seats) {
        seats.forEach(seat ->
            seat.setReserved(true)
        );
    }

    private Double setAutomaticPrice(TicketType ticketType) {
        switch (ticketType) {
            case ADULT -> {
                return  25.00;
            }
            case CHILD -> {
                return  18.00;
            }
            case STUDENT -> {
                return 12.50;
            }
            default -> throw new IllegalArgumentException("Invalid ticket type");
        }
    }

}


