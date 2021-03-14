import { getLocaleWeekEndRange } from '@angular/common';
import { invalid } from '@angular/compiler/src/render3/view/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StaffLogin } from '../model/staff-login';
import { StaffLoginService } from '../service/staff-login.service';

@Component({
  selector: 'app-staff-login',
  templateUrl: './staff-login.component.html',
  styleUrls: ['./staff-login.component.css']
})
export class StaffLoginComponent implements OnInit {

  login: StaffLogin = { hotelCode: '', username: '', password: '' };



  invalidLogin = false;

  invalidHotelCode = false;


  constructor(private service: StaffLoginService, private router: Router) { }

  ngOnInit() {

  }


  /*public getAccessToken(authRequest) {
    let resp = this.service.generateToken()
    resp.subscribe(data => console.log("token : " + data));
  }*/


  public onHotelKeyDown() {
    this.invalidHotelCode = false;
  }

  public onUserKeyDown() {
    this.invalidLogin = false;
  }

  public onPasswordKeyDown() {
    this.invalidLogin = false;
  }




  public onSubmit() {

    this.service.generateToken(this.login /*{ username: this.login.username, password: this.login.password, hotelCode: this.login.hotelCode }*/)
      .subscribe(data => {

        if (data.toString() == "hotelCodeInvalid") {
          this.invalidHotelCode = true;
        }
        else {
          localStorage.setItem('token', data.toString());
          localStorage.setItem('hotelCode', this.login.hotelCode.toString());
          //console.log("token stored in localStorage : " + data)

          this.router.navigate(['/home']);
        }

      },

        error => {

          this.invalidLogin = true;
          console.log("invalidLogin = " + this.invalidLogin);
          this.router.navigate(['/staff-login']);
        }

      );

    /*//Dummy
    if (this.login.hotelCode == 'H1' && this.login.username == 'root' && this.login.password == 'aA@1') {
      localStorage.setItem('token', this.login.username);
      console.log('token stored in localStorage = ' + this.login.username);


      this.service.submitStaffLogin(this.login).subscribe(data => this.data = data);
      this.router.navigate(['/home']);
    } */


    /*this.service.submitStaffLogin(this.login)
      .subscribe(data => {
        localStorage.setItem('token', this.login.username);
        console.log('token stored in localStorage = ' + this.login.username);

        this.router.navigate(['/home']);
      },

        error => { console.log("invalidLogin = " + this.invalidLogin); this.invalidLogin = true; this.router.navigate(['/staff-login']); });


    console.log(this.invalidLogin); */


  }




}
