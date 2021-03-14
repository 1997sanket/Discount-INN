package com.discountinn.demo.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stateId;
	private String state;
	
	@OneToMany(targetEntity = City.class, cascade = CascadeType.ALL)
	@JoinColumn(name="state_id", referencedColumnName="stateId")
	private Set<City> cities;
	
	public State() {
		super();
	}	
	
	
	public State(int stateId, String state, Set<City> cities) {
		super();
		this.stateId = stateId;
		this.state = state;
		this.cities = cities;
	}


	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public Set<City> getCities() {
		return cities;
	}
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	
	
	
}
