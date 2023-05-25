package constraint;

import com.example.backend.validator.FuturePlus24HoursValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FuturePlus24HoursValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FuturePlus24Hours {
    String message() default "Screening date must be at least 24 hours in the future";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
