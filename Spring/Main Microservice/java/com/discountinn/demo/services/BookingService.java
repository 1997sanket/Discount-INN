package com.discountinn.demo.services;
import com.discountinn.demo.models.Booking;

public interface BookingService {
	
	public Booking findByBookingId(long bookingId);
	
	public Booking newBooking(Booking booking);
	
	public void deleteBooking(long bookingId);
	
	public Booking updateBooking(Booking booking, long bookingId);

	
}
