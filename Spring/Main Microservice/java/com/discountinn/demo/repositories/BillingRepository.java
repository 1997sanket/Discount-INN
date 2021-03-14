package com.discountinn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.discountinn.demo.models.Billing;

public interface BillingRepository extends JpaRepository<Billing, Integer> {

			@Query(value = "SELECT * FROM billing where main_booking_id = ?1", nativeQuery = true)
			Billing findByMainBookingId(long bookingId);
}
