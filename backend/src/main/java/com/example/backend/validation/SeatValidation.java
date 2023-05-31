package com.example.backend.validation;

import com.example.backend.model.Seat;
import com.example.backend.exception.ValidationException;
import java.util.List;

public class SeatValidation {
    public static void validateIfSeatIsAvailable(Seat seat) {
        if (seat.getIsReserved()) {
            throw new ValidationException(
                    "Seat with row number: " + seat.getRowNumber() + " seat number: " + seat.getSeatNumber() + " is already reserved"
            );
        }
    }

    public static void validateIfSeatDoNotLeftPlaceOverInARow(List<Seat> seats, Seat seat){
        validateIfSeatIsAvailable(seat);

        if (seat.getSeatNumber() == 1)
            validateLeftEdge(seats, seat);

        if (seat.getSeatNumber() == seats.size())
            validateRightEdge(seats, seat);

        if (seat.getSeatNumber() >= 3 && seat.getSeatNumber() <= seats.size() - 2){
            validateSeatInMiddle(seats, seat);
        }

        if (seat.getSeatNumber() == 2){
            Boolean leftSeat = seats.get(seat.getSeatNumber() - 2).getIsReserved();
            Boolean rightSeat = seats.get(seat.getSeatNumber()).getIsReserved();
            Boolean secondRightSeat = seats.get(seat.getSeatNumber() + 1).getIsReserved();

            if (!leftSeat && !rightSeat && secondRightSeat)
                throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
        }

        if (seat.getSeatNumber() == seats.size() - 1){
            Boolean rightSeat = seats.get(seat.getSeatNumber()).getIsReserved();
            Boolean leftSeat = seats.get(seat.getSeatNumber() - 2).getIsReserved();
            Boolean secondLeftSeat = seats.get(seat.getSeatNumber() - 3).getIsReserved();

           if (!rightSeat && !leftSeat && secondLeftSeat)
                throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
        }
    }

    public static void validateLeftEdge(List<Seat> seats, Seat seat){
        Boolean rightSeat = seats.get(seat.getSeatNumber()).getIsReserved();
        Boolean secondRightSeat = seats.get(seat.getSeatNumber() + 1).getIsReserved();
        if (!rightSeat && secondRightSeat)
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
    }

    public static void validateRightEdge(List<Seat> seats, Seat seat){
        Boolean leftSeat = seats.get(seat.getSeatNumber() - 2).getIsReserved();
        Boolean secondLeftSeat = seats.get(seat.getSeatNumber() - 3).getIsReserved();
        if (!leftSeat && secondLeftSeat)
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
    }

    public static void validateSeatInMiddle(List<Seat> seats, Seat seat){
        Boolean leftSeat = seats.get(seat.getSeatNumber() - 2).getIsReserved();
        Boolean secondLeftSeat = seats.get(seat.getSeatNumber() - 3).getIsReserved();
        Boolean rightSeat = seats.get(seat.getSeatNumber()).getIsReserved();
        Boolean secondRightSeat = seats.get(seat.getSeatNumber() + 1).getIsReserved();

        if (!leftSeat && !rightSeat && secondLeftSeat && secondRightSeat)
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
        if (!leftSeat && secondLeftSeat && !rightSeat && !secondRightSeat)
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
        if (!rightSeat && secondRightSeat && !leftSeat && !secondLeftSeat)
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
    }
}
