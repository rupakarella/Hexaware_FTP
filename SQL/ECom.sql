create database ECom;
use ECom;

-- create customer table
CREATE TABLE customers( 
	Customer_id INT PRIMARY KEY, 
    Customer_Name VARCHAR(30), 
    Email VARCHAR(40), 
    C_Password VARCHAR(20)
);

-- insert records into customers
INSERT INTO customers (Customer_id,Customer_Name,Email,C_Password) VALUES
	(1, 'Raji', 'raji852@gmail.com', 'Raji@123'),
    (2, 'Sai', 'saikatta@gmail.com', 'Sai184$'),
    (3, 'Mahesh', 'mahesh2k5@gmail.com', '##S2mk1l'),
    (4, 'Kusuma', 'kusuma198@gmail.com', 'kusumaK*'),
    (5, 'Srinivas', 'srinuk72@gmail.com', 's&S246*'),
    (6, 'Bobby', 'bobby808@gmail.com', 'Bobby12#'),
    (7, 'Ravi', 'ravi852@gmail.com', 'Ravi@123'),
    (8, 'Mohan', 'mohana343@gmail.com', 'Harry46%'),
    (9, 'Prasanna', 'prasanna70@gmail.com', 'Pk468@!'),
    (10, 'Krish', 'krish603@gmail.com', 'kri#@123');
    
-- create product table
-- Creating the Products table
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(255),
    price INT,
    pro_description TEXT,
    stockQuantity INT
);

-- Inserting records into the Products table
INSERT INTO Products (product_id, product_name, price, pro_description, stockQuantity)
VALUES
    (1, 'Laptop', 89999, 'Powerful laptop with high-performance specifications.', 20),
    (2, 'Smartphone', 29999, 'Feature-packed smartphone with a large display.', 50),
    (3, 'Running Shoes', 899, 'Comfortable running shoes with advanced cushioning.', 100),
    (4, 'Digital Camera', 49999, 'High-resolution digital camera for photography enthusiasts.', 15),
    (5, 'Office Chair', 4499, 'Ergonomic office chair for long hours of comfortable work.', 30);
    
-- Create cart table
CREATE TABLE cart (
    cart_id INT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- Insert into cart table
INSERT INTO cart (cart_id, customer_id, product_id, quantity)
VALUES
    (1, 1, 2, 2),
    (2, 2, 3, 1),
    (3, 3, 1, 3),
    (4, 4, 5, 2),
    (5, 5, 4, 1),
    (6, 6, 2, 2),
    (7, 7, 3, 1),
    (8, 8, 1, 3),
    (9, 9, 5, 2),
    (10,10, 4, 1);

-- Create orders table
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_price DECIMAL(10, 2),
    shipping_address VARCHAR(255),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Insert into orders table
INSERT INTO orders (order_id, customer_id, order_date, total_price, shipping_address)
VALUES
    (1, 1, '2022-11-01', 149998, '123 Main St, Cityville'),
    (2, 2, '2022-11-02', 26997, '456 Oak St, Townsville'),
    (3, 3, '2022-11-03', 20997, '789 Pine St, Villagetown'),
    (4, 4, '2022-11-04', 29998, '101 Elm St, Boroughburg'),
    (5, 5, '2022-11-05', 79998, '202 Maple St, Hamletsville'),
    (6, 6, '2022-11-06', 59999, '303 Cedar St, Villagetown'),
    (7, 7, '2022-11-07', 89998, '404 Oak St, Cityville'),
    (8, 8, '2022-11-08', 44999, '505 Elm St, Boroughburg'),
    (9, 9, '2022-11-09', 19999, '606 Pine St, Hamletsville'),
    (10, 10, '2022-11-10', 34999, '707 Maple St, Townsville');
    
-- Create order_items table
CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- Insert into order_items table
INSERT INTO order_items (order_item_id, order_id, product_id, quantity)
VALUES
    (1, 1, 2, 2),
    (2, 2, 3, 1),
    (3, 3, 1, 3),
    (4, 4, 5, 2),
    (5, 5, 4, 1),
    (6, 6, 3, 2),
    (7, 7, 1, 1),
    (8, 8, 4, 3),
    (9, 9, 2, 2),
    (10, 10, 5, 1);