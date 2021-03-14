import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Billing } from '../model/Billing';

@Injectable({
  providedIn: 'root'
})
export class BillingService {

  url = "http://localhost:8080/billing/";

  constructor(private http: HttpClient) { }

  public getBillingObject(bookingId): Observable<Billing> {

    return this.http.get<Billing>(this.url + bookingId);
  }

  public printPdf(bill: Billing) {
    return this.http.post("http://localhost:8080/printPdf", bill);
  }

  public emailPdf(bill: Billing) {
    return this.http.post("http://localhost:8080/emailPdf", bill);
  }

}
