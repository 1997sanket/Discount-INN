import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotel } from '../model/hotel';
import { IHotel } from '../model/ihotel';
import { HotelSearchService } from '../service/hotel-search.service';

@Component({
  selector: 'app-hotel-selection',
  templateUrl: './hotel-selection.component.html',
  styleUrls: ['./hotel-selection.component.css']
})
export class HotelSelectionComponent implements OnInit {
  hotels: IHotel[];

  noHotelsErrorForState = false;
  noHotelsErrorForPinCode = false;

  constructor(
    private hotelSearchService: HotelSearchService,
    private activatedRoute: ActivatedRoute
  ) { }



  ngOnInit(): void {
    let state: string = this.activatedRoute.snapshot.params['state'];
    console.log(state);
    this.hotelSearchService.findHotelByState(state).subscribe(data => {

      if (data == null) this.noHotelsErrorForState = true;

      else {
        this.hotels = data;
        console.log("Hotels by state " + this.hotels);
      }

    });

    let pinCode: string = this.activatedRoute.snapshot.params['pinCode'];
    console.log(pinCode);
    this.hotelSearchService.findHotelsByPinCode(pinCode).subscribe(
      data => {

        if (data == null) this.noHotelsErrorForPinCode = true;
        else {
          this.hotels = data;
          console.log("Hotels by pinCode " + this.hotels);
        }

      }

    )
  }

}
