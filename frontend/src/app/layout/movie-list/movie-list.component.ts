
import { DatePipe } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { MatCalendar } from '@angular/material/datepicker';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MovieResponse } from 'src/app/models/movie_response';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css'],
  providers: [DatePipe]
})
export class MovieListComponent {
  movies$: Observable<MovieResponse[]> | undefined;
  formattedDate: string | null = null;

  @ViewChild(MatCalendar) calendar: MatCalendar<Date> | undefined;

  onDateSelected(event: any) {
    this.formatDate(event);
    this.movies$ = this.movieService.getMovies(this.formattedDate!);
  }

  constructor(
    private readonly movieService: MovieService,
    private readonly router: Router,
    private datePipe: DatePipe) 
    {
      this.formatDate(this.setCurrentDate());
      this.movies$ = this.movieService.getMovies(this.formattedDate!);
      console.log(this.movies$)
  }

  onScreeningSelected(movieTitle: string, screeningId: number, date: string) {
    this.router.navigate([`/screening/${screeningId}/${movieTitle}/${date}`]);
  }

  onMovieDetailsSelected(movieId: number) {
    this.router.navigate([`/movie/details/${movieId}`]);
  }

  formatDate(date: Date){
    date.setMinutes(date.getMinutes() + 1);
    console.log(date.getMinutes());
    this.formattedDate = this.datePipe.transform(date, 'yyyy-MM-ddTHH:mm:ss');
    console.log(this.formattedDate);
  }

  setCurrentDate() {
    const currentDate = new Date();
    currentDate.setMinutes(currentDate.getMinutes() + 1);
    return currentDate;
  }
}
