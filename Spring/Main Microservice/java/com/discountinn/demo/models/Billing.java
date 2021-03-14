package com.discountinn.demo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Billing {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String hotelName;
	private int roomType;
	private long mainBookingId;
	private double rentPerDay;
	private double totalAmount;

	private Date checkIn;
	private Date checkOut;
	
	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Billing(String firstName, String lastName, String email, String mobile, String hotelName, int roomType,
			Date checkIn, Date checkOut, long mainBookingId, double rentPerDay, double totalAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.mainBookingId = mainBookingId;
		this.rentPerDay = rentPerDay;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	

	public long getMainBookingId() {
		return mainBookingId;
	}

	public void setMainBookingId(long mainBookingId) {
		this.mainBookingId = mainBookingId;
	}
	
	

	public double getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Billing [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", hotelName=" + hotelName + ", roomType=" + roomType + ", mainBookingId="
				+ mainBookingId + ", rentPerDay=" + rentPerDay + ", totalAmount=" + totalAmount + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + "]";
	}

	
	
	
	
}
