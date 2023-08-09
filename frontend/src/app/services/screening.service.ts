import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { BehaviorSubject, Observable } from 'rxjs';
import { ScreeningResponse } from '../models/screening_resoponse';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ScreeningService {

    constructor(private readonly http: HttpClient) { }

    screeningSubject$ = new BehaviorSubject<ScreeningResponse>(null as any);
    getScreeningById(screeningId: number): Observable<ScreeningResponse> {
        return this.http.get<ScreeningResponse>(`http://localhost:8080/api/screenings/` + screeningId);
    }
}