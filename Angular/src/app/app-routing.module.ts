import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { BillingComponent } from './billing/billing.component';
import { BookingFormComponent } from './booking-form/booking-form.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { FindTheHotelComponent } from './find-the-hotel/find-the-hotel.component';
import { FloorPlanComponent } from './floor-plan/floor-plan.component';
import { HomeComponent } from './home/home.component';
import { HotelSelectionComponent } from './hotel-selection/hotel-selection.component';
import { MapComponent } from './map/map.component';
import { QuickHotelSelectionComponent } from './quick-hotel-selection/quick-hotel-selection.component';
import { StaffLoginService } from './service/staff-login.service';
import { StaffBookingComponent } from './staff-booking/staff-booking.component';
import { StaffCancellationComponent } from './staff-cancellation/staff-cancellation.component';
import { StaffCheckinComponent } from './staff-checkin/staff-checkin.component';
import { StaffCheckoutComponent } from './staff-checkout/staff-checkout.component';
import { StaffLoginGuard } from './staff-login.guard';
import { StaffLoginComponent } from './staff-login/staff-login.component';

const routes: Routes = [
  { path: "home", component: HomeComponent },
  { path: "", component: HomeComponent },
  { path: "booking-form/:hotel", component: BookingFormComponent },
  { path: "staff-login", component: StaffLoginComponent },
  { path: "staff-booking", component: StaffBookingComponent, canActivate: [StaffLoginGuard] },
  { path: "staff-cancellation", component: StaffCancellationComponent, canActivate: [StaffLoginGuard] },
  { path: "staff-checkin", component: StaffCheckinComponent, canActivate: [StaffLoginGuard] },
  { path: "staff-checkout", component: StaffCheckoutComponent, canActivate: [StaffLoginGuard] },
  { path: 'map', component: MapComponent },
  { path: 'hotel-selection/:state', component: HotelSelectionComponent },
  { path: 'find-the-hotel', component: FindTheHotelComponent },
  { path: 'billing/:id', component: BillingComponent, canActivate: [StaffLoginGuard] },
  { path: 'getHotelByPinCode/:pinCode', component: HotelSelectionComponent },
  { path: 'floor-plan', component: FloorPlanComponent },
  { path: 'quick-hotel-selection/city/:cityCode', component: QuickHotelSelectionComponent },
  { path: 'about-us', component: AboutUsComponent },
  { path: 'contact-us', component: ContactUsComponent },
  { path: "**", component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  hotelCode = parseInt(localStorage.getItem('hotelCode'));
}
