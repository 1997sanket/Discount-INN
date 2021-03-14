import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IState } from '../model/istate';
//import { QuickBookingForm } from '../model/quickBookingForm';
import { HotelSearchService } from '../service/hotel-search.service';

@Component({
  selector: 'app-left-nav',
  templateUrl: './left-nav.component.html',
  styleUrls: ['./left-nav.component.css']
})
export class LeftNavComponent implements OnInit {

  states: IState[];
  selectedState: number = -1;
  quickBooking: FormGroup;

  datehasError: boolean = false;
  dateError: string;

  constructor(
    public fb: FormBuilder,
    private hotelSearchService: HotelSearchService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.hotelSearchService.findSates().subscribe(data => {
      this.states = data;
      console.log(this.states);
    });


    this.quickBooking = this.fb.group({
      state: ['', [Validators.required]],
      city: ['', [Validators.required]]
      // checkIn: ['', [Validators.required]],
      // checkOut: ['', [Validators.required]]
    });

  }

  get state() {
    return this.quickBooking.get('state');
  }

  get city() {
    return this.quickBooking.get('city');
  }

  // get checkIn() {
  //   return this.quickBooking.get('checkIn');
  // }

  // get checkOut() {
  //   return this.quickBooking.get('checkOut');
  // }


  setState(event: Event) {
    this.selectedState = parseInt((<HTMLSelectElement>event.target).value);
    console.log(this.selectedState);
  }


  // checkDates(): boolean {
  //   const checkInDate = new Date(this.quickBooking.controls.checkIn.value);
  //   const checkOutDate = new Date(this.quickBooking.controls.checkOut.value);
  //   if (checkInDate >= checkOutDate) {
  //     this.datehasError = true;
  //     this.dateError = "This should be an earlier date!";
  //     return true;
  //   }
  //   else {
  //     this.datehasError = false;
  //     this.dateError = "";
  //     return false;
  //   }
  // }


  onSubmit() {
    let city = this.quickBooking.controls.city.value;
    this.router.navigate(['quick-hotel-selection/city', city]);

  }


}
