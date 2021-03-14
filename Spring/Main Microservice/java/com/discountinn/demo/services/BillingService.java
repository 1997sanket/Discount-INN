package com.discountinn.demo.services;

import com.discountinn.demo.models.Billing;

public interface BillingService {

	void saveBill(Billing bill);
	
	Billing getBillByBookingId(long bookingId);
}
