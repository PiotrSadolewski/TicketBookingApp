import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { BehaviorSubject, Observable, switchMap } from 'rxjs';
import { MovieResponse } from '../models/movie_response';
import { environment } from 'src/environments/environment';
import { Movie } from '../models/movie';

@Injectable({
  providedIn: 'root'
})

export class MovieService {

    constructor(private readonly http: HttpClient) {
        
     }

    moviesSubject$ = new BehaviorSubject<MovieResponse[]>([]);
    getMovies(date: String): Observable<MovieResponse[]> {
        return this.moviesSubject$.pipe(
            switchMap(() => this.http.get<MovieResponse[]>(`http://localhost:8080/api/movies/all/byScreeningDate?screeningDate=${date}`))
        );
    }
    
    movieSubject$ = new BehaviorSubject<Movie | null>(null);
    getMovieById(movieId: number): Observable<Movie> {
        return this.movieSubject$.pipe(
            switchMap(() => this.http.get<Movie>(`http://localhost:8080/api/movies/${movieId}`))
        );
    }
}