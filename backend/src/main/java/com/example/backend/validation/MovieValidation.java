package com.example.backend.validation;

import com.example.backend.exception.ValidationException;

import java.time.LocalDateTime;

public class MovieValidation {
    public static void validateScreeningDate(LocalDateTime screeningDate) {
        if (screeningDate.isBefore(LocalDateTime.now())) {
            throw new ValidationException("Screening date can't be in the past");
        }
    }

}
