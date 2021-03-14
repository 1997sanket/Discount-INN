import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IBooking } from '../model/ibooking';

@Injectable({
  providedIn: 'root'
})
export class BookRoomService {

  constructor(
    private _http: HttpClient
  ) { }

  bookUrl: string = "http://localhost:8080/booking"

  //Submit
  postBooking(booking: IBooking): Observable<IBooking> {
    return this._http.post<IBooking>(this.bookUrl, booking);
  }

  //get Booking object
  getBooking(bookingId: number): Observable<IBooking> {
    return this._http.get<IBooking>(this.bookUrl + "/" + bookingId);
  }


  //Delete Booking record from Side- Booking table
  deleteBooking(bookingId) {
    console.log(bookingId);
    return this._http.delete(this.bookUrl + "/" + bookingId);
  }


}
