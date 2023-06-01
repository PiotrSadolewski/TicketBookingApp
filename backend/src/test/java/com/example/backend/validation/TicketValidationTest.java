package com.example.backend.validation;

import com.example.backend.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.backend.model.TicketType.ADULT;

@ExtendWith(MockitoExtension.class)
public class TicketValidationTest {

    @Test
    public void validateIfTicketSeatIdIsNull_DoesNotThrowException(){
        Long seatId = 1L;
        Assertions.assertDoesNotThrow(() -> TicketValidation.validateIfTicketSeatIdIsNull(seatId));
    }

    @Test
    public void validateIfTicketSeatIdIsNull_ThrowsValidationException(){
        Long seatId = null;
        Assertions.assertThrows(ValidationException.class, () -> TicketValidation.validateIfTicketSeatIdIsNull(seatId));
    }

    @Test
    public void validateIfTicketTypeIsNull_DoesNotThrowException(){
        Assertions.assertDoesNotThrow(() -> TicketValidation.validateIfTicketTypeIsNull(ADULT));
    }

    @Test
    public void validateIfTicketTypeIsNull_DoestThrowValidationException(){
        Assertions.assertThrows(ValidationException.class, () -> TicketValidation.validateIfTicketTypeIsNull(null));
    }

    @Test
    public void validateIfTicketTypeIsNotValid_DoesNotThrowException(){
        Assertions.assertDoesNotThrow(() -> TicketValidation.validateIfTicketTypeIsNotValid(ADULT));
    }

}
