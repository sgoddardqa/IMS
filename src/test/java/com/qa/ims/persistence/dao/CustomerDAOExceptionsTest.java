package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDAOExceptionsTest {	
	
	@Mock
	private DBUtils dbutils;
	
	@InjectMocks
	private CustomerDAO customerDao;
	
	@Test
	public void readAllExceptionTest() throws SQLException {
		List<Customer> expected = new ArrayList<>();
		when(dbutils.getConnection()).thenThrow(new SQLException("Oh no an SQL exception"));
		assertTrue(customerDao.readAll().equals(expected));
	}
	
	@Test
	public void readLatestExceptionTest() {
		assertNull(customerDao.readLatest());
	}
	
	@Test
	public void createExceptionTest() {
		Customer customer = new Customer("Stephen", "Fry");
		assertNull(customerDao.create(customer));
	}
	
	@Test
	public void readCustomerExceptionTest() {
		assertNull(customerDao.readCustomer(1L));
	}
	
	@Test
	public void updateExceptionTest() {
		Customer customer = new Customer("Rowan", "Atkinson");
		assertNull(customerDao.update(customer));
	}
	
	@Test
	public void deleteExceptionTest() {
		assertTrue(customerDao.delete(1L) == 0);
	}
	
	@Test
	public void readCustomerOrdersExceptionTest() throws SQLException {
		List<Customer> expected = new ArrayList<>();
		when(dbutils.getConnection()).thenThrow(new SQLException("Oh no an SQL exception"));
		assertTrue(customerDao.readCustomerOrders(1L).equals(expected));
	}
	
}
