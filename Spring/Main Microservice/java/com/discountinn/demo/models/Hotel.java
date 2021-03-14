package com.discountinn.demo.models;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long hotelId;
	private String hotelName;
	private String emailAddress;
	private String contactNo;
	private String city;
	private String state;
	private String pinCode;
	private float distFromCityCenter;
	private int totalRooms;
	private int availableRooms;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private RoomType roomType;
	
	
	public Hotel() {
		super();
	}
		
	public Hotel(long hotelId, String hotelName, String emailAddress, String contactNo, String city, String state,
			 String pinCode, float distFromCityCenter, int totalRooms, int availableRooms) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.distFromCityCenter = distFromCityCenter;
		this.totalRooms = totalRooms;
		this.availableRooms = availableRooms;
	}

	public long getHotelId() {
		return hotelId;
	}
	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	public float getDistFromCityCenter() {
		return distFromCityCenter;
	}
	public void setDistFromCityCenter(float distFromCityCenter) {
		this.distFromCityCenter = distFromCityCenter;
	}

	public int getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	public int getAvailableRooms() {
		return availableRooms;
	}
	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}		
}
