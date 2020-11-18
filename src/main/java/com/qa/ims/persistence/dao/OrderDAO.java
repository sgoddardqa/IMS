package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private DBUtils dbutils;
	
	public OrderDAO() {
		this.dbutils = DBUtils.getInstance();
	}
	
	public OrderDAO(DBUtils dbutils) {
		this.dbutils = dbutils;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("order_id");
		Long customer = resultSet.getLong("customer_id");
		List<Long> items = readOrderItems(resultSet.getLong("order_id"));
		return new Order(id, customer, items);
	}

	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = dbutils.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = dbutils.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order in the database
	 * 
	 * @param order - takes in an order object. id will be ignored
	 */
	@Override
	public Order create(Order order) {
		try (Connection connection = dbutils.getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders(customer_id) values('" + order.getCustomer() + "')");
			for (Long item : order.getItems()) {
				statement.executeUpdate("INSERT INTO orders_items(order_id, item_id) values('" + readLatest().getId()
						+ "', '" + item + "')");
			}
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order readOrder(Long id) {
		try (Connection connection = dbutils.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders WHERE order_id = " + id);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an order in the database
	 * 
	 * @param order - takes in an order object, the id field will be used to
	 *                 update that order in the database
	 * @return
	 */
	@Override
	public Order update(Order order) {
		try (Connection connection = dbutils.getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM orders_items WHERE order_id = " + order.getId());
			statement.executeUpdate("UPDATE orders SET customer_id = '" + order.getCustomer() + "' WHERE order_id =" + order.getId());
			for (Long item : order.getItems()) {
				statement.executeUpdate("INSERT INTO orders_items(order_id, item_id) values('" + order.getId()
						+ "', '" + item + "')");
			}
			return readOrder(order.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an order in the database
	 * 
	 * @param id - id of the order
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = dbutils.getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM orders_items WHERE order_id = " + id);
			return statement.executeUpdate("DELETE FROM orders WHERE order_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	// Get a list of item ids given an order id
	public List<Long> readOrderItems(Long orderId) {
		try (Connection connection = dbutils.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items WHERE order_id = " + orderId);) {
			List<Long> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(resultSet.getLong("item_id"));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	// Get the cost of an order from the order ID
	public Double readOrderCost(Long orderId) {
		Double cost = 0.0;
		try (Connection connection = dbutils.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT SUM(items.cost) AS total_cost FROM orders_items JOIN items "
						+ "ON orders_items.item_id = items.item_id WHERE orders_items.order_id = " + orderId);) {
			resultSet.next();
			cost = resultSet.getDouble("total_cost");
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return cost;
	}

}
