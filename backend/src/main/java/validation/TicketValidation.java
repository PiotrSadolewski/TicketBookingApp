package validation;

import com.example.backend.model.TicketType;
import validation.exception.TicketException;

public class TicketValidation {
    public static void validateIfTicketTypeIsNull(TicketType ticketType){
        if(ticketType == null){
            throw new TicketException("TicketType is null");
        }
    }

    public static void validateIfTicketTypeIsNotValid(TicketType ticketType){
        if(!ticketType.equals(TicketType.ADULT) && !ticketType.equals(TicketType.STUDENT) && !ticketType.equals(TicketType.CHILD)){
            throw new TicketException("TicketType is not valid");
        }
    }

    public static void validateIfTicketSeatIdIsNull(Long seatId){
        if(seatId == null){
            throw new TicketException("SeatId is null");
        }
    }
}
