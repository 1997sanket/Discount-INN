package com.discountinn.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.discountinn.demo.models.Staff;
import com.discountinn.demo.repositories.StaffRepository;

@Service
public class CustomUserDetailsSevice implements UserDetailsService{
	
	@Autowired
	private StaffRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//Getting staff by username
		Optional<Staff> op = repo.findById(username);
		
		//Get Staff, if not found return HttpStatus Exception
		Staff ref = op.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such staff exists"));
		
		return new org.springframework.security.core.userdetails.User(ref.getUsername(), ref.getPassword(), new ArrayList<>());
	}
	
	

}
