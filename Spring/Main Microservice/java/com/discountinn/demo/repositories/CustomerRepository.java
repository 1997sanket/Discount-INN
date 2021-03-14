package com.discountinn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.discountinn.demo.models.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
	
	public Customer findByCustId(long custid);
	public Customer findByEmail(String email);
	public Customer findByFirstName(String firstName);
	

}
