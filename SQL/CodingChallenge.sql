create database OrderManagement;
use OrderManagement;

-- create products table
create table Products (
	product_Id int Primary Key,
    product_name varchar(255),
    pro_desc text,
    price double,
    quantityInStock int
);

-- insert 30 records into products table
insert into Products(product_Id, product_name, pro_desc, price, quantityInStock) values
    (1, 'Laptop', 'High-performance laptop', 120000.00, 10),
    (2, 'Smartphone', 'Latest smartphone model', 85000.00, 15),
    (3, 'Headphones', 'Noise-canceling headphones', 1500.00, 25),
    (4, 'Tablet', '10-inch Android tablet', 15000.00, 8),
    (5, 'Smartwatch', 'Fitness tracking smartwatch', 1800.00, 30),
    (6, 'Camera', 'Digital SLR camera', 10000.00, 12),
    (7, 'Television', '4K UHD Smart TV', 35000.00, 5),
    (8, 'Gaming Console', 'Next-gen gaming console', 5000.00, 20),
    (9, 'Wireless Earbuds', 'Bluetooth earbuds', 2500.00, 50),
    (10, 'Desktop Computer', 'Powerful desktop computer', 35000.00, 7),
    (11, 'Printer', 'Wireless color printer', 7000.00, 15),
    (12, 'External Hard Drive', '2TB USB 3.0 Hard Drive', 800.00, 25),
    (13, 'Home Theater System', '5.1 surround sound system', 30000.00, 10),
    (14, 'Fitness Tracker', 'Water-resistant fitness tracker', 7000.00, 40),
    (15, 'Coffee Maker', 'Programmable drip coffee maker', 4000.00, 30),
    (16, 'Portable Bluetooth Speaker', 'Wireless portable speaker', 6000.00, 20),
    (17, 'Robot Vacuum', 'Smart robotic vacuum cleaner', 2500.00, 12),
    (18, 'Wireless Router', 'Dual-band Wi-Fi router', 1000.00, 18),
    (19, 'Office Chair', 'Ergonomic office chair', 12000.00, 25),
    (20, 'LED Desk Lamp', 'Adjustable LED desk lamp', 2500.00, 50),
    (21, 'Smartphone', 'Latest smartphone model', 85000.00, 15),
    (22, 'Television', '4K UHD Smart TV', 35000.00, 5),
    (23, 'Gaming Console', 'Next-gen gaming console', 5000.00, 20),
    (24, 'Coffee Maker', 'Programmable drip coffee maker', 4000.00, 30),
    (25, 'Wireless Router', 'Dual-band Wi-Fi router', 1000.00, 18),
	(26, 'T-Shirt', 'Cotton short-sleeve shirt', 1500.00, 100),
    (27, 'Jeans', 'Classic blue denim jeans', 3000.00, 75),
    (28, 'Sweater', 'Warm wool sweater', 4000.00, 50),
    (29, 'Dress', 'Elegant evening dress', 8000.00, 30),
    (30, 'Sneakers', 'Casual sports shoes', 5000.00, 60);

-- update
update products set quantityInStock=40 where product_Id=24;

-- delete
delete from products where product_Id=31;

-- create electronics table
create table Electronics (
    product_Id int Primary Key,
    brand varchar(255),
    warrantyPeriod int,
    Foreign Key (product_Id) references Products(product_Id)
);

-- inserting records into electronics table
insert into Electronics (product_Id, brand, warrantyPeriod) values
    (1, 'Dell', 2),
    (2, 'Samsung', 1),
    (3, 'Sony', 2),
    (4, 'Apple', 1),
    (5, 'Fitbit', 2),
    (6, 'Canon', 3),
    (7, 'Sony', 2),
    (8, 'Microsoft', 1),
    (9, 'Bose', 2),
    (10, 'HP', 2),
    (11, 'LG', 1),
    (12, 'Nintendo', 2),
    (13, 'Panasonic', 2),
    (14, 'GoPro', 1),
    (15, 'JBL', 1),
    (16, 'Samsung', 1),
    (17, 'Sony', 2),
    (18, 'Microsoft', 1),
    (19, 'Bose', 2),
    (20, 'LG', 1),
    (21, 'LG', 1),
    (22, 'Nintendo', 2),
    (23, 'Panasonic', 2),
    (24, 'GoPro', 1),
    (25, 'JBL', 1);

-- update
update Electronics set warrantyPeriod=2 where product_Id=14;

-- delete
delete from Electronics where product_Id=21;
 
-- create clothing table
create table Clothing (
    product_Id int Primary Key,
    size varchar(50),
    color varchar(50),
    FOREIGN KEY (product_Id) references Products(product_Id)
);

-- insert records into clothing table
insert into Clothing (product_Id, size, color) values
	(26, 'M', 'Blue'),
	(27, 'L', 'Red'),
    (28, 'S', 'Black'),
    (29, 'M', 'Purple'),
    (30, 'S', 'Gray');
   
-- update
update Clothing set color='Blue' where product_Id=28;

-- delete
delete from Clothing where product_Id=31;

-- create user table
create table Users (
    userId int Primary Key,
    username varchar(50),
    pwd varchar(50),
    roles varchar(10)
);

-- inserting records into the Users table
insert into Users (userId, username, pwd, roles) values
    (1, 'Rupa', 'admin@1', 'Admin'),
    (2, 'Sai', 'user@1', 'User'),
    (3, 'Mohan', 'admin@2', 'Admin'),
    (4, 'Harry', 'user@2', 'User'),
    (5, 'Gayatri', 'admin@3', 'Admin'),
    (6, 'Harshitha', 'user@3', 'User'),
    (7, 'Mahesh', 'admin@4', 'Admin'),
    (8, 'Haasini', 'user@4', 'User'),
    (9, 'Nanditha', 'admin@5', 'Admin'),
    (10, 'Raji', 'user@5', 'User');
    
-- update
update Users set pwd='Rupa123$@' where userId=1;

-- delete
delete from Users where userId=11;
 
-- create orders table
create table Orders (
    orderId int primary key,
    userId int,
    product_Id int,
    orderDate date,
    orderStatus varchar(20),
    foreign key (userId) references Users(userId),
    foreign key (product_Id) references products(product_Id)
);

-- inserting records into orders table
insert into Orders (orderId, userId, product_Id, orderDate, orderStatus) values
    (1, 1, 22, '2023-01-01', 'Completed'),
    (2, 2, 14, '2023-01-02', 'Shipped'),
    (3, 3, 9, '2023-01-03', 'Pending'),
    (4, 4, 15, '2023-01-04', 'Completed'),
    (5, 5, 26, '2023-01-05', 'Shipped'),
    (6, 6, 12, '2023-01-06', 'Pending'),
    (7, 7, 6, '2023-01-07', 'Shipped'),
    (8, 8, 21, '2023-01-08', 'Pending'),
    (9, 9, 11, '2023-01-09', 'Completed'),
    (10, 10, 7, '2023-01-10', 'Pending'),
    (11, 1, 20, '2023-01-01','Completed' );
insert into orders values(12,2,16,'Pending');

-- update
update Orders set orderStatus='Cancelled' where orderId=12;

-- delete
delete from Orders where OrderId=12;

select * from Products;
select * from Electronics;
select * from Clothing;
select * from Users;
select * from Orders;

select * from products right join clothing on products.product_Id=clothing.product_Id;

