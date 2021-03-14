import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StaffLogin } from '../model/staff-login';

@Injectable({
  providedIn: 'root'
})
export class StaffLoginService {

  url = "http://localhost:8080/";

  constructor(private http: HttpClient) { }


  public generateToken(staffLoginObj) {
    return this.http.post("http://localhost:8080/authenticate", staffLoginObj, { responseType: 'text' as 'json' });
  }

  public welcome(token) {

    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set("Authorization", tokenStr);

    return this.http.get("http://localhost:8080/hello", { headers, responseType: 'text' as 'json' });
  }


  /*public getHelloFromServer() {
    return this.http.get("http://localhost:8080/hello");
  } */



  public isTokenPresent() {
    let token = localStorage.getItem('token');

    if (token != null) return true;

    else return false;
  }



  getToken() {
    return localStorage.getItem('token');
  }

  // //Submit Staff Login Object
  // submitStaffLogin(staffLogin: StaffLogin) {

  //   console.log(staffLogin);

  //   return this.http.get<any>(this.url + "hello/" + staffLogin.hotelCode + "/" + staffLogin.username + "/" + staffLogin.password);
  // }
}
