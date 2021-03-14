package com.discountinn.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private long custId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String mobile;
	
	public Customer()
	{
		super();
	}
	
	public Customer(/*long custId, */ String firstName, String lastName, String email, String address, String mobile) {
		super();
		//this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
	}
	
	public long getCustId() {
		return custId;
	}
	/*public void setCustId(long custId) {
		this.custId = custId;
	}
	*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	

}
