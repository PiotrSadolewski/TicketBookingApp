import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { BehaviorSubject, Observable, switchMap } from 'rxjs';
import { MovieResponse } from '../models/movie_response';
import { environment } from 'src/environments/environment';
import { ReservationRequest } from '../models/reservation_request';

@Injectable({
  providedIn: 'root'
})

export class ReservationService{
    constructor(private readonly http: HttpClient) { 

    }

    addReservation(reservationRequest: ReservationRequest){
        return this.http.post<ReservationRequest>(`http://localhost:8080/api/reservations/add`, reservationRequest);
    }
}