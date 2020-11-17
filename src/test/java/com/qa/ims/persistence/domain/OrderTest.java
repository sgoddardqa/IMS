package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrderTest {
	
	@Test
	public void constructor1Test() {
		Order order = new Order(1L, new ArrayList<>());
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void constructor2Test() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void getIdTest() {
		Order order = new Order(13L, 1L, new ArrayList<>());
		assertTrue(order.getId() == 13L);
	}
	
	@Test
	public void setIdTest() {
		Order order = new Order(1L, new ArrayList<>());
		order.setId(20L);
		assertTrue(order.getId() == 20L);
	}
	
	@Test
	public void getCustomerTest() {
		Order order = new Order(3L, new ArrayList<>());
		assertTrue(order.getCustomer() == 3L);
	}
	
	@Test
	public void setCustomerTest() {
		Order order = new Order(1L, new ArrayList<>());
		order.setCustomer(100L);
		assertTrue(order.getCustomer() == 100L);
	}
	
	@Test
	public void getItemsTest() {
		List<Long> items = new ArrayList<>();
		items.add(1L);
		items.add(2L);
		Order order = new Order(1L, items);
		assertTrue(order.getItems().equals(items));
	}
	
	@Test
	public void setItemsTest() {
		Order order = new Order(1L, new ArrayList<>());
		List<Long> items = new ArrayList<>();
		items.add(1L);
		items.add(2L);
		order.setItems(items);
		assertTrue(order.getItems().equals(items));
	}
	
	@Test
	public void toStringTest() {
		List<Long> items = new ArrayList<>();
		items.add(1L);
		items.add(2L);
		Order order = new Order(3L, 1L, items);
		assertTrue(order.toString().equals("id: 3, customer id: 1, item ids: [1, 2]"));
	}
	
	@Test
	public void equals1Test() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		assertTrue(order.equals(order));
	}
	
	@Test
	public void equals2Test() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equals3Test() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		String string = new String();
		assertFalse(order.equals(string));
	}
	
	@Test
	public void equals4Test() {
		Order order = new Order(1L, null, new ArrayList<>());
		Order order2 = new Order(1L, 1L, new ArrayList<>());
		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equals5Test() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		Order order2 = new Order(1L, 2L, new ArrayList<>());
		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equals6Test() {
		Order order = new Order(1L, new ArrayList<>());
		Order order2 = new Order(1L, 1L, new ArrayList<>());
		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equals7Test() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		Order order2 = new Order(4L, 1L, new ArrayList<>());
		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equals8Test() {
		Order order = new Order(1L, 1L, null);
		Order order2 = new Order(1L, 1L, new ArrayList<>());
		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equals9Test() {
		List<Long> items1 = new ArrayList<>();
		items1.add(1L);
		items1.add(2L);
		List<Long> items2 = new ArrayList<>();
		items2.add(3L);
		items2.add(4L);
		Order order = new Order(1L, 1L, items1);
		Order order2 = new Order(1L, 1L, items2);
		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equals10Test() {
		Order order = new Order(1L, 1L, new ArrayList<>());
		Order order2 = new Order(1L, 1L, new ArrayList<>());
		assertTrue(order.equals(order2));
	}
	
	@Test
	public void equals11Test() {
		Order order = new Order(null, null, null);
		Order order2 = new Order(null, null, null);
		assertTrue(order.equals(order2));
	}
	
}
