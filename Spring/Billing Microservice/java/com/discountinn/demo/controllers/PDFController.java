package com.discountinn.demo.controllers;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.discountinn.demo.models.Billing;
import com.discountinn.demo.services.EmailService;
import com.discountinn.demo.services.InvoiceService;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin
public class PDFController {

	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@PostMapping("/emailPdf")
	public void sendPdfToEmail(@RequestBody Billing ref) throws Exception {
		
		String fileToAttach = invoiceService.exportInvoice(ref);
		
		emailService.sendEmail(ref.getEmail(),fileToAttach, ref.getMainBookingId());
	}
	
	@PostMapping("/printPdf")
	public void getBillObject(@RequestBody Billing ref) throws FileNotFoundException, JRException, ParseException {
		System.out.println(ref);
		
	/*	
		Date checkIn = ref.getCheckIn();
		Date checkOut = ref.getCheckOut();
		
		//String checkInStr = checkIn();
		String chekOutStr = checkOut.toLocaleString();
		
		//System.out.println(checkInStr);
		
		final String OLD_FORMAT = "yyyy-MM-dd";
		final String NEW_FORMAT = "dd/MM/yyyy";

		// August 12, 2010
		String oldDateString = "12/08/2010";
		String newDateString;

		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		//Date d = sdf.parse(oldDateString);
		
		sdf.applyPattern(NEW_FORMAT);
		
		Date checkin = ref.getCheckIn();
		Date checkout = ref.getCheckOut();
		
		String newDateStringCheckin = sdf.format(checkin);
		String newDateStringCheckout = sdf.format(checkout);
		
		System.out.println(newDateStringCheckin);
		
		
		SimpleDateFormat sdf2 = new SimpleDateFormat(NEW_FORMAT);
		ref.setCheckIn(sdf2.parse(newDateStringCheckin));
		ref.setCheckOut(sdf2.parse(newDateStringCheckout));  */
		
		invoiceService.exportInvoice(ref);
	}
}
