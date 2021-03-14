import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FindTheHotel } from '../model/find-the-hotel';
import { FindTheHotelService } from '../service/find-the-hotel.service';

@Component({
  selector: 'app-find-the-hotel',
  templateUrl: './find-the-hotel.component.html',
  styleUrls: ['./find-the-hotel.component.css']
})

export class FindTheHotelComponent implements OnInit {
  findTheHotel: FindTheHotel = { address: '', state: '', town: '', city: '', pin: null };
  static loginTries = 0;



  constructor(private service: FindTheHotelService, private router: Router) { }

  ngOnInit() {

  }


  public onSubmit() {

    //Dummy
    /* if (this.findTheHotel.hotelCode == 'H1' && this.login.username == 'root' && this.login.password == 'aA@1') {
      localStorage.setItem('token', this.login.username);
      console.log('token stored in localStorage = ' + this.login.username);


      this.service.submitStaffLogin(this.login);
      this.router.navigate(['/home']); */
    /*  console.log("data is submitted");
     console.log(this.findTheHotel); */
    /*  }
 
     else {
 
       FindTheHotelComponent.loginTries++;
     } */

    console.log(this.findTheHotel);


    this.router.navigate(['/getHotelByPinCode', this.findTheHotel.pin]);

  }

}

