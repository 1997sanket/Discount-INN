import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { IHotel } from '../model/ihotel';
import { HotelSearchService } from '../service/hotel-search.service';

@Component({
  selector: 'app-quick-hotel-selection',
  templateUrl: './quick-hotel-selection.component.html',
  styleUrls: ['./quick-hotel-selection.component.css']
})
export class QuickHotelSelectionComponent implements OnInit {
  hotels: IHotel[];
  city: string;
  constructor(
    private hotelSearchService: HotelSearchService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(
      (params: Params) => {
        this.city = params['cityCode']
        this.hotelSearchService.findHotelByCity(this.city).subscribe(data => {
          this.hotels = data;
          console.log(this.hotels);
        });
      }
    );
  }
}
