package com.example.backend.validation;

import com.example.backend.model.Seat;
import com.example.backend.exception.ValidationException;
import lombok.Setter;

import java.util.List;
public class SeatValidation {
    private static final int FIRST_SEAT_IN_ROW = 1;
    private static final int SECOND_SEAT_IN_ROW = 2;
    private static final int THIRD_SEAT_IN_ROW = 3;

    public static void validateIfSeatIsAvailable(Seat seat) {
        if (seat.getIsReserved()) {
            throw new ValidationException(
                    "Seat with row number: " + seat.getRowNumber() + " seat number: " + seat.getSeatNumber() + " is already reserved"
            );
        }
    }

    public static void validateSeat(List<Seat> seatsInRow, Seat seat){
        //Validate if seat is available
        validateIfSeatIsAvailable(seat);

        int seatNumber = seat.getSeatNumber();
        int seatsInRowSize = seatsInRow.size();

        if (seatNumber == FIRST_SEAT_IN_ROW)
            validateLeftEdge(seatsInRow, seatNumber);

        //Validate if last seat in a row do not left single place over between reserved seats
        if (seatNumber == seatsInRowSize)
            validateRightEdge(seatsInRow, seatNumber);

        //Validate if middle seats do not left single place over between reserved seats
        if (seatNumber >= THIRD_SEAT_IN_ROW && seat.getSeatNumber() <= seatsInRowSize - 2){
            validateSeatInMiddle(seatsInRow, seatNumber);
        }

        //Validate if second seat in a row do not left single place over between reserved seats
        if (seatNumber == SECOND_SEAT_IN_ROW){
           validateSecondSeatInARow(seatsInRow, seatNumber);
        }

        //Validate if second to last seat in a row do not left single place over between reserved seats
        if (seatNumber == seatsInRowSize - 1){
           validateSecondToLastSeatInRow(seatsInRow, seatNumber);
        }
    }

    public static void validateSecondToLastSeatInRow(List<Seat> seatsInRow, int seatNumber){
        if (!getRightSeatIsReserved(seatsInRow, seatNumber) && !getLeftSeatIsReserved(seatsInRow,seatNumber)
                && getSecondLeftSeatIsReserved(seatsInRow, seatNumber))
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
    }

    public static void validateSecondSeatInARow(List<Seat> seatsInRow, int seatNumber){
        if (!getLeftSeatIsReserved(seatsInRow, seatNumber) && !getRightSeatIsReserved(seatsInRow, seatNumber)
                && getSecondRightSeatIsReserved(seatsInRow, seatNumber))
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
    }

    public static void validateRightEdge(List<Seat> seatsInRow, int seatNumber){
        if (!getLeftSeatIsReserved(seatsInRow, seatNumber) && getSecondLeftSeatIsReserved(seatsInRow, seatNumber))
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
    }

    public static void validateSeatInMiddle(List<Seat> seatsInRow, int seatNumber){
        if (!getLeftSeatIsReserved(seatsInRow, seatNumber) && !getRightSeatIsReserved(seatsInRow, seatNumber)
                && getSecondLeftSeatIsReserved(seatsInRow, seatNumber) && getSecondRightSeatIsReserved(seatsInRow, seatNumber))
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");

        if (!getLeftSeatIsReserved(seatsInRow, seatNumber) && getSecondLeftSeatIsReserved(seatsInRow, seatNumber)
                && !getRightSeatIsReserved(seatsInRow, seatNumber)  && !getSecondRightSeatIsReserved(seatsInRow, seatNumber))
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");

        if (!getRightSeatIsReserved(seatsInRow,seatNumber) && getSecondRightSeatIsReserved(seatsInRow,seatNumber)
                && !getLeftSeatIsReserved(seatsInRow,seatNumber) && !getSecondLeftSeatIsReserved(seatsInRow,seatNumber))
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
    }

    public static void validateLeftEdge(List<Seat> seatsInRow, int seatNumber){
        if (!getRightSeatIsReserved(seatsInRow, seatNumber) && getSecondRightSeatIsReserved(seatsInRow, seatNumber))
            throw new ValidationException("You can't reserve this seat because it will leave a place over in a row");
    }

    public static boolean getRightSeatIsReserved(List<Seat> seatsInRow, int seatNumber){
        return seatsInRow.get(seatNumber).getIsReserved();
    }

    public static boolean getSecondRightSeatIsReserved(List<Seat> seatsInRow, int seatNumber){
        return seatsInRow.get(seatNumber + 1).getIsReserved();
    }
    
    public static boolean getLeftSeatIsReserved(List<Seat> seatsInRow, int seatNumber){
        return seatsInRow.get(seatNumber - 2).getIsReserved();
    }
    
    public static boolean getSecondLeftSeatIsReserved(List<Seat> seatsInRow, int seatNumber){
        return seatsInRow.get(seatNumber - 3).getIsReserved();
    }
}
