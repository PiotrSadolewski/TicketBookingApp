import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ScreeningResponse, Seat } from 'src/app/models/screening_resoponse';
import { TicketRequest } from 'src/app/models/ticket_request';
import { ReservationService } from 'src/app/services/reservation.service';
import { ScreeningService } from 'src/app/services/screening.service';
import { ReservationResponse } from 'src/app/models/reservation_response';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-screening',
  templateUrl: './screening.component.html',
  styleUrls: ['./screening.component.css']
})

export class ScreeningComponent implements OnInit {
  screening$: Observable<ScreeningResponse>;
  screeningId: number | null = null;
  movieTitle: string | null = null;
  date: string | null = null;
  selectedSeats: Seat[] = [];
  ticketRequests: TicketRequest[] = [];

  constructor(
    private route: ActivatedRoute,
    private screeningService: ScreeningService,
    private formBuilder: FormBuilder,
    private reservationService: ReservationService,
    private router: Router,
    ) {
      this.ngOnInit();
      this.screening$ = this.screeningService.getScreeningById(this.screeningId || 0);
    }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.screeningId = parseInt(params.get('id') || '0'),
      this.movieTitle = params.get('movieTitle'),
      this.date = params.get('date');
    });
  }

  onSelectedSeatsChange(seats: any[]) {
    console.log(seats);
    this.selectedSeats = seats;
  }

  personalDetailsForm = this.formBuilder.group({
    name: ['', Validators.required],
    surname: ['', Validators.required],
  });

  onFormSubmit() {
    if (this.personalDetailsForm.valid) {
      const formData = this.personalDetailsForm.value;
    }
  }

  createTickets() {
    this.selectedSeats.forEach(seat => {
      const existingTicket = this.ticketRequests.find(ticket => ticket.seatId === seat.id);
      if (!existingTicket) {
        this.ticketRequests.push({ ticketType: 'ADULT', seatId: seat.id });
      }
    });
  }

  deleteTickets() {
    this.ticketRequests = [];
  }

  getTicketBySeatId(seatId: number): TicketRequest {
    return this.ticketRequests.find(ticketRequest => ticketRequest.seatId === seatId) || {} as TicketRequest;
  }

  private getTicketPrice(ticketRequest: TicketRequest) {
    switch (ticketRequest.ticketType) {
      case 'ADULT':
        return 25;
      case 'CHILD':
        return 18;
      case 'STUDENT':
        return 12.50;
    }
    return 25;
  }

  getTotalPrice() {
    return this.ticketRequests.reduce((totalPrice, ticketRequest) => totalPrice + this.getTicketPrice(ticketRequest), 0);
  }

  createReservationRequest() {
    return {
      name: this.personalDetailsForm.value.name || '',
      surname: this.personalDetailsForm.value.surname || '',
      screeningId: this.screeningId || 0,
      tickets: this.ticketRequests || []
    };
  }

  // promiste take fist value 
  addReservation() {
    this.reservationService.addReservation(this.createReservationRequest())
      .subscribe(
        (response) => {
          const reservationResponse: ReservationResponse = response as unknown as ReservationResponse;
          console.log('Reservation added');
          this.router.navigate(['/reservation'], {
            state: { reservationResponse } 
          });
        },
        (error) => {
          console.error('Error adding reservation', error);
        }
      );
  }

  checkIfSeatIsSelected() {
    return this.selectedSeats.length > 0;
  }
}