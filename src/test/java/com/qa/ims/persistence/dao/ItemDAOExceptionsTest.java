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

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

@RunWith(MockitoJUnitRunner.class)
public class ItemDAOExceptionsTest {	
	
	@Mock
	private DBUtils dbutils;
	
	@InjectMocks
	private ItemDAO itemDao = new ItemDAO(dbutils);
	
	@Test
	public void readAllExceptionTest() throws SQLException {
		List<Item> expected = new ArrayList<>();
		when(dbutils.getConnection()).thenThrow(new SQLException("Oh no an SQL exception"));
		assertTrue(itemDao.readAll().equals(expected));
	}
	
	@Test
	public void readLatestExceptionTest() {
		assertNull(itemDao.readLatest());
	}
	
	@Test
	public void createExceptionTest() {
		Item item = new Item("dark matter", -10.0);
		assertNull(itemDao.create(item));
	}
	
	@Test
	public void readCustomerExceptionTest() {
		assertNull(itemDao.readItem(1L));
	}
	
	@Test
	public void updateExceptionTest() {
		Item item = new Item("invisible shoes", 100.0);
		assertNull(itemDao.update(item));
	}
	
	@Test
	public void deleteExceptionTest() {
		assertTrue(itemDao.delete(1L) == 0);
	}
	
}
