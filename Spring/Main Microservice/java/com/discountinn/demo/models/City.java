package com.discountinn.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	
	private String city;

	public City() {
		super();
	}
	

	public City(int cityId, String city) {
		super();
		this.cityId = cityId;
		this.city = city;
	}


	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
