package com.qa.ims;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
public class IMSTest {
	
	@Mock
	private CustomerController crudController;
	
	@InjectMocks
	private IMS ims;
	
	@Test
	public void doAction1Test() {
		Mockito.when(crudController.create()).thenReturn(new Customer("Mary", "Poppins"));
		ims.doAction(crudController, Action.CREATE);
		Mockito.verify(crudController, Mockito.times(1)).create();
	}
	
	@Test
	public void doAction2Test() {
		Mockito.when(crudController.readAll()).thenReturn(new ArrayList<>());
		ims.doAction(crudController, Action.READ);
		Mockito.verify(crudController, Mockito.times(1)).readAll();
	}
	
	@Test
	public void doAction3Test() {
		Mockito.when(crudController.update()).thenReturn(new Customer("Joe", "Biden"));
		ims.doAction(crudController, Action.UPDATE);
		Mockito.verify(crudController, Mockito.times(1)).update();
	}
	
	@Test
	public void doAction4Test() {
		Mockito.when(crudController.delete()).thenReturn(1);
		ims.doAction(crudController, Action.DELETE);
		Mockito.verify(crudController, Mockito.times(1)).delete();
	}

}
