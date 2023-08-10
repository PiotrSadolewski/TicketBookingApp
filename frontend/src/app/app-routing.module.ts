import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from './layout/movie-list/movie-list.component';
import { ScreeningComponent } from './layout/screening/screening.component';
import { ReservationComponent } from './layout/reservation/reservation.component';
import { MovieDetailsComponent } from './layout/movie-details/movie-details.component';

const routes: Routes = [
  {
    path: '',
    component : MovieListComponent
  }, 
  {
    path: 'screening/:id/:movieTitle/:date',
    component: ScreeningComponent
  },
  {
    path: 'reservation',
    component: ReservationComponent
  },
  {
    path: 'movie/details/:id',
    component: MovieDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
