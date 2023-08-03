package com.example.backend.validation;

import com.example.backend.exception.ValidationException;
import com.example.backend.model.Screening;
import com.example.backend.model.Seat;
import com.example.backend.model.TicketType;
import com.example.backend.model.requests.ReservationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ReservationValidationTest {

    @Test
    public void validateReservationTime_ValidReservationTime_DoesNotThrowException() {
        LocalDateTime screeningTime = LocalDateTime.now().plusMinutes(16);
        Assertions.assertDoesNotThrow(() -> ReservationValidation.validateReservationTime(screeningTime));
    }

    @Test
    public void validateReservationTime_InvalidReservationTime_ThrowsValidationException() {
        LocalDateTime screeningTime = LocalDateTime.now().minusMinutes(16);
        Assertions.assertThrows(ValidationException.class, () -> ReservationValidation.validateReservationTime(screeningTime));
    }

    @Test
    public void validateIfSeatHaveGoodScreeningId_ValidScreeningId_DoesNotThrowException() {
        Seat seat = Seat.builder()
                .isReserved(false)
                .screening(Screening.builder()
                        .id(1L)
                        .build())
                .build();
        Assertions.assertDoesNotThrow(() -> ReservationValidation.validateIfSeatHaveGoodScreeningId(seat, 1L));
    }

    @Test
    public void validateIfSeatHaveGoodScreeningId_InvalidScreeningId_ThrowsValidationException() {
        Seat seat = Seat.builder()
                .isReserved(false)
                .screening(Screening.builder()
                        .id(1L)
                        .build())
                .build();
        Assertions.assertThrows(ValidationException.class, () -> ReservationValidation.validateIfSeatHaveGoodScreeningId(seat, 2L));
    }

    @Test
    public void validateIfTicketListIsEmpty_ValidTicketList_DoesNotThrowException() {
        Assertions.assertDoesNotThrow(() ->
                ReservationValidation.validateIfTicketListIsEmpty(List.of(ReservationRequest.Ticket.builder()
                .seatId(1L)
                .ticketType(TicketType.ADULT)
                .build()))
        );
    }

    @Test
    public void validateIfTicketListIsEmpty_InvalidTicketList_ThrowsValidationException() {
        Assertions.assertThrows(ValidationException.class, () ->
                ReservationValidation.validateIfTicketListIsEmpty(List.of())
        );
    }

    @Test
    public void validateIfTicketListIsNull_ValidTicketList_DoesNotThrowException() {
        Assertions.assertDoesNotThrow(() ->
                ReservationValidation.validateIfTicketListIsNull(List.of(ReservationRequest.Ticket.builder()
                .seatId(1L)
                .ticketType(TicketType.ADULT)
                .build()))
        );
    }

    @Test
    public void validateIfTicketListIsNull_InvalidTicketList_ThrowsValidationException() {
        Assertions.assertThrows(ValidationException.class, () ->
                ReservationValidation.validateIfTicketListIsNull(null)
        );
    }
}
