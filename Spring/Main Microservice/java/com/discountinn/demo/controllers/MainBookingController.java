/**
 * 
 */
package com.discountinn.demo.controllers;



import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.discountinn.demo.models.Billing;
import com.discountinn.demo.models.Hotel;
import com.discountinn.demo.models.MainBooking;
import com.discountinn.demo.services.BillingService;
import com.discountinn.demo.services.BookingService;
import com.discountinn.demo.services.HotelService;
import com.discountinn.demo.services.MainBookingService;

/**
 * @author Sanket
 *
 */
@RestController
@CrossOrigin
public class MainBookingController {

		@Autowired
		private MainBookingService service;
		
		@Autowired
		private HotelService hotelService;
		
		@Autowired
		private BookingService bookingService;
		
		@Autowired
		private BillingService billingService;
	
		
		
		
	
		@PostMapping("/main-booking") 
		public void submitCheckinForm(@RequestBody MainBooking ref) {
			
			service.submitCheckinForm(ref);
			
			//Now decrease no of available rooms in hotel table
			//QUery = update hotel set available_rooms = 40 where hotel_id = 15
			
			///SO first get available rooms count
			int available_rooms = hotelService.getAvailableRooms(ref.getHotelId());
			
			//Decrease the count by 1
			available_rooms = available_rooms - 1;
			
			//Update in database
			hotelService.decreaseAvailableRooms(ref.getHotelId(), available_rooms);
			
			this.bookingService.deleteBooking(ref.getBookingId());
		}
		
		
		@GetMapping("/main-booking/{bookingId}")
		public MainBooking getMainBooking(@PathVariable long bookingId) {
			
			return service.getBooking(bookingId);
			
		}
		
		
		@PutMapping("/main-booking")
		public void updateBooking(@RequestBody MainBooking ref) {
			
			System.out.println("in main booking controller");
			
			if(ref.getCheckOut() != "") {
				
				//saving Bill in database
				service.saveBill(ref);
				
				//First update MainBooking with new checkout date
				service.updateBooking(ref);
				
				
				//Now again increase the no of available rooms
				int available_rooms = hotelService.getAvailableRooms(ref.getHotelId());
				
				
				//Now increase 
				available_rooms = available_rooms + 1;
				
				//Now update in database
				hotelService.increaseAvailableRooms(ref.getHotelId(), available_rooms);
				
				
				//Deleted
				service.deleteBooking(ref.getBookingId());
				
				
				
				
				
				
				
				
				
				
				
				
				/*//saving Bill in database
				service.saveBill(ref); */
				
			/*	//Below steps are for Bill creation
				
				String checkInStr = ref.getCheckIn();
				String checkOutStr = ref.getCheckOut();
				
				Date checkIn = null;
				Date checkOut = null;
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					
					//Converting String dates to Date type
					 checkIn = sdf.parse(checkInStr);
					 checkOut = sdf.parse(checkOutStr);
					
				}
				catch (Exception e) {
					System.out.println(e);
				}
				
				
				//Extracting customer details
				String firstName = ref.getCustomer().getFirstName();
				String lastName = ref.getCustomer().getLastName();
				String email = ref.getCustomer().getEmail();
				String mobile = ref.getCustomer().getMobile();
				long mainBookingId = ref.getBookingId();
				
				long hotelId = ref.getHotelId();
				
				Hotel hotel = hotelService.getHotel(hotelId);
				
				//Getting Hotel name
				String hotelName = hotel.getHotelName();
				
				//Getting room type
				int roomType = hotel.getRoomType().getRoomTypeId();
				
				
				
				Billing bill = new Billing(firstName, lastName, email, mobile, hotelName, roomType,
						checkIn, checkOut, mainBookingId);
				
				billingService.saveBill(bill);  
				
				System.out.println(bill);  */
				
				
			}
			
			else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please enter checkout date");
			}
		
		}
		
		
		
		
		
}
