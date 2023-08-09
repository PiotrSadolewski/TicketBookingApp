import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { BehaviorSubject, Observable, switchMap } from 'rxjs';
import { MovieResponse } from '../models/movie_response';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class MovieService {

    constructor(private readonly http: HttpClient) { }

    movieSubject$ = new BehaviorSubject<MovieResponse[]>([]);
    getMovies(): Observable<MovieResponse[]> {
        return this.movieSubject$.pipe(
            switchMap(() => this.http.get<MovieResponse[]>(`http://localhost:8080/api/movies/all/byScreeningDate?screeningDate=2023-09-14T09:40:00`))
        );
    } 


}