import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from './layout/movie-list/movie-list.component';
import { SeatListComponent } from './layout/seat-list/seat-list.component';

const routes: Routes = [
  {
    path: '',
    component : MovieListComponent
  }, 
  {
    path: 'screening/:id',
    component: SeatListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
