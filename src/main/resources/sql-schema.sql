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