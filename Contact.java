package com.contactmanager.main;

public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
	    if (contactId == null || contactId.length() > 10) {
	        throw new IllegalArgumentException("Invalid contact ID.");
	    }
	    if (firstName == null || firstName.trim().length() == 0 || firstName.length() > 10) {
	        throw new IllegalArgumentException("Invalid first name.");
	    }
	    if (lastName == null || lastName.trim().length() == 0 || lastName.length() > 10) {
	        throw new IllegalArgumentException("Invalid last name.");
	    }
	    if (phone == null || !phone.matches("\\d{10}")) {
	        throw new IllegalArgumentException("Invalid phone number.");
	    }
	    if (address == null || address.length() > 30) {
	        throw new IllegalArgumentException("Invalid address.");
	    }

	    this.contactId = contactId;
	    this.firstName = firstName.trim();
	    this.lastName = lastName.trim();
	    this.phone = phone;
	    this.address = address.trim();
	}
	
	// Getters
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	// Setters for fields that can be updated
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lastName;	
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
}

