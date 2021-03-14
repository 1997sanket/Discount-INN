import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../model/booking';
import { IBooking } from '../model/ibooking';
import { IHotel } from '../model/ihotel';
import { BookRoomService } from '../service/book-room.service';
import { HotelSearchService } from '../service/hotel-search.service';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit {


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


  hotel: IHotel;
  booking: IBooking;
  bookingForm: FormGroup;
  postedBooking: IBooking;
  showAlert: boolean = false;

  datehasError: boolean = false;
  dateError: string;

  constructor(
    public fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private hotelService: HotelSearchService,
    private bookingService: BookRoomService,
    private router: Router
  ) { }



  ngOnInit(): void {

    // getTodayDate() {

    //   let today = new Date().toLocaleDateString();
    //   return today;
    // }

    console.log(new Date());


    let hotelId = this.activatedRoute.snapshot.params["hotel"];
    this.hotelService.findHotelById(hotelId).subscribe(data => {
      this.hotel = data;
    });


    this.bookingForm = this.fb.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      mobile: ['', [Validators.required, Validators.pattern('^[0-9]{10,10}$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required]],
      checkIn: ['', [Validators.required]],
      checkOut: ['', [Validators.required]]
    });
  }



  onSubmit() {
    if (!this.bookingForm.valid)
      return;
    if (this.checkDates()) {
      return;
    }
    this.mapFormValues();
    console.log(this.bookingForm)
    this.postdata(this.booking);
  }


  checkDates(): boolean {
    const checkInDate = new Date(this.bookingForm.controls.checkIn.value);
    const checkOutDate = new Date(this.bookingForm.controls.checkOut.value);
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
    this.booking = new Booking(0, '', '', 0,
      { custId: 0, firstName: '', lastName: '', email: '', mobile: '', address: '' });
    this.booking.checkIn = this.bookingForm.controls.checkIn.value;
    this.booking.checkOut = this.bookingForm.controls.checkOut.value;
    this.booking.hotelId = this.hotel.hotelId;
    this.booking.customer.custId = 0;
    this.booking.customer.firstName = this.bookingForm.controls.firstName.value;
    this.booking.customer.lastName = this.bookingForm.controls.lastName.value;
    this.booking.customer.email = this.bookingForm.controls.email.value;
    this.booking.customer.mobile = this.bookingForm.controls.mobile.value;
    this.booking.customer.address = this.bookingForm.controls.address.value;
  }

  postdata(cust: IBooking) {
    this.bookingService.postBooking(this.booking).subscribe((data) => {
      this.postedBooking = data;
      console.log(this.postedBooking);

      if (data != null) {
        this.bookingForm.reset();
        this.showAlert = true;
      }

    });
  }
  get firstName() {
    return this.bookingForm.get('firstName');
  }

  get lastName() {
    return this.bookingForm.get('lastName');
  }

  get mobile() {
    return this.bookingForm.get('mobile');
  }

  get email() {
    return this.bookingForm.get('email');
  }

  get address() {
    return this.bookingForm.get('address');
  }
  get checkIn() {
    return this.bookingForm.get('checkIn');
  }

  get checkOut() {
    return this.bookingForm.get('checkOut');
  }


  onXclick() {
    this.router.navigate(['home']);
  }

}
