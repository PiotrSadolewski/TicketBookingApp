import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from './layout/movie-list/movie-list.component';
import { ScreeningComponent } from './layout/screening/screening.component';

const routes: Routes = [
  {
    path: '',
    component : MovieListComponent
  }, 
  {
    path: 'screening/:id',
    component: ScreeningComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
