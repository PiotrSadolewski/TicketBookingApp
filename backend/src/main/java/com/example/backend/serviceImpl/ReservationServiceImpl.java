package com.example.backend.serviceImpl;

import com.example.backend.model.*;
import com.example.backend.model.requests.*;
import com.example.backend.model.response.ReservationResponse;
import com.example.backend.repository.ReservationRepository;
import com.example.backend.repository.SeatRepository;
import com.example.backend.repository.ShowRepository;
import com.example.backend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;
    @Override
    public ReservationResponse addReservation(ReservationRequest reservationRequest) {

        Show show = showRepository.findById(reservationRequest.getShowId()).orElseThrow(() -> new RuntimeException("Show not found"));

        if (Duration.between(LocalDateTime.now(), show.getStartTime()).toMinutes() < 15){
               throw new RuntimeException("You can't reserve tickets for show that starts in less than 15 minutes or has already started");
        }

        // Creates reservation object
        Reservation reservation = Reservation.builder()
                .name(reservationRequest.getName())
                .surname(reservationRequest.getSurname())
                .expirationTime(show.getStartTime().minusMinutes(5))
                .isPaid(false)
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
                    .movieTitle(show.getMovie().getTitle())
                    .cinemaHallNumber(show.getCinemaHall().getHallNumber())
                    .startTime(show.getStartTime())
                    .totalPrice(reservation.getTotalPrice())
                    .expirationTime(reservation.getExpirationTime())
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
    public Reservation setReservationPaid(Long id) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setIsPaid(true);
            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new RuntimeException("Reservation not found"));
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
            default -> throw new RuntimeException("Invalid ticket type");
        }
    }

}


