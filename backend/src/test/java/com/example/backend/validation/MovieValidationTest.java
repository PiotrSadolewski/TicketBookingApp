package com.example.backend.validation;

import com.example.backend.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class MovieValidationTest {

    @Test
    void validateScreeningDate_ValidScreeningDate_DoesNotThrowException() {
        LocalDateTime screeningDate = LocalDateTime.now().plusDays(1);
        Assertions.assertDoesNotThrow(() -> MovieValidation.validateScreeningDate(screeningDate));
    }

    @Test
    void validateScreeningDate_ScreeningDateInPast_ThrowsValidationException() {
        LocalDateTime screeningDate = LocalDateTime.now().minusDays(1);
        Assertions.assertThrows(ValidationException.class, () -> MovieValidation.validateScreeningDate(screeningDate));
    }

}
