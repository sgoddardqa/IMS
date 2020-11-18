package com.qa.ims.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.qa.ims.utils.Utils;

public class ActionTest {
	
	private Logger LOGGER;
	
	private Action action;
	
	@Test
	public void getDescriptionTest() {
		Utils utils = mock(Utils.class);
		when(utils.getString()).thenReturn("CREATE");
		action = Action.getAction(utils);
		assertTrue(action.getDescription().equals("CREATE: To save a new entity into the database"));
		verify(utils, times(1)).getString();
	}
	
	@Test
	public void getAction1Test() {
		Utils utils = mock(Utils.class);
		when(utils.getString()).thenReturn("RETURN");
		action = Action.getAction(utils);
		assertTrue(action instanceof Action);
		verify(utils, times(1)).getString();
	}
	
	@Test
	public void getAction2Test() {
		Utils utils = mock(Utils.class);
		when(utils.getString()).thenReturn("THE SPANISH INQUISITION", "RETURN");
		action = Action.getAction(utils);
		assertTrue(action instanceof Action);
		verify(utils, times(2)).getString();
	}

}
