import { Component, EventEmitter, Input, Output} from '@angular/core';
import { Seat } from 'src/app/models/screening_resoponse';


@Component({
  selector: 'app-seat-list',
  templateUrl: './seat-list.component.html',
  styleUrls: ['./seat-list.component.css']
})
export class SeatListComponent {
  @Input() seats: Seat[] = [];
  @Output() selectedSeatsChange: EventEmitter<any[]> = new EventEmitter<any[]>();

  selectedSeats: any[] = [];

  groupSeatsByRow(seats: Seat[]): Seat[][] {
    const groupedSeats: Seat[][] = [];
    seats.forEach((seat) => {
      const rowIndex = seat.row - 1;
      groupedSeats[rowIndex] = groupedSeats[rowIndex] || [];
      groupedSeats[rowIndex].push(seat);
    });
    return groupedSeats;
  }

  selectSeat(seat: any) {
    const index = this.selectedSeats.findIndex((selectedSeat) => selectedSeat.id === seat.id);
    if (index !== -1) {
      this.selectedSeats.splice(index, 1);
    } else {
      this.selectedSeats.push(seat);
    }
    this.selectedSeatsChange.emit(this.selectedSeats);
  }

  isSeatSelected(seat: any) {
    return this.selectedSeats.some((selectedSeat) => selectedSeat.id === seat.id);
  }
  
  
}
