import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ScreeningResponse, Seat } from 'src/app/models/screening_resoponse';
import { ScreeningService } from 'src/app/services/screening.service';

@Component({
  selector: 'app-screening',
  templateUrl: './screening.component.html',
  styleUrls: ['./screening.component.css']
})
export class ScreeningComponent implements OnInit {
  screening$: Observable<ScreeningResponse>;
  screeningId: number | null = null;
  selectedSeats: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private screeningService: ScreeningService,
    private formBuilder: FormBuilder
    ) {
      this.ngOnInit();
      this.screening$ = this.screeningService.getScreeningById(this.screeningId || 0);
    }


  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.screeningId = parseInt(params.get('id') || '0');
    });
  }

  onSelectedSeatsChange(seats: any[]) {
    console.log(seats);
    this.selectedSeats = seats;
  }

  firstFormGroup = this.formBuilder.group({
    name: ['', Validators.required],
    surname: ['', Validators.required],
  });

  onFormSubmit() {
    if (this.firstFormGroup.valid) {
      const formData = this.firstFormGroup.value;
      console.log('Form data:', formData);
    }
  }
}