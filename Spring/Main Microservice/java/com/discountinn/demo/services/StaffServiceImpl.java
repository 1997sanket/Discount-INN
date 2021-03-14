package com.discountinn.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.discountinn.demo.models.Staff;
import com.discountinn.demo.repositories.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepository repo ;
	
	@Override
	public Staff getStaffByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findById(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user"));
			
	}

}
