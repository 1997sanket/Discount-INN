import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IBooking } from '../model/ibooking';
import { IHotel } from '../model/ihotel';
import { StaffCheckinService } from '../service/staff-checkin.service';
import { StaffCheckoutService } from '../service/staff-checkout.service';
import { StaffLoginService } from '../service/staff-login.service';

@Component({
  selector: 'app-staff-checkout',
  templateUrl: './staff-checkout.component.html',
  styleUrls: ['./staff-checkout.component.css']
})
export class StaffCheckoutComponent implements OnInit {


  getToday() {
    let date_ob = new Date();

    // adjust 0 before single digit date
    let date = ("0" + date_ob.getDate()).slice(-2);

    // current month
    let month = ("0" + (date_ob.getMonth() + 1)).slice(-2);

    // current year
    let year = date_ob.getFullYear();

    // prints date in YYYY-MM-DD format
    console.log(year + "-" + month + "-" + date);

    return year + "-" + month + "-" + date;
  }




  public bid: string = '';
  public ifBidSet: boolean = false;

  flag = false;

  booking: IBooking;
  bookingForm1: FormGroup;

  datehasError: boolean = false;
  dateError: string;
  cust_id: number;
  invalidCheckout: boolean = false;

  hotel: IHotel;



  constructor(private authService: StaffLoginService, private staffCheckoutService: StaffCheckoutService,
    public fb: FormBuilder, private router: Router, private staffCheckinService: StaffCheckinService) { }

  ngOnInit(): void {
    this.authService.welcome(localStorage.getItem('token'))
      .subscribe(
        data => {
          if (data.toString() == "hello") {
            this.flag = true;
            console.log("flag = " + this.flag);
          }
          else this.flag = false;
        }
      );





    this.staffCheckinService.getHotel(parseInt(localStorage.getItem('hotelCode')))
      .subscribe(data => {
        this.hotel = data;
        //this.roomCount = this.hotel.availableRooms;
      })
  }


  onXclick() {
    this.router.navigate(['/home']);
  }


  onSubmit() {
    this.bid = this.bid.slice(6);

    //Bring MainBooking data
    this.staffCheckoutService.getMainBooking(this.bid)
      .subscribe(
        data => {

          this.booking = data;

          //This is to set the same customer //Do not create a new one
          this.cust_id = this.booking.customer.custId;

          // this.staffCheckoutService.getCheckOutBooking(this.bid).subscribe(data=>{
          //   this.checkedOutBooking = data;
          //   if(this.checkedOutBooking!=null){
          //     this.customerAlreadyCheckedOut=true;
          //   }
          // });

          console.log(this.booking.checkIn);

          //Phati
          this.bookingForm1 = this.fb.group({
            xyz: ['hi'],
            firstName: [this.booking.customer.firstName, [Validators.required]],
            lastName: [this.booking.customer.lastName, [Validators.required]],
            mobile: [this.booking.customer.mobile, [Validators.required, Validators.pattern('^[0-9]{10,10}$')]],
            email: [this.booking.customer.email, [Validators.required, Validators.email]],
            address: [this.booking.customer.address, [Validators.required]],
            checkIn: [this.booking.checkIn, [Validators.required]],
            checkOut: [this.booking.checkOut, [Validators.required]]
          });

        },

        error => {
          console.log(error);
        }
      )


    this.ifBidSet = true;

  }



  onCheckout() {

    this.mapFormValues();

    this.finalCheckout();

    this.router.navigate(['/billing/' + this.booking.bookingId]);

  }



  finalCheckout() {
    console.log(this.booking);
    this.staffCheckoutService.finalCheckout(this.booking)
      .subscribe(
        data => {

        },
        error => {
          this.invalidCheckout = true;
        }
      );
  }



  checkDates(): boolean {
    console.log("in checkdates");
    const checkInDate = new Date(this.bookingForm1.controls.checkIn.value);
    const checkOutDate = new Date(this.bookingForm1.controls.checkOut.value);
    if (checkInDate >= checkOutDate) {
      this.datehasError = true;
      this.dateError = "Checkout date should be more than Check in";
      //console.log(this.datehasError);
      return true;
    }
    else {
      this.datehasError = false;
      this.dateError = "";
      return false;
    }

  }


  mapFormValues() {
    /*  this.booking = new Booking(0, '', '', 0,
        { custId: 0, firstName: '', lastName: '', email: '', mobile: '', address: '' }); */

    this.booking.checkIn = this.bookingForm1.controls.checkIn.value;
    this.booking.checkOut = this.bookingForm1.controls.checkOut.value;
    this.booking.hotelId = this.booking.hotelId;//this.hotel.hotelId;
    this.booking.customer.custId = this.cust_id;
    this.booking.customer.firstName = this.bookingForm1.controls.firstName.value;
    this.booking.customer.lastName = this.bookingForm1.controls.lastName.value;
    this.booking.customer.email = this.bookingForm1.controls.email.value;
    this.booking.customer.mobile = this.bookingForm1.controls.mobile.value;
    this.booking.customer.address = this.bookingForm1.controls.address.value;

  }


  get firstName() {
    return this.bookingForm1.get('firstName');
  }

  get lastName() {
    return this.bookingForm1.get('lastName');
  }

  get mobile() {
    return this.bookingForm1.get('mobile');
  }

  get email() {
    return this.bookingForm1.get('email');
  }

  get address() {
    return this.bookingForm1.get('address');
  }
  get checkIn() {
    return this.bookingForm1.get('checkIn');
  }

  get checkOut() {
    return this.bookingForm1.get('checkOut');
  }

  get xyz() {
    return this.bookingForm1.get('xyz');
  }

}
