package com.company.spring.jdbc.model;

public class Client {
	private Long identityNumber;
	private String firstName, lastName, address;
	private Long phoneNumber;
	
	public void setClient(Long identityNumber,String firstName, String lastName, String address, Long phoneNumber) {
		this.identityNumber = identityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public Long getIdentityNumber() {
		return this.identityNumber;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public Long getPhoneNumber() {
		return this.phoneNumber;
	}	
	
	
	@Override
	public String toString(){
		return "{ID="+identityNumber+",First Name="+firstName+",Last Name="+lastName+",Address="+address+",Phone Number="+phoneNumber+"}";
	}	
}
