DROP SCHEMA IF EXISTS ims;
CREATE SCHEMA IF NOT EXISTS ims;
USE ims;

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT(11) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40) NULL DEFAULT NULL,
    surname VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS items (
    item_id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NULL DEFAULT NULL,
    cost DECIMAL(10,2) NOT NULL DEFAULT 0,
    PRIMARY KEY (item_id)
);

CREATE TABLE IF NOT EXISTS orders (
    order_id INT(11) NOT NULL AUTO_INCREMENT,
    customer_id INT(11) NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE IF NOT EXISTS orders_items (
    orders_items_id INT(11) NOT NULL AUTO_INCREMENT,
    order_id INT(11) NOT NULL,
    item_id INT(11) NOT NULL,
    PRIMARY KEY (orders_items_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);