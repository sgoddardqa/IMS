package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

@RunWith(MockitoJUnitRunner.class)
public class OrderDAOExceptionsTest {	
	
	@Mock
	private DBUtils dbutils;
	
	@InjectMocks
	private OrderDAO orderDao = new OrderDAO(dbutils);
	
	@Test
	public void readAllExceptionTest() throws SQLException {
		List<Order> expected = new ArrayList<>();
		when(dbutils.getConnection()).thenThrow(new SQLException("Oh no an SQL exception"));
		assertTrue(orderDao.readAll().equals(expected));
	}
	
	@Test
	public void readLatestExceptionTest() {
		assertNull(orderDao.readLatest());
	}
	
	@Test
	public void createExceptionTest() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		assertNull(orderDao.create(order));
	}
	
	@Test
	public void readCustomerExceptionTest() {
		assertNull(orderDao.readOrder(1L));
	}
	
	@Test
	public void updateExceptionTest() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		assertNull(orderDao.update(order));
	}
	
	@Test
	public void deleteExceptionTest() {
		assertTrue(orderDao.delete(1L) == 0);
	}
	
	@Test
	public void readOrderItemsExceptionTest() throws SQLException {
		List<Order> expected = new ArrayList<>();
		when(dbutils.getConnection()).thenThrow(new SQLException("Oh no an SQL exception"));
		assertTrue(orderDao.readOrderItems(1L).equals(expected));
	}
	
	@Test
	public void readOrderCostExceptionTest() throws SQLException {
		when(dbutils.getConnection()).thenThrow(new SQLException("Oh no an SQL exception"));
		assertTrue(orderDao.readOrderCost(1L) == 0.0);
	}
	
}
