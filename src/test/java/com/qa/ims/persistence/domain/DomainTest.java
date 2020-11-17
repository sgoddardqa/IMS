package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.qa.ims.utils.Utils;

public class DomainTest {
	
	@Mock
	private Utils utils;
	
	@Mock Logger LOGGER;
	
	@InjectMocks
	private Domain domain;
	
	@Test
	public void getDescriptionTest() {
		Utils utils = mock(Utils.class);
		when(utils.getString()).thenReturn("CUSTOMER");
		domain = Domain.getDomain(utils);
		assertTrue(domain.getDescription().equals("CUSTOMER: Information about customers"));
		verify(utils, times(1)).getString();
	}
	
	@Test
	public void getDomain1Test() {
		Utils utils = mock(Utils.class);
		when(utils.getString()).thenReturn("STOP");
		domain = Domain.getDomain(utils);
		assertTrue(domain instanceof Domain);
		verify(utils, times(1)).getString();
	}
	
	@Test
	public void getDomain2Test() {
		Utils utils = mock(Utils.class);
		when(utils.getString()).thenReturn("THE SPANISH INQUISITION", "STOP");
		domain = Domain.getDomain(utils);
		assertTrue(domain instanceof Domain);
		verify(utils, times(2)).getString();
	}

}
