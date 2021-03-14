import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IBooking } from '../model/ibooking';
import { IHotel } from '../model/ihotel';

@Injectable({
  providedIn: 'root'
})
export class StaffCheckinService {

  url: String = "http://localhost:8080/"


  constructor(private http: HttpClient) { }



  public getHotel(hotelId): Observable<IHotel> {
    return this.http.get<IHotel>(this.url + "hotels/" + hotelId);
  }


  public getBookingForm(bid): Observable<IBooking> {
    return this.http.get<IBooking>(this.url + "booking/" + bid);
  }


  public submitCheckinForm(checkinForm: IBooking) {
    checkinForm.checkOut = '';
    //console.log(checkinForm);
    return this.http.post(this.url + "main-booking", checkinForm);

  }

  public getMainBooking(bookingId): Observable<IBooking> {
    return this.http.get<IBooking>(this.url + "main-booking/" + bookingId);
  }


  public getCheckOutBooking(bookingId): Observable<IBooking> {
    return this.http.get<IBooking>(this.url + "CheckOutBooking/" + bookingId);
  }
}
