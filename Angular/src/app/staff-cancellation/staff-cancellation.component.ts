import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookRoomService } from '../service/book-room.service';
import { StaffLoginService } from '../service/staff-login.service';

@Component({
  selector: 'app-staff-cancellation',
  templateUrl: './staff-cancellation.component.html',
  styleUrls: ['./staff-cancellation.component.css']
})
export class StaffCancellationComponent implements OnInit {

  flag = false;

  deleteConfirmed = false;

  //Sandeep
  public bid: string = '';
  public ifBidSet: boolean = false;

  invalidId = false;

  constructor(private authService: StaffLoginService, private bookingService: BookRoomService, private router: Router) { }


  //Sending TOken to server and checking whether it returns 'hello', if yes that means user is genuienly logged in.
  ngOnInit(): void {
    this.authService.welcome(localStorage.getItem('token'))
      .subscribe(
        data => {
          if (data.toString() == "hello") this.flag = true;
          else this.flag = false;
        }
      );
  }



  onSubmit() {
    console.log(this.bid);
    this.bid = this.bid.slice(6);
    this.ifBidSet = true;
  }

  onYes() {
    this.deleteConfirmed = true;
    //this.ifBidSet = false;
    this.bookingService.deleteBooking(parseInt(this.bid))
      .subscribe(
        data => {

        },

        error => {
          this.invalidId = true;
        }
      );
  }

  onNo() {
    this.ifBidSet = false;
  }

  onXclick() {
    this.router.navigate(['/home']);
  }

}
