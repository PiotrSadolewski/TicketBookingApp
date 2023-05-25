package com.example.backend.validator;

import constraint.FuturePlus24Hours;
import jakarta.validation.ConstraintValidator;

import java.time.LocalDateTime;

public class FuturePlus24HoursValidator implements ConstraintValidator<FuturePlus24Hours, LocalDateTime>{

    @Override
    public boolean isValid(LocalDateTime localDateTime, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        return localDateTime.isAfter(LocalDateTime.now().plusHours(24));
    }

}
