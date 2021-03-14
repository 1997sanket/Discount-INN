import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FindTheHotel } from '../model/find-the-hotel';
import { IDisplayTheHotel } from '../model/idisplay-the-hotel';

@Injectable({
  providedIn: 'root'
})
export class FindTheHotelService {
  url = "http://localhost:8081/";

  constructor(private http: HttpClient) { }

  //Submit Staff Login Object
  submitFindTheHotel(findTheHotel: FindTheHotel) {

    //return this.http.post<any>(this.url, staffLogin);
    console.log(findTheHotel);
  }
  getHotelByPinCode(pin: number): Observable<IDisplayTheHotel> {

    return this.http.get<IDisplayTheHotel>(this.url + "hotels/pinCode/" + pin);
  }
}
