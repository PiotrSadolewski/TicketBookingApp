import { Component, Input, OnInit } from '@angular/core';
import { Seat } from 'src/app/models/screening_resoponse';
import { TicketRequest } from 'src/app/models/ticket_request';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent{

  @Input() seat: Seat = {} as Seat;
  @Input() ticketRequest: TicketRequest = {} as TicketRequest;

  setTicketType(ticketType: string) {
    this.ticketRequest.ticketType = ticketType;
    console.log(this.ticketRequest);
  }
}
