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

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;
    @Override
    public ReservationResponse addReservation(ReservationRequest reservationRequest) {

        // Creates reservation object
        Reservation reservation = Reservation.builder()
                .name(reservationRequest.getName())
                .surname(reservationRequest.getSurname())
                .build();

        // Creates tickets objects and checks if seats are available
        List<Ticket> tickets = reservationRequest.getTickets().stream().map(ticketRequest -> {
            Seat seat = seatRepository.findById(ticketRequest.getSeatId()).orElseThrow(() -> new RuntimeException("Seat not found"));
            if (seat.getIsReserved()) {
                throw new RuntimeException(
                        "Seat with row number: " + seat.getRowNumber() + " seat number: " + seat.getSeatNumber() + " is already reserved"
                );
            }
            seat.setIsReserved(true);
            return Ticket.builder()
                    .ticketType(ticketRequest.getTicketType())
                    .seat(seat)
                    .show(showRepository.findById(reservationRequest.getShowId()).orElseThrow(() -> new RuntimeException("Show not found")))
                    .price(setAutomaticPrice(ticketRequest.getTicketType()))
                    .reservation(reservation)
                    .build();
        }).toList();

        // Sets tickets and total price to reservation
        reservation.setTickets(tickets);
        reservation.setTotalPrice(tickets.stream().reduce(BigDecimal.ZERO, (subtotal, ticket) -> subtotal.add(ticket.getPrice()), BigDecimal::add));


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

    private BigDecimal setAutomaticPrice(TicketType ticketType) {
        switch (ticketType) {
            case ADULT -> {
                return  new BigDecimal("25.00");
            }
            case CHILD -> {
                return  new BigDecimal("18.00");
            }
            case STUDENT -> {
                return new BigDecimal("12.50");
            }
            default -> throw new IllegalArgumentException("Invalid ticket type");
        }
    }

}


