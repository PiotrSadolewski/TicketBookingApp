import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ScreeningResponse, Seat } from 'src/app/models/screening_resoponse';
import { ScreeningService } from 'src/app/services/screening.service';


@Component({
  selector: 'app-seat-list',
  templateUrl: './seat-list.component.html',
  styleUrls: ['./seat-list.component.css']
})
export class SeatListComponent implements OnInit {
  screening$: Observable<ScreeningResponse>;
  screeningId: number | null = null;

  constructor(
    private route: ActivatedRoute,
    private screeningService: ScreeningService
    ) {
      this.ngOnInit();
      this.screening$ = this.screeningService.getScreeningById(this.screeningId || 0);
    }


  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.screeningId = parseInt(params.get('id') || '0');
    });
  }

  groupSeatsByRow(seats: Seat[]): Seat[][] {
    const groupedSeats: Seat[][] = [];
    seats.forEach((seat) => {
      const rowIndex = seat.row - 1;
      groupedSeats[rowIndex] = groupedSeats[rowIndex] || [];
      groupedSeats[rowIndex].push(seat);
    });
    return groupedSeats;
  }
}
