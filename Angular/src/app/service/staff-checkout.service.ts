import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking';
import { IBooking } from '../model/ibooking';

@Injectable({
  providedIn: 'root'
})
export class StaffCheckoutService {

  url = "http://localhost:8080/"

  constructor(private http: HttpClient) { }


  public getMainBooking(bookingId): Observable<IBooking> {
    return this.http.get<IBooking>(this.url + "main-booking/" + bookingId);
  }

  public finalCheckout(bookingObj) {

    return this.http.put("http://localhost:8080/main-booking", bookingObj);
  }


  public getCheckOutBooking(bookingId): Observable<IBooking> {
    return this.http.get<IBooking>(this.url + "CheckOutBooking/" + bookingId);
  }
}
