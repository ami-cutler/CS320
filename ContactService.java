package com.contactmanager.main;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts;

	public ContactService() {
		this.contacts = new HashMap<>();
	}
	
	// Add a new contact
	public void addContact (Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact with this ID already Exists");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	// Delete a contact by ID
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}
		contacts.remove(contactId);
	}
	
	// Update contact fields by ID
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
	    Contact contact = contacts.get(contactId);
	    
	    if (contact == null) {
	        throw new IllegalArgumentException("Contact not found");
	    }
	    if (firstName != null && !firstName.trim().isEmpty()) {
	        contact.setFirstName(firstName);
	    }
	    if (lastName != null && !lastName.trim().isEmpty()) {
	        contact.setLastName(lastName);
	    }
	    if (phone != null && !phone.trim().isEmpty()) {
	        if (!phone.matches("\\d{10}")) {
	            throw new IllegalArgumentException("Invalid Phone Number");
	        }
	        contact.setPhone(phone);
	    }
	    if (address != null && !address.trim().isEmpty()) {
	        contact.setAddress(address);
	    }    
	}
	
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}