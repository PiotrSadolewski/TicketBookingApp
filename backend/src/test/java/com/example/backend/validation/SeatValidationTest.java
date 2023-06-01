package com.example.backend.validation;

import com.example.backend.exception.ValidationException;
import com.example.backend.model.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SeatValidationTest {
    @Test
    public void validateIfSeatIsAvailable_SeatIsReservedFalse_DoesNotThrowException() {
        Seat seat = Seat.builder()
                .isReserved(false)
                .build();
        Assertions.assertDoesNotThrow(() -> SeatValidation.validateIfSeatIsAvailable(seat));
    }

    @Test
    public void validateIfSeatIsAvailable_SeatIsReservedTrue_ThrowsValidationException() {
        Seat seat = Seat.builder()
                .isReserved(true)
                .build();
        Assertions.assertThrows(ValidationException.class, () -> SeatValidation.validateIfSeatIsAvailable(seat));
    }

    @Test
    public void validateSeat_SeatDoNotLeftSinglePlaceOver_DoesNotThrowException(){
        Seat seat = Seat.builder()
                .isReserved(false)
                .seatNumber(3)
                .build();

        Assertions.assertDoesNotThrow(() -> SeatValidation.validateSeat(createListOfSeats(),seat));
    }

    @Test

    public void validateSeat_SeatInMiddleLeftSinglePlaceOver_ThrowException(){
        Seat seat = Seat.builder()
                .isReserved(false)
                .seatNumber(3)
                .build();

        List<Seat> seatsInRow = createListOfSeats();
        seatsInRow.get(0).setIsReserved(true);
        Assertions.assertThrows(ValidationException.class, () -> SeatValidation.validateSeat(seatsInRow,seat));
    }

    @Test
    public void validateSeat_FirstSeatLeftSinglePlaceOver_ThrowException(){
        Seat seat = Seat.builder()
                .isReserved(false)
                .seatNumber(1)
                .build();

        List<Seat> seatsInRow = createListOfSeats();
        seatsInRow.get(2).setIsReserved(true);
        Assertions.assertThrows(ValidationException.class, () -> SeatValidation.validateSeat(seatsInRow,seat));
    }

    @Test
    public void validateSeat_SecondSeatLeftSinglePlaceOver_ThrowsException(){
        Seat seat = Seat.builder()
                .isReserved(false)
                .seatNumber(2)
                .build();

        List<Seat> seatsInRow = createListOfSeats();
        seatsInRow.get(3).setIsReserved(true);
        Assertions.assertThrows(ValidationException.class, () -> SeatValidation.validateSeat(seatsInRow,seat));
    }

    @Test
    public void validateSeat_SecondToLastSeatLeftSinglePlaceOver_ThrowsException(){
        Seat seat = Seat.builder()
                .isReserved(false)
                .seatNumber(4)
                .build();

        List<Seat> seatsInRow = createListOfSeats();
        seatsInRow.get(1).setIsReserved(true);
        Assertions.assertThrows(ValidationException.class, () -> SeatValidation.validateSeat(seatsInRow,seat));
    }

    @Test
    public void validateSeat_LastSeatLeftSinglePlaceOver_ThrowsException(){
        Seat seat = Seat.builder()
                .isReserved(false)
                .seatNumber(5)
                .build();

        List<Seat> seatsInRow = createListOfSeats();
        seatsInRow.get(2).setIsReserved(true);
        Assertions.assertThrows(ValidationException.class, () -> SeatValidation.validateSeat(seatsInRow,seat));
    }

    private List<Seat> createListOfSeats(){
        return List.of(
                Seat.builder()
                        .seatNumber(1)
                        .isReserved(false)
                        .build(),

                Seat.builder()
                        .seatNumber(2)
                        .isReserved(false)
                        .build(),

                Seat.builder()
                        .seatNumber(3)
                        .isReserved(false)
                        .build(),

                Seat.builder()
                        .seatNumber(4)
                        .isReserved(false)
                        .build(),

                Seat.builder()
                        .seatNumber(5)
                        .isReserved(false)
                        .build()
        );
    }
}
