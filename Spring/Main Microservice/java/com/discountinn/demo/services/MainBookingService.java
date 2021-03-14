package com.discountinn.demo.services;

import com.discountinn.demo.models.Billing;
import com.discountinn.demo.models.MainBooking;

public interface MainBookingService {
	
	//Submit booking
	void submitCheckinForm(MainBooking ref);
	
	
	//Get Booking
	MainBooking getBooking(long id);
	
	//Update
	void updateBooking(MainBooking ref);
	
	void deleteBooking(long ref);
	
	void saveBill(MainBooking booking);

}
