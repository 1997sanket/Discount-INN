package com.discountinn.demo.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.discountinn.demo.models.Billing;
import com.discountinn.demo.models.Hotel;
import com.discountinn.demo.models.MainBooking;
import com.discountinn.demo.repositories.MainBookingRepository;

@Service
public class MainBookingServiceImpl implements MainBookingService {
	
	@Autowired
	private MainBookingRepository repo;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private BillingService billingService;
	
	

	@Override
	public void submitCheckinForm(MainBooking ref) {
		// TODO Auto-generated method stub
		repo.save(ref);
	}

	@Override
	public MainBooking getBooking(long id) {
		// TODO Auto-generated method stub
		MainBooking ref = repo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No such Booking id"));
		
		return ref;
	}

	@Override
	public void updateBooking(MainBooking ref) {
		// TODO Auto-generated method stub
		repo.save(ref);
	}

	@Override
	public void saveBill(MainBooking ref) {
		// TODO Auto-generated method stub
		
		String checkInStr = ref.getCheckIn();
		String checkOutStr = ref.getCheckOut();
		
		
		
		Date checkIn = null;
		Date checkOut = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			//Converting String dates to Date type
			 checkIn = sdf.parse(checkInStr);
			 checkOut = sdf.parse(checkOutStr);
			 
			 System.out.println("Now checkin " + checkIn);
			 System.out.println("Now checkout " + checkOut);
			
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
		
		
		long differenceInTime = checkOut.getTime() - checkIn.getTime();
		
		long differenceInDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;
		
		//Actual no of days customer stayed in the hotel
		long noOfDaysStayed = differenceInDays + 1;
		
		System.out.println("No of days stayed " + noOfDaysStayed);
		
		//Getting rent
		double rentPerDay = hotel.getRoomType().getRent();

		double totalAmount = calculateTotal(roomType, rentPerDay, noOfDaysStayed);
		
		
		
		Billing bill = new Billing(firstName, lastName, email, mobile, hotelName, roomType,
				checkIn, checkOut, mainBookingId, rentPerDay, totalAmount);
		
		
		//Save bill in database
		billingService.saveBill(bill);  
		
		System.out.println(bill); 
		
	}
	
	
	private double calculateTotal(int roomType, double rentPerDay, long noOfDaysStayed) {
		
			double totalAmount = 0;
			
			//System.out.println("no of days stayed = " + noOfDaysStayed);
		
				//If room was Standard
				if(roomType == 1) {
					
					for(long i = 1; i<=noOfDaysStayed; i++) {
						totalAmount = totalAmount + rentPerDay;
					}
					
				}
				
				//If room was Deluxe
				if(roomType == 2) {
					for(long i = 1; i<=noOfDaysStayed; i++) {
						totalAmount = totalAmount + rentPerDay;
					}
				}
				
				//If room was Premium
				if(roomType == 3) {
					for(long i = 1; i<=noOfDaysStayed; i++) {
						totalAmount = totalAmount + rentPerDay;
					}
				}
				
				
				//If room was Abroad
				if(roomType == 4) {
					for(long i = 1; i<=noOfDaysStayed; i++) {
						totalAmount = totalAmount + rentPerDay;
					}
				}
				
				
				return totalAmount;
	}

	@Override
	public void deleteBooking(long ref) {
		MainBooking booking = repo.getOne(ref);
		
		if(booking!=null) {
			repo.delete(booking);
		}
		
	}
	
	
	
	
	
	
	
	

}
