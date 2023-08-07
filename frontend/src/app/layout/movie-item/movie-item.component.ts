import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MovieResponse } from 'src/app/models/movie_response';


@Component({
  selector: 'app-movie-item',
  templateUrl: './movie-item.component.html',
  styleUrls: ['./movie-item.component.css'],
})
export class MovieItemComponent {
  @Input() movie: MovieResponse | undefined;
  @Output() screeningSelected: EventEmitter<number> = new EventEmitter<number>();

  onScreeningSelected(screeningId: number) {
    this.screeningSelected.emit(screeningId);
  }
}
