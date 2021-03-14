package com.discountinn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.discountinn.demo.models.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {
	


}
