package com.discountinn.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discountinn.demo.models.Billing;
import com.discountinn.demo.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private BillingRepository billingRepo;

	@Override
	public void saveBill(Billing bill) {
		
		billingRepo.save(bill);
	}

	@Override
	public Billing getBillByBookingId(long bookingId) {
		// TODO Auto-generated method stub
		return billingRepo.findByMainBookingId(bookingId);
	}

}
