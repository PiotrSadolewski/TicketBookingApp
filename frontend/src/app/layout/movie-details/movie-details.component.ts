import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit{
  movieId: number | null = null;
  movie$: Observable<Movie>;

  constructor(
      private readonly route: ActivatedRoute,
      private readonly movieService: MovieService,
      private readonly router: Router
      ) 
  { 
    this.ngOnInit();
    this.movie$ = this.movieService.getMovieById(this.movieId || 0);
    console.log(this.movie$);
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.movieId = parseInt(params.get('id') || '0')
    })
  }

  goBack() {
    console.log("clicking");
    this.router.navigate(['../../../'], { relativeTo: this.route });
  }

  getDurationInMinutes(duration: string): number {
    const pattern = /PT(\d+)H(\d+)M/;
    const matches = pattern.exec(duration);

    if (matches && matches.length === 3) {
      const hours = parseInt(matches[1], 10);
      const minutes = parseInt(matches[2], 10);
      return hours * 60 + minutes;
    }

    return 0;
  }

}
