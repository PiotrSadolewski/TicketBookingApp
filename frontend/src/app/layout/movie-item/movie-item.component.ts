import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MovieResponse } from 'src/app/models/movie_response';
import { MovieService } from 'src/app/services/movie.service';


@Component({
  selector: 'app-movie-item',
  templateUrl: './movie-item.component.html',
  styleUrls: ['./movie-item.component.css'],
})
export class MovieItemComponent {
  @Input() movie: MovieResponse | undefined;
  @Output() screeningSelected: EventEmitter<[string, number, string]> = new EventEmitter<[string, number, string]>();
  @Output() movieDetailsSelected: EventEmitter<number> = new EventEmitter<number>();

  onScreeningSelected(movieTitle: string, screeningId: number, date: string) {
    this.screeningSelected.emit([movieTitle, screeningId, date]);
  }
  onMovieDetailsSelected(movieId: number) {
    this.movieDetailsSelected.emit(movieId);
  }
}
