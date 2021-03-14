package com.discountinn.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.discountinn.demo.models.Booking;
import com.discountinn.demo.services.BookingService;

@CrossOrigin
@RestController	
public class BookingController {

@Autowired
BookingService bookingService;
	
	@GetMapping("/booking/{bookingId}")
	public Booking getbooking(@PathVariable("bookingId") long bookingId) {
		//return this.bookingService.findByBookingId(bookingId);
		
		Booking ref = this.bookingService.findByBookingId(bookingId);
		if(ref != null ) {
			return ref;
		}
		
		else {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "No such Booking id exists.");
		}
	}
	
	@PostMapping("/booking")
	public Booking addBooking(@RequestBody Booking booking) {
		System.out.println(booking);
		return this.bookingService.newBooking(booking);
		
	}
	
	@PutMapping("/booking/{bookingId}")
	public Booking updateHotel(@RequestBody Booking booking, @PathVariable("bookingId") long bookingId) {
		return this.bookingService.updateBooking(booking, bookingId);
	}
	
	@DeleteMapping("/booking/{bookingId}")
	public /*Booking*/ void deleteBooking(@PathVariable long bookingId) {
		
		//System.out.println(bookingId);
		this.bookingService.deleteBooking(bookingId);
		
		//return null;
	}
}
