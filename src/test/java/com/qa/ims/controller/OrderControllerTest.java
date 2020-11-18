package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long CUSTOMER = 1L;
		final List<Long> ITEMS = new ArrayList<>();
		final Order created = new Order(CUSTOMER, ITEMS);

		Mockito.when(utils.getLong()).thenReturn(CUSTOMER);
		Mockito.when(utils.getLongList()).thenReturn(ITEMS);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getLongList();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, new ArrayList<>()));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		List<Long> itemsOriginal = new ArrayList<>();
		List<Long> itemsUpdated = new ArrayList<>();
		List<Long> itemsAdd = new ArrayList<>();
		List<Long> itemsRemove = new ArrayList<>();
		
		itemsOriginal.add(1L);
		itemsUpdated.add(2L);
		itemsAdd.add(2L);
		itemsRemove.add(1L);
		
		Order original = new Order(1L, 1L, itemsOriginal);
		Order updated = new Order(1L, 1L, itemsUpdated);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLongList()).thenReturn(itemsRemove, itemsAdd);
		Mockito.when(this.dao.readOrder(1L)).thenReturn(original);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getLongList();
		Mockito.verify(this.dao, Mockito.times(1)).readOrder(1L);
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}