package com.example.backend.serviceImpl;

import com.example.backend.model.*;
import com.example.backend.model.requests.ReservationRequest;
import com.example.backend.model.Reservation;
import com.example.backend.repository.ReservationRepository;
import com.example.backend.repository.ScreeningRepository;
import com.example.backend.repository.SeatRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceImplTest {

    @Mock
    private ScreeningRepository screeningRepository;

    @Mock
    private SeatRepository seatRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    private final Movie movie = Movie.builder()
            .id(1L)
            .title("Test Movie")
            .description("Test Description")
            .duration(Duration.ofMinutes(120))
            .filmDirector("Test Director")
            .genre("Test Genre")
            .build();

    private final ScreeningRoom screeningRoom = ScreeningRoom.builder()
            .id(1L)
            .number(1)
            .rowQuantity(1)
            .seatsPerRow(1)
            .build();

    private final Screening screening = Screening.builder()
            .id(1L)
            .screeningRoom(screeningRoom)
            .startTime(LocalDateTime.now().plusMinutes(30))
            .movie(movie)
            .build();

    private final Seat seat = Seat.builder()
            .id(1L)
            .rowNumber(1)
            .seatNumber(1)
            .screening(screening)
            .isReserved(false)
            .build();

    private final ReservationRequest.Ticket reservationRequestTicket = ReservationRequest.Ticket.builder()
            .seatId(seat.getId())
            .ticketType(TicketType.ADULT)
            .build();

    private final Ticket ticket = Ticket.builder()
            .id(1L)
            .seat(seat)
            .ticketType(TicketType.ADULT)
            .price(BigDecimal.valueOf(25))
            .build();

    private final ReservationRequest validReservationRequest = ReservationRequest.builder()
            .screeningId(screening.getId())
            .name("John")
            .surname("Doe")
            .tickets(List.of(reservationRequestTicket))
            .build();

    private final Reservation reservation = Reservation.builder()
            .id(1L)
            .expirationTime(LocalDateTime.now().plusMinutes(10))
            .name("John")
            .surname("Doe")
            .tickets(List.of(ticket))
            .build();

    @Test
    void addReservation_ValidRequest_ReturnsReservationResponse() {

        when(screeningRepository.findById(validReservationRequest.getScreeningId()))
                .thenReturn(Optional.of(screening));

        when(seatRepository.findById(anyLong()))
                .thenReturn(Optional.of(seat));

        when(seatRepository.getListOfSeatsByRowAndScreeningId(anyLong(), anyInt()))
                .thenReturn(List.of(seat, seat, seat, seat));

        when(reservationRepository.save(Mockito.any(Reservation.class)))
                .thenReturn(reservation);

        Assertions.assertDoesNotThrow(() -> reservationService.addReservation(validReservationRequest));
    }
}