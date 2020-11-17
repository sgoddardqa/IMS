package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomerTest {
	
	@Test
	public void constructor1Test() {
		Customer customer = new Customer("Elon", "Musk");
		assertTrue(customer instanceof Customer);
	}
	
	@Test
	public void constructor2Test() {
		Customer customer = new Customer(0L, "Bill", "Gates");
		assertTrue(customer instanceof Customer);
	}
	
	@Test
	public void getIdTest() {
		Customer customer = new Customer(1L, "Fred", "Flintstone");
		assertTrue(customer.getId() == 1L);
	}
	
	@Test
	public void setIdTest() {
		Customer customer = new Customer("Bart", "Simpson");
		customer.setId(5L);
		assertTrue(customer.getId() == 5L);
	}
	
	@Test
	public void getFirstNameTest() {
		Customer customer = new Customer("Michael", "Jackson");
		assertTrue(customer.getFirstName().equals("Michael"));
	}
	
	@Test
	public void setFirstNameTest() {
		Customer customer = new Customer("James", "May");
		customer.setFirstName("Theresa");
		assertTrue(customer.getFirstName().equals("Theresa"));
	}
	
	@Test
	public void getSurnameTest() {
		Customer customer = new Customer("Steve", "Jobs");
		assertTrue(customer.getSurname().equals("Jobs"));
	}
	
	@Test
	public void setSurnameTest() {
		Customer customer = new Customer("Peter", "Parker");
		customer.setSurname("Pan");
		assertTrue(customer.getSurname().equals("Pan"));
	}
	
	@Test
	public void toStringTest() {
		Customer customer = new Customer(1L, "Hermione", "Granger");
		assertTrue(customer.toString().equals("id:1, first name:Hermione, surname:Granger"));
	}
	
	@Test
	public void equals1Test() {
		Customer customer = new Customer(1L, "Mark", "Brown");
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void equals2Test() {
		Customer customer = new Customer(1L, "Tinkie", "Winkie");
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equals3Test() {
		Customer customer = new Customer(1L, "Boris", "Johnson");
		String string = new String();
		assertFalse(customer.equals(string));
	}
	
	@Test
	public void equals4Test() {
		Customer customer = new Customer(1L, null, "Mario");
		Customer customer2 = new Customer(1L, "Mario", "Mario");
		assertFalse(customer.equals(customer2));
	}
	
	@Test
	public void equals5Test() {
		Customer customer = new Customer(1L, "Candace", "Flynn");
		Customer customer2 = new Customer(1L, "Phineas", "Flynn");
		assertFalse(customer.equals(customer2));
	}
	
	@Test
	public void equals6Test() {
		Customer customer = new Customer("Toby", "Fox");
		Customer customer2 = new Customer(1L, "Toby", "Fox");
		assertFalse(customer.equals(customer2));
	}
	
	@Test
	public void equals7Test() {
		Customer customer = new Customer(3L, "Florence", "Nightingale");
		Customer customer2 = new Customer(4L, "Florence", "Nightingale");
		assertFalse(customer.equals(customer2));
	}
	
	@Test
	public void equals8Test() {
		Customer customer = new Customer(1L, "Queen", null);
		Customer customer2 = new Customer(1L, "Queen", "Elizabeth");
		assertFalse(customer.equals(customer2));
	}
	
	@Test
	public void equals9Test() {
		Customer customer = new Customer(1L, "Harry", "Potter");
		Customer customer2 = new Customer(1L, "Harry", "Hill");
		assertFalse(customer.equals(customer2));
	}
	
	@Test
	public void equals10Test() {
		Customer customer = new Customer(1L, "Bill", "Cipher");
		Customer customer2 = new Customer(1L, "Bill", "Cipher");
		assertTrue(customer.equals(customer2));
	}
	
	@Test
	public void equals11Test() {
		Customer customer = new Customer(null, null, null);
		Customer customer2 = new Customer(null, null, null);
		assertTrue(customer.equals(customer2));
	}

}
