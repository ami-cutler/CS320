package com.contactmanager.test;

import org.junit.jupiter.api.Test;
import com.contactmanager.main.Contact;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	
	@Test
	public void testContactCreationSuccess() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street Name");
		assertEquals("12345", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Street Name", contact.getAddress());
	}
	
	@Test
	public void testContactCreationInvalidId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "1234567890", "123 Street Name");
		});
	}
	
	@Test
	public void testSettersSuccess() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street Name");
		contact.setFirstName("Jane");
		contact.setLastName("Smith");
		contact.setPhone("0987654321");
		contact.setAddress("456 New Address");
		
		assertEquals("Jane", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("0987654321", contact.getPhone());
		assertEquals("456 New Address", contact.getAddress());
	}
	
	@Test
	public void testSetFirstNameInvalid() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street Name");
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
	}
	
	@Test
	public void testContactCreationInvalidPhone() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "John", "Doe", "12345", "123 Street Name"); // Too short
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "John", "Doe", "12345678901", "123 Street Name"); // Too long
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12345", "John", "Doe", "12345abcd0", "123 Street Name"); // Non-numeric
	    });
	}

    @Test
    public void testNullOrEmptyFields() {
        // Test for null first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "0123456789", "123 Main St");
        });

        // Test for empty first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "", "Doe", "0123456789", "123 Main St");
        });
        
        // Test for empty last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Bob", "", "0123456789", "123 Main St");
        });
        
        // Test for null last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Bob", null, "0123456789", "123 Main St");
        });
        
        // Test for null phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Bob", "Smith", null, "123 Main St");
        });
        
        // Test for empty phone number 
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Smith", "", "123 Main St");
        });
    }
}
