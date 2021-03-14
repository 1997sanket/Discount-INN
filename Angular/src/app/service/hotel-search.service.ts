import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IHotel } from '../model/ihotel';
import { IState } from '../model/istate';

@Injectable({
  providedIn: 'root'
})
export class HotelSearchService {

  constructor(
    private _http: HttpClient
  ) { }

  stateUrl: string = "http://localhost:8080/hotels/state/";
  cityUrl: string = "http://localhost:8080/hotels/city/";
  idUrl: string = "http://localhost:8080/hotels/";


  findHotelByState(state: string): Observable<IHotel[]> {
    return this._http.get<IHotel[]>(this.stateUrl + state);
  }

  findHotelById(id: number): Observable<IHotel> {
    return this._http.get<IHotel>(this.idUrl + id);
  }

  findHotelByCity(city: string): Observable<IHotel[]> {
    return this._http.get<IHotel[]>(this.cityUrl + city);
  }


  findHotelsByPinCode(pinCode): Observable<IHotel[]> {
    return this._http.get<IHotel[]>("http://localhost:8080/hotelsByPinCode/" + pinCode);
  }

  findSates(): Observable<IState[]> {
    return this._http.get<IState[]>("http://localhost:8080/states");
  }
}
