import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MovieResponse } from 'src/app/models/movie_response';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent {
  movies$: Observable<MovieResponse[]>;

  constructor(
    private readonly movieService: MovieService,
    private readonly router: Router) 
    { 
    this.movies$ = this.movieService.getMovies();
  }

  onScreeningSelected(screeningId: number) {
    this.router.navigate(['/screening', screeningId]);
  }
}
