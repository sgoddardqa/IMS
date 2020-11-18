INSERT INTO ims.customers (first_name, surname) VALUES ('jordan', 'harrison');
INSERT INTO ims.orders (customer_id) VALUES (1);
INSERT INTO ims.items (name, cost) VALUES ('hat', 3.0);
INSERT INTO ims.orders_items (order_id, item_id) VALUES (1, 1);