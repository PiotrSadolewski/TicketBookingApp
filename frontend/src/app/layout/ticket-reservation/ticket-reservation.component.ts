import { Component, Input } from '@angular/core';
import { TicketResponse } from 'src/app/models/reservation_response';

@Component({
  selector: 'app-ticket-reservation',
  templateUrl: './ticket-reservation.component.html',
  styleUrls: ['./ticket-reservation.component.css']
})
export class TicketReservationComponent {
  @Input () ticket: TicketResponse = {} as TicketResponse;
}
