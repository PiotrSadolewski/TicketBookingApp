import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from './layout/movie-list/movie-list.component';
import { ScreeningComponent } from './layout/screening/screening.component';
import { ReservationComponent } from './layout/reservation/reservation.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
