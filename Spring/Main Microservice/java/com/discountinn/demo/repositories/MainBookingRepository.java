package com.discountinn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.discountinn.demo.models.MainBooking;

public interface MainBookingRepository extends JpaRepository<MainBooking, Long> {

}
