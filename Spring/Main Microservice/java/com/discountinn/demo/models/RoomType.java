package com.discountinn.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class RoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomTypeId;
	private String roomType;
	private double rent;
	
	public RoomType() {
		super();
	}
	
	

	public RoomType(int roomTypeId, String roomType, double rent) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomType = roomType;
		this.rent = rent;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	
	
	
	
}
