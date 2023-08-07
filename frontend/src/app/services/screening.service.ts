import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { BehaviorSubject, Observable, switchMap, tap } from 'rxjs';
import { ScreeningResponse } from '../models/screening_resoponse';

@Injectable({
  providedIn: 'root'
})

export class ScreeningService {

    constructor(private readonly http: HttpClient) { }

    screeningSubject$ = new BehaviorSubject<ScreeningResponse>(null as any);
    getScreeningById(screeningId: number): Observable<ScreeningResponse> {
        console.log("here " + screeningId)
        return this.http.get<ScreeningResponse>('http://localhost:8080/api/screenings/' + screeningId);
    }
}