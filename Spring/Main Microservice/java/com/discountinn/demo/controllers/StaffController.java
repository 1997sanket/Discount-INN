package com.discountinn.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.discountinn.demo.models.AuthRequest;
import com.discountinn.demo.models.Staff;
import com.discountinn.demo.services.StaffService;
import com.discountinn.demo.util.JwtUtil;

@RestController
@CrossOrigin
public class StaffController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private StaffService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/hello")
	public String welcome() {
		return "hello";
	}
		
	
	/*
	 * Need to tell Spring 
	 * 	- If request is coming for "localhost:8080/authenticate" then don't apply security(don't ask for username and password)
	 */
	@PostMapping("/authenticate")
	public String generateToken( @RequestBody Staff obj) {
		
		//Getting staff by username
		Staff ref = service.getStaffByUsername(obj.getUsername());
		
		AuthRequest authRequest = null;
		
		//If hotelCode of sent Staff is same as hotelCOde of the fetched staff
		if(ref.getHotelCode() == obj.getHotelCode()) {
			
				//Create authRequest object and send username and password
			 	authRequest = new AuthRequest();
			 	
				authRequest.setUsername(obj.getUsername());
				authRequest.setPassword(obj.getPassword());
			
			try {
				
				//Validates username and password
				authenticationManager.authenticate(
						
						new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
						);
				
				
			}catch (Exception e) {
				
				//throw new Exception("Invalid credentials");
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid credentials");
			}
			
			
		} else {
			return "hotelCodeInvalid";
		}
		
		
		
		//If valid user then generate token
		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
