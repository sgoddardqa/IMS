package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {
	
	@Test
	public void constructor1Test() {
		Item item = new Item("Hat", 10.0);
		assertTrue(item instanceof Item);
	}
	
	@Test
	public void constructor2Test() {
		Item item = new Item(1L, "Muffin", 2.0);
		assertTrue(item instanceof Item);
	}
	
	@Test
	public void getIdTest() {
		Item item = new Item(2L, "Fish", 40.0);
		assertTrue(item.getId() == 2L);
	}
	
	@Test
	public void setIdTest() {
		Item item = new Item("Microphone", 100.0);
		item.setId(5L);
		assertTrue(item.getId() == 5L);
	}
	
	@Test
	public void getNameTest() {
		Item item = new Item("English Literature Textbook", 0.05);
		assertTrue(item.getName().equals("English Literature Textbook"));
	}
	
	@Test
	public void setNameTest() {
		Item item = new Item("Unbranded chocolate bar", 1000000.0);
		item.setName("Freddo");
		assertTrue(item.getName().equals("Freddo"));
	}
	
	@Test
	public void getCostTest() {
		Item item = new Item("Poundland Milk", 1.0);
		assertTrue(item.getCost() == 1.0);
	}
	
	@Test
	public void setCostTest() {
		Item item = new Item("Incredible Furniture Discount", 1000.0);
		item.setCost(999.99);
		assertTrue(item.getCost() == 999.99);
	}
	
	@Test
	public void toStringTest() {
		Item item = new Item(10L, "Bee Movie", 0.99);
		assertTrue(item.toString().equals("id: 10, name: Bee Movie, cost: 0.99"));
	}
	
	@Test
	public void equals1Test() {
		Item item = new Item(1L, "Inception", 20.0);
		assertTrue(item.equals(item));
	}
	
	@Test
	public void equals2Test() {
		Item item = new Item(1L, "Unique Vase", 76000.0);
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equals3Test() {
		Item item = new Item(1L, "Ball of string", 0.5);
		String string = new String();
		assertFalse(item.equals(string));
	}
	
	@Test
	public void equals4Test() {
		Item item = new Item(1L, null, 0.0);
		Item item2 = new Item(1L, "Bottled air", 0.0);
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equals5Test() {
		Item item = new Item(1L, "Raven", 100.0);
		Item item2 = new Item(1L, "Writing Desk", 100.0);
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equals6Test() {
		Item item = new Item("Rabbit", 128.0);
		Item item2 = new Item(1L, "Rabbit", 128.0);
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equals7Test() {
		Item item = new Item(2L,"Rabbit", 256.0);
		Item item2 = new Item(4L, "Rabbit", 256.0);
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equals8Test() {
		Item item = new Item(8L, "Rabbit", null);
		Item item2 = new Item(8L, "Rabbit", 512.0);
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equals9Test() {
		Item item = new Item(16L, "Rabbit", 1024.0);
		Item item2 = new Item(16L, "Rabbit", 2056.0);
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equals10Test() {
		Item item = new Item(1L, "Sock", 1.0);
		Item item2 = new Item(1L, "Sock", 1.0);
		assertTrue(item.equals(item2));
	}
	
	@Test
	public void equals11Test() {
		Item item = new Item(null, null, null);
		Item item2 = new Item(null, null, null);
		assertTrue(item.equals(item2));
	}

}
