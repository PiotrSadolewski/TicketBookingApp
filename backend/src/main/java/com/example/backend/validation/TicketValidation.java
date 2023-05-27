package com.example.backend.validation;

import com.example.backend.model.TicketType;
import com.example.backend.exception.ValidationException;

public class TicketValidation {
    public static void validateIfTicketTypeIsNull(TicketType ticketType){
        if(ticketType == null){
            throw new ValidationException("TicketType is null");
        }
    }

    public static void validateIfTicketTypeIsNotValid(TicketType ticketType){
        if(!ticketType.equals(TicketType.ADULT) && !ticketType.equals(TicketType.STUDENT) && !ticketType.equals(TicketType.CHILD)){
            throw new ValidationException("TicketType is not valid");
        }
    }

    public static void validateIfTicketSeatIdIsNull(Long seatId){
        if(seatId == null){
            throw new ValidationException("SeatId is null");
        }
    }
}
