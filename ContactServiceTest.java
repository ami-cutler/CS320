package com.contactmanager.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.contactmanager.main.Contact;
import com.contactmanager.main.ContactService;

public class ContactServiceTest {

	@Test
	public void testAddContactSuccess() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street Name");
		service.addContact(contact);
		
		assertEquals(contact, service.getContact("12345"));
	}
	
	@Test
	public void testAddContactDuplicateId() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Street Name");
		Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 New Address");
		service.addContact(contact1);
		
		assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
	}
	
	@Test
	public void testDeleteContactSuccess() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street Name");
		service.addContact(contact);
		
		service.deleteContact("12345");
		assertNull(service.getContact("12345"));
	}
	
	@Test
	public void testUpdateContactSuccess() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street Name");
		service.addContact(contact);
		
		service.updateContact("12345", "Jane", "Smith", "0987654321", "456 New Address");
		
		Contact updatedContact = service.getContact("12345");
		assertEquals("Jane", updatedContact.getFirstName());
		assertEquals("Smith", updatedContact.getLastName());
		assertEquals("0987654321", updatedContact.getPhone());
		assertEquals("456 New Address", updatedContact.getAddress());
	}
	
	@Test
	public void testDeleteContactNonExisting() {
	    ContactService service = new ContactService();
	    assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
	}

	@Test
	public void testUpdateContactNonExisting() {
	    ContactService service = new ContactService();
	    assertThrows(IllegalArgumentException.class, () -> service.updateContact("99999", "Jane", "Smith", "0987654321", "456 New Address"));
	}
	
    @Test
    public void testContactFieldsAtBoundaryLimits() {
        Contact contact = new Contact("1234567890", "FirstName1", "LastName2", "0123456789", "123 Main Street, Apt 3B");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("FirstName1", contact.getFirstName());
        assertEquals("LastName2", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123 Main Street, Apt 3B", contact.getAddress());
    }

    @Test
    public void testPhoneNumberWithInvalidFormat() {
        // Invalid phone number with dashes
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "012-345-6789", "123 Main St");
        });
    }
    
    @Test
    public void testWhitespaceHandlingInNamesAndAddress() {
        // Test for leading/trailing spaces
        Contact contact = new Contact("1234567890", "  John  ", "  Doe  ", "0123456789", "  123 Main St  ");
        assertEquals("John", contact.getFirstName().trim());
        assertEquals("Doe", contact.getLastName().trim());
        assertEquals("123 Main St", contact.getAddress().trim());
    }
}
