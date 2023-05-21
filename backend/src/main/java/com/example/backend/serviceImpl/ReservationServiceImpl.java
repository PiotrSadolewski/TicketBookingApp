package com.example.backend.serviceImpl;

import com.example.backend.model.TicketType;
import com.example.backend.model.requests.*;
import com.example.backend.model.Reservation;
import com.example.backend.model.Seat;
import com.example.backend.model.Ticket;
import com.example.backend.model.response.ReservationResponse;
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
    public ReservationResponse addReservation(ReservationRequest reservationRequest) {
        // Create function to check if seat is reserved


        // Gets information about seats and show from database and creates a list of tickets
        List<Ticket> tickets = reservationRequest.getTickets().stream().map(ticketRequest -> Ticket.builder()
                .ticketType(ticketRequest.getTicketType())
                .seat(seatRepository.findById(ticketRequest.getSeatId()).orElseThrow(() -> new RuntimeException("Seat not found")))
                .show(showRepository.findById(reservationRequest.getShowId()).orElseThrow(() -> new RuntimeException("Show not found")))
                .price(setAutomaticPrice(ticketRequest.getTicketType()))
                .build()).toList();

        // Sets seats as reserved
        setSeatsAsReserved(tickets.stream().map(Ticket::getSeat).toList());

        // Creates a reservation
        Reservation reservation = Reservation.builder()
                .name(reservationRequest.getName())
                .surname(reservationRequest.getSurname())
                .tickets(tickets)
                .totalPrice(tickets.stream().mapToDouble(Ticket::getPrice).sum())
                .build();

        // Saves reservation to database
        reservationRepository.save(reservation);

        // Returns reservation response
        return ReservationResponse.builder()
                    .name(reservation.getName())
                    .surname(reservation.getSurname())
                    .movieTitle(reservation.getTickets().get(0).getShow().getMovie().getTitle())
                    .cinemaHallNumber(reservation.getTickets().get(0).getShow().getCinemaHall().getHallNumber())
                    .startTime(reservation.getTickets().get(0).getShow().getStartTime())
                    .totalPrice(reservation.getTotalPrice())
                    .tickets(reservation.getTickets().stream().map(ticket -> ReservationResponse.Ticket.builder()
                            .ticketType(ticket.getTicketType())
                            .row(ticket.getSeat().getRowNumber())
                            .column(ticket.getSeat().getSeatNumber())
                            .price(ticket.getPrice())
                            .build()).toList())
                    .build();
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
            seat.setIsReserved(true)
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


