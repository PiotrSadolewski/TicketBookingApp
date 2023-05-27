package com.example.backend.validation;

import com.example.backend.exception.ValidationException;
import com.example.backend.model.Seat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
    public void validateIfSeatIsNull_SeatNotNull_DoesNotThrowException(){
        Seat seat = Seat.builder()
                .isReserved(true)
                .build();
        Assertions.assertDoesNotThrow(() -> SeatValidation.validateIfSeatIsNull(seat));
    }

    @Test
    public void validateIfSeatIsNull_SeatNull_ThrowsValidationException(){
        Seat seat = null;
        Assertions.assertThrows(ValidationException.class, () -> SeatValidation.validateIfSeatIsNull(seat));
    }


}
