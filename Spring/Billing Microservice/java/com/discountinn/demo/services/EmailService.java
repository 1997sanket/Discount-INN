package com.discountinn.demo.services;

import java.io.File;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	 
	@Async
	public void sendEmail(String To, String path, long bookingId) throws Exception{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(To);
        helper.setText("<html><body><h1>Thankyou for visiting DiscountInn  :) </h1><body></html>", true);
        //helper.set
        FileSystemResource file  = new FileSystemResource(new File(path));
        helper.addAttachment("B0000_" + bookingId + " Invoice.pdf", file);
        //helper.addAttachment("test.png", new ClassPathResource("test.jpeg"));
        helper.setSubject("Discount-INN Invoice");
        mailSender.send(message);
  }
	
}
