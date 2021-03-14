import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  constructor(
    private _http:HttpClient
  ) { }


  getLocationDetails(lat:number,lon:number):Observable<any>{
    let url='https://us1.locationiq.com/v1/reverse.php?key=pk.a15b04c98fbfc1b546e896ae80eb41c5&format=json&lat='+lat+'&lon='+lon;
    return this._http.get<any>(url);
  }

  
}
