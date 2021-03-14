import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { BookingForm } from '../model/bookingForm';
//import { BookingFormService } from '../service/booking-form.service';
import { StaffLoginService } from '../service/staff-login.service';

@Component({
  selector: 'app-staff-booking',
  templateUrl: './staff-booking.component.html',
  styleUrls: ['./staff-booking.component.css']
})

//this.authService.welcome(localStorage.getItem('token')).subscribe(data => { console.log(data); this.demo = data; });

export class StaffBookingComponent implements OnInit {

  // flag = false;

  // dateHasError = true;




  constructor(private authService: StaffLoginService, private router: Router) { }

  ngOnInit() {


    let hotelCode = parseInt(localStorage.getItem('hotelCode'));

    this.router.navigate(['booking-form/' + hotelCode]);

    /*this.authService.welcome(localStorage.getItem('token'))
       .subscribe(
         data => {
           if (data.toString() == "hello") this.flag = true;
           else this.flag = false;
         }
       );
 
     
     this.authService.welcome(localStorage.getItem('token'))
       .subscribe(
         (data) => {
           if (data.toString() == "hello") this.flag = true;
           else this.flag = false;
         } 
 */

  }



  /*onSubmit() {
    //console.log(this.bookingForm);
    this.bookingForm.hotelCode = parseInt(localStorage.getItem('hotelCode'));
    console.log(this.bookingForm);

    this.bookingService.submitBookingForm(this.bookingForm)
      .subscribe(
        data => console.log(data)
      );
  }


  checkDates(checkinValue, checkoutValue) {

    let checkinDate = new Date(checkinValue).getTime();
    let checkoutDate = new Date(checkoutValue).getTime();

    if (checkinDate - checkoutDate >= 0)
      this.dateHasError = true;
    else this.dateHasError = false;

    console.log(checkinDate - checkoutDate);

  }*/

}
