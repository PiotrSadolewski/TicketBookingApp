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
import { MatListModule } from '@angular/material/list';
import { ScreeningComponent } from './screening/screening.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatStepperModule} from '@angular/material/stepper';
import { TicketComponent } from './ticket/ticket.component';
import { MatChipsModule } from '@angular/material/chips';
import { ReservationComponent } from './reservation/reservation.component';
import { MatDivider, MatDividerModule } from '@angular/material/divider';
import { TicketReservationComponent } from './ticket-reservation/ticket-reservation.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import {MatExpansionModule} from '@angular/material/expansion';
import { MovieDetailsComponent } from './movie-details/movie-details.component';

@NgModule({
  declarations: [
    MovieItemComponent,
    MovieListComponent,
    NavbarComponent,
    SeatListComponent,
    ScreeningComponent,
    TicketComponent,
    ReservationComponent,
    TicketReservationComponent,
    MovieDetailsComponent
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
    MatListModule,
    MatStepperModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatChipsModule,
    MatDividerModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSnackBarModule,
    MatExpansionModule,
  ],
  exports: [
    NavbarComponent,
  ]
})
export class LayoutModule { }
