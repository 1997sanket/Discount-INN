import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../model/booking';
import { Hotel } from '../model/hotel';
import { IBooking } from '../model/ibooking';
import { IHotel } from '../model/ihotel';
import { BookRoomService } from '../service/book-room.service';
import { HotelSearchService } from '../service/hotel-search.service';
import { StaffCheckinService } from '../service/staff-checkin.service';
import { StaffLoginService } from '../service/staff-login.service';

@Component({
  selector: 'app-staff-checkin',
  templateUrl: './staff-checkin.component.html',
  styleUrls: ['./staff-checkin.component.css']
})
export class StaffCheckinComponent implements OnInit {



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
  roomCount: number;
  hotel: IHotel;
  bookingForm: IBooking;
  invalidBookingId = false;

  invalidCustomer = false;

  //Phati
  //hotel: IHotel;
  booking: IBooking;
  bookingForm1: FormGroup;
  postedBooking: IBooking;
  showAlert: boolean = false;
  datehasError: boolean = false;
  dateError: string;
  mainBooking: IBooking;
  cust_id: number;
  done: boolean = false;


  constructor
    (
      private authService: StaffLoginService, private staffCheckinService: StaffCheckinService,



      //Phati
      public fb: FormBuilder,
      private activatedRoute: ActivatedRoute,
      private hotelService: HotelSearchService,
      private bookingService: BookRoomService,
      private router: Router

    ) { }

  ngOnInit(): void {

    this.staffCheckinService.getHotel(parseInt(localStorage.getItem('hotelCode')))
      .subscribe(data => {
        this.hotel = data;
        this.roomCount = this.hotel.availableRooms;
      })

    /*this.authService.welcome(localStorage.getItem('token'))
      .subscribe(
        data => {
          if (data.toString() == "hello") this.flag = true;
          else this.flag = false;
        } 
      ); */




  }


  onXclick() {
    this.router.navigate(['/home']);
  }


  onSubmit() {
    this.bid = this.bid.slice(6);
    console.log(this.bid);
    this.staffCheckinService.getBookingForm(this.bid)
      .subscribe(
        data => {

          this.booking = data; console.log(this.booking);
          this.cust_id = this.booking.customer.custId;
          if (this.booking.hotelId != this.hotel.hotelId) {
            this.invalidCustomer = true;
          }

          //edited by Phati to check if the customer is already checked in or not
          // this.staffCheckinService.getMainBooking(this.bid).subscribe(data=>{
          //   this.mainBooking = data;
          //   if(this.mainBooking.bookingId == this.booking.bookingId){
          //     this.customerAlreadycheckedIn=true;
          //   }
          // });

          // this.staffCheckinService.getCheckOutBooking(this.bid).subscribe(data=>{
          //   this.checkedOutBooking = data;
          //   console.log(this.checkedOutBooking);
          //   if(this.checkedOutBooking!=null){
          //     this.customerAlreadyCheckedOut=true;
          //   }
          // });




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

        error => { this.invalidBookingId = true; console.log(this.invalidBookingId) }
      );






    //console.log(this.bid);
    this.ifBidSet = true;

    //console.log("Booking = " + this.booking);

  }



  onFinalCheckin() {
    if (!this.bookingForm1.valid)
      return;
    if (this.checkDates()) {
      return;
    }


    this.mapFormValues();



    console.log("Booking = " + this.booking.customer.firstName);
    console.log(this.booking.customer.lastName);
    console.log(this.booking.customer.address);
    console.log(this.booking.bookingId);
    console.log(this.booking.checkIn);
    console.log(this.booking.hotelId);

    this.staffCheckinService.submitCheckinForm(this.booking)
      .subscribe();


    this.done = true;
  }



  checkDates(): boolean {
    const checkInDate = new Date(this.bookingForm1.controls.checkIn.value);
    const checkOutDate = new Date(this.bookingForm1.controls.checkOut.value);
    if (checkInDate >= checkOutDate) {
      this.datehasError = true;
      this.dateError = "This should be an earlier date!";
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
