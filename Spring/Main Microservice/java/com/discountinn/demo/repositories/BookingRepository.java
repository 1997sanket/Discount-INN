package com.discountinn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.discountinn.demo.models.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
	public Booking findByBookingId(long bookingId);
}
