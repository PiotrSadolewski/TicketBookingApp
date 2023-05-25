package validation;

import java.time.LocalDateTime;

public class MovieValidation {
    public static void validateScreeningDate(LocalDateTime screeningDate) {
        System.out.println(screeningDate);
        if (screeningDate.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Screening date can't be in the past");
        }
    }

}
