package validation;

import com.example.backend.model.Seat;
import com.example.backend.model.requests.ReservationRequest;
import com.example.backend.exception.ValidationException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ReservationValidation {

    public static void validateReservationTime(LocalDateTime screeningTime) {
        if (Duration.between(LocalDateTime.now(), screeningTime).toMinutes() < 15) {
            throw new ValidationException("You can't reserve tickets for a screening that starts in less than 15 minutes or has already started");
        }
    }

    public static void validateIfSeatHaveGoodScreeningId(Seat seat, Long screeningId) {
        if (!Objects.equals(seat.getScreening().getId(), screeningId)) {
            throw new ValidationException(
                    "Seat with id: " + seat.getId() + " is not in screening with id: " + screeningId
            );
        }
    }

    public static void validateTickets(List<ReservationRequest.Ticket> tickets){
        if (tickets.isEmpty()) {
            throw new ValidationException("You must reserve at least one ticket");
        }

        if (tickets.contains(null)) {
            throw new ValidationException("Ticket list contains null");
        }

        tickets.forEach(ticket -> {
            TicketValidation.validateIfTicketTypeIsNull(ticket.getTicketType());
            TicketValidation.validateIfTicketTypeIsNotValid(ticket.getTicketType());
            TicketValidation.validateIfTicketSeatIdIsNull(ticket.getSeatId());
        });
    }

}
