import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
//import { LeftNavComponent } from './left-nav/left-nav.component;
import { RightNavComponent } from './right-nav/right-nav.component';
import { HomeComponent } from './home/home.component';
import { StaffLoginComponent } from './staff-login/staff-login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { StaffBookingComponent } from './staff-booking/staff-booking.component';
import { StaffCancellationComponent } from './staff-cancellation/staff-cancellation.component';
import { StaffCheckinComponent } from './staff-checkin/staff-checkin.component';
import { StaffCheckoutComponent } from './staff-checkout/staff-checkout.component';
//import { TokenInterceptorService } from './service/token-interceptor.service';
import { StaffLoginService } from './service/staff-login.service';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { MapComponent } from './map/map.component';
import { HotelSelectionComponent } from './hotel-selection/hotel-selection.component';
import { BookingFormComponent } from './booking-form/booking-form.component';
import { BillingComponent } from './billing/billing.component';
import { FindTheHotelComponent } from './find-the-hotel/find-the-hotel.component';
import { FloorPlanComponent } from './floor-plan/floor-plan.component';
import { QuickHotelSelectionComponent } from './quick-hotel-selection/quick-hotel-selection.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { LeftNavComponent } from './left-nav/left-nav.component';
import { OwlDOMData } from 'ngx-owl-carousel-o/lib/models/owlDOM-data.model';
import { CarouselModule } from 'ngx-owl-carousel-o';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    LeftNavComponent,
    RightNavComponent,
    HomeComponent,
    StaffLoginComponent,
    StaffBookingComponent,
    StaffCancellationComponent,
    StaffCheckinComponent,
    StaffCheckoutComponent,
    ContactUsComponent,
    MapComponent,
    HotelSelectionComponent,
    BookingFormComponent,
    BillingComponent,
    FindTheHotelComponent,
    FloorPlanComponent,
    QuickHotelSelectionComponent,
    AboutUsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CarouselModule
  ],
  providers: [StaffLoginService /*, {
  //   provide: HTTP_INTERCEPTORS,
  //   useClass: TokenInterceptorService,
  //   multi: true
   } */ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
