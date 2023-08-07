import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieItemComponent } from './movie-item/movie-item.component';
import { HttpClientModule } from '@angular/common/http';
import { MovieListComponent } from './movie-list/movie-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { NavbarComponent } from './navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { SeatListComponent } from './seat-list/seat-list.component';
import { AppRoutingModule } from '../app-routing.module';
import { MatList, MatListModule } from '@angular/material/list';

@NgModule({
  declarations: [
    MovieItemComponent,
    MovieListComponent,
    NavbarComponent,
    SeatListComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    AppRoutingModule,
    MatListModule
  ],
  exports: [
    MovieItemComponent,
    MovieListComponent,
    NavbarComponent,
    SeatListComponent
  ]
})
export class LayoutModule { }
