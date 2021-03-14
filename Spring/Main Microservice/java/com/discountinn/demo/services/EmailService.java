package com.discountinn.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.discountinn.demo.models.Customer;



@Service
public class EmailService {
	
	private JavaMailSender javaMailSender;
		
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	
	@Async
	public void sendBookingConfirmation(long bookingId,Customer customer) throws MailException{
		//send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(customer.getEmail());
		mail.setFrom("noreply.discount-inn@gmail.com");
		mail.setSubject("Booking Email");
		mail.setText("Hello "+customer.getFirstName()+" "+ customer.getLastName()+
				" your booking reference number is "+"B0000_"+bookingId+".");
	
		this.javaMailSender.send(mail);
	}
}
