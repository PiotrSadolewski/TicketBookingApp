package validation;

import com.example.backend.model.Seat;
import validation.exception.SeatException;

public class SeatValidation {

    public static void validateIfSeatIsAvailable(Seat seat) {
        if (seat.getIsReserved()) {
            throw new SeatException(
                    "Seat with row number: " + seat.getRowNumber() + " seat number: " + seat.getSeatNumber() + " is already reserved"
            );
        }
    }

    public static void validateIfSeatIsNull(Seat seat){
        if(seat == null){
            throw new SeatException("Seat is null");
        }
    }


}
