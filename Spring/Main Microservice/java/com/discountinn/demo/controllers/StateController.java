package com.discountinn.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.discountinn.demo.models.City;
import com.discountinn.demo.models.State;
import com.discountinn.demo.repositories.CityRepository;
import com.discountinn.demo.services.StateService;

@CrossOrigin(origins="http://localhost:4200")
@RestController	
public class StateController {

	@Autowired
	StateService stateService;
	
	@Autowired
	CityRepository cityRepository;

	//Get list of States with Eager loaded cities
	@GetMapping("/states")
	public List<State> getStates(){
		return stateService.getStates();
	}
	
	@GetMapping("/city/{id}")
	public City getCities(@PathVariable("id") int id) {
		return cityRepository.findById(id).get();
	}

}
