import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { parse } from 'path';
import { StaffLoginService } from '../service/staff-login.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {



  hotelCode;

  constructor(private authService: StaffLoginService, private router: Router) { }

  ngOnInit(): void {
    this.hotelCode = parseInt(localStorage.getItem('hotelCode'));
  }


  isLoggedIn() {
    /*if (localStorage.getItem('token') == 'root') return true;

    else return false; */


    if (this.authService.isTokenPresent()) return true;

    else return false;
  }






  onLogout() {
    localStorage.removeItem('token');
    localStorage.removeItem('hotelCode');
    this.router.navigate(['/home']);
  }





}
