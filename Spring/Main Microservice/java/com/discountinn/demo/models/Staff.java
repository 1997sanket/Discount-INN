package com.discountinn.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Staff {

	
	@Id
	private String username;
	private String password;
	private long hotelCode;
	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(String username, String password, long hotelCode) {
		super();
		this.username = username;
		this.password = password;
		this.hotelCode = hotelCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(long hotelCode) {
		this.hotelCode = hotelCode;
	}
	
	
	
	
	
}
