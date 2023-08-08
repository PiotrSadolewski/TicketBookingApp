import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReservationResponse } from 'src/app/models/reservation_response';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit{
  reservation: ReservationResponse | undefined;

  constructor(private router: Router) { 

  }

  ngOnInit() {
    this.reservation = history.state.reservationResponse;
  }

}
