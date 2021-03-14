import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Billing } from '../model/Billing';
import { BillingService } from '../service/billing.service';
import { StaffLoginService } from '../service/staff-login.service';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {

  flag = false;

  thankYou = false;

  bill: Billing;

  bookingId;

  constructor(private billService: BillingService, private authService: StaffLoginService, private router: Router, private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {


    this.activateRoute.params.subscribe((params) => {
      this.bookingId = params['id'];

      this.billService.getBillingObject(parseInt(this.bookingId))
        .subscribe(
          data => {
            this.bill = data;
            console.log("On Billing page " + data);
            this.bill.bookingId = this.bookingId;
          }
        );


    })


    //let bookingId = this.activateRoute.snapshot.params['id'];
    /* console.log("booking Id taken from route = " + bookingId);
 
     this.billService.getBillingObject(parseInt(bookingId))
       .subscribe(
         data => {
           this.bill = data;
           console.log("On Billing page " + data);
           this.bill.bookingId = bookingId;
         }
       );   */


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



  }


  printPdf() {
    console.log("Printed pdf");

    this.thankYou = true;


    this.billService.printPdf(this.bill).subscribe(
      data => console.log(data),
      error => console.log("Problem with PDF generation")
    );
  }

  emailPdf() {
    console.log("Emailed PDF");
    this.thankYou = true;

    this.billService.emailPdf(this.bill).subscribe(
      data => console.log(data),
      error => console.log("Problem with PDF generation")
    );
  }

  onXclick() {
    this.router.navigate(['/home']);
  }

}
