package com.discountinn.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.discountinn.demo.repositories.BookingRepository;
import com.discountinn.demo.repositories.CustomerRepository;

import com.discountinn.demo.models.Booking;


@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	public BookingRepository bookingrepo;
	
	@Autowired
	public CustomerRepository customerrepo;
	
	@Autowired
	public EmailService emailService;
	
	

	@Override
	public Booking findByBookingId(long bookingId) {
		return this.bookingrepo.findByBookingId(bookingId);
	}

	
	@Override
	public Booking newBooking(Booking booking) {
		//return this.bookingrepo.save(booking);
		
		Booking booked = this.bookingrepo.save(booking);
		
		if(booked!=null)
		{
			//send email
			try {
				this.emailService.sendBookingConfirmation(booked.getBookingId(), booked.getCustomer());
			}
			catch(MailException e) {
				//this.logger.info("Sending Mail error:"+ e.getMessage());
				System.out.println("Booking mail exception");
			}
			
		}
		return booked;
	}


	@Override
	public void deleteBooking(long bookingId) {
		/*Booking booking= this.bookingrepo.getOne(bookingId);
		if(booking!=null) {
			this.bookingrepo.delete(booking);
		}
		return booking; */
		try {
			
			bookingrepo.deleteById(bookingId);
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no such id");
		}
	}


	@Override
	public Booking updateBooking(Booking booking, long bookingId) {
		Booking booking1 = this.bookingrepo.getOne(bookingId);
		if(booking1 !=null) {
			this.bookingrepo.save(booking);
		}
		return booking;
		
	}

}
