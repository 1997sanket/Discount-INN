package com.discountinn.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.discountinn.demo.models.Billing;
import com.discountinn.demo.services.BillingService;

@RestController
@CrossOrigin
public class BillingController {
	
	@Autowired 
	private BillingService billingService;
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/billing/{bookingId}")
	public Billing getBillByBookingId(@PathVariable String bookingId) {
		
		System.out.println("Inside Billing controller");
		
		Billing ref = billingService.getBillByBookingId(Long.parseLong(bookingId));
		
		System.out.println("Bill retrieved from DB = " + ref);
		
		return ref;
	}
	
	
	@PostMapping("/printPdf")
	public void printPdf(@RequestBody Billing bill) {
		System.out.println(bill);
		
		//Sending data to another microservice
		
		//Wrapping bill object in the HttpEntity object
		HttpEntity<Billing> request = new HttpEntity<>(bill);

		ResponseEntity<Billing> response = 

						// url									POST		 Entity	  class Class instance
		template.exchange("http:localhost:8081/printPdf", HttpMethod.POST, request, Billing.class);
		 
		//assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
		 
		Billing ref = response.getBody();
		
		System.out.println("Getting response from 8081 server = " + ref);
		 
//		assertThat(ref, notNullValue());
//		assertThat(ref.getName(), is("bar"));
	}
	
	
	@PostMapping("/emailPdf")
	public void emailPdf(@RequestBody Billing bill) {
		System.out.println(bill);
		
		//Sending data to another microservice
		
		//Wrapping bill object in the HttpEntity object
		HttpEntity<Billing> request = new HttpEntity<>(bill);

		ResponseEntity<Billing> response = 

						// url									POST		 Entity	  class Class instance
		template.exchange("http:localhost:8081/emailPdf", HttpMethod.POST, request, Billing.class);
		 
		//assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
		 
		Billing ref = response.getBody();
		
		System.out.println("Getting response from 8081 server = " + ref);
	}

}
