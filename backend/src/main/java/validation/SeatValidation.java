package validation;

import com.example.backend.model.Seat;
import com.example.backend.exception.ValidationException;

public class SeatValidation {

    public static void validateIfSeatIsAvailable(Seat seat) {
        if (seat.getIsReserved()) {
            throw new ValidationException(
                    "Seat with row number: " + seat.getRowNumber() + " seat number: " + seat.getSeatNumber() + " is already reserved"
            );
        }
    }

    public static void validateIfSeatIsNull(Seat seat){
        if(seat == null){
            throw new ValidationException("Seat is null");
        }
    }


}
