package com.qa.ims.persistence.domain;

import java.util.List;

public class Order {

	private Long id;
	private Long customer;
	private List<Long> items;

	public Order(Long customer, List<Long> items) {
		this.customer = customer;
		this.items = items;
	}

	public Order(Long id, Long customer, List<Long> items) {
		this.id = id;
		this.customer = customer;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}

	public List<Long> getItems() {
		return items;
	}

	public void setItems(List<Long> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "id: " + id + ", customer id: " + customer + ", item ids: " + items;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}
