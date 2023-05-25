package validation;

import com.example.backend.model.Seat;
import com.example.backend.model.requests.ReservationRequest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ReservationValidation {

    public static void validateReservationTime(LocalDateTime screeningTime) {
        if (Duration.between(LocalDateTime.now(), screeningTime).toMinutes() < 15) {
            throw new RuntimeException("You can't reserve tickets for a screening that starts in less than 15 minutes or has already started");
        }
    }

    public static void validateIfSeatIsAvailable(Seat seat) {
        if (seat.getIsReserved()) {
            throw new RuntimeException(
                    "Seat with row number: " + seat.getRowNumber() + " seat number: " + seat.getSeatNumber() + " is already reserved"
            );
        }
    }

    public static void validateIfSeatHaveGoodScreeningId(Seat seat, Long screeningId) {
        if (!Objects.equals(seat.getScreening().getId(), screeningId)) {
            throw new RuntimeException(
                    "Seat with id: " + seat.getId() + " is not in screening with id: " + screeningId
            );
        }
    }

    public static void validateTickets(List<ReservationRequest.Ticket> tickets){
        if (tickets.isEmpty()) {
            throw new RuntimeException("You must choose at least one ticket");
        }

        if (tickets.contains(null)) {
            throw new RuntimeException("Ticket list contains null");
        }

        tickets.forEach(ticket -> {
            if (ticket.getSeatId() == null) {
                throw new RuntimeException("You must choose seat");
            }
            if (ticket.getTicketType() == null) {
                throw new RuntimeException("You must choose Type of ticket");
            }
            System.out.println(ticket.getSeatId());
        });
    }

}
