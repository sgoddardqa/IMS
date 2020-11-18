package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		List<Long> itemList = new ArrayList<>();
		itemList.add(1L);
		final Order created = new Order(2L, 1L, itemList);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Long> itemList = new ArrayList<>();
		itemList.add(1L);
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, itemList));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		List<Long> itemList = new ArrayList<>();
		itemList.add(1L);
		assertEquals(new Order(1L, 1L, itemList), DAO.readLatest());
	}

	@Test
	public void testRead() {
		List<Long> itemList = new ArrayList<>();
		itemList.add(1L);
		final long ID = 1L;
		assertEquals(new Order(1L, 1L, itemList), DAO.readOrder(ID));
	}

	@Test
	public void testUpdate() {
		List<Long> itemList = new ArrayList<>();
		itemList.add(1L);
		itemList.add(1L);
		final Order updated = new Order(1L, 1L, itemList);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void testReadOrderItems() {
		List<Long> itemList = new ArrayList<>();
		itemList.add(1L);
		assertEquals(itemList, DAO.readOrderItems(1L));
	}
	
	@Test
	public void readOrderCostTest() {
		assertTrue(DAO.readOrderCost(1L) == 3.0);
	}
	
}
