show databases;
create database HMBank;
use HMBank;

-- Task 2 create the tables with appropriate datatypes, constraints and relationships
-- Customers Table
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    DOB DATE,
    email VARCHAR(100),
    phone_number VARCHAR(15),
    address VARCHAR(255)
);

-- Accounts Table
CREATE TABLE Accounts (
    account_id INT PRIMARY KEY,
    customer_id INT,
    account_type VARCHAR(20),
    balance DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Transactions Table
CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY,
    account_id INT,
    transaction_type VARCHAR(20),
    amount DECIMAL(10, 2),
    transaction_date DATE,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
);

-- Task 3 1. Insert atleast 10 sample records into the tables created
-- Inserting 20 values in customers table
INSERT INTO Customers (customer_id, first_name, last_name, DOB, email, phone_number, address)
VALUES
    (1, 'John', 'Doe', '1990-05-15', 'john.doe@example.com', '123-456-7890', '123 Main St'),
    (2, 'Jane', 'Smith', '1985-08-22', 'jane.smith@example.com', '987-654-3210', '456 Oak Ave'),
    (3, 'Bob', 'Johnson', '1978-12-10', 'bob.johnson@example.com', '555-123-4567', '789 Pine Ln'),
    (4, 'Alice', 'Williams', '1992-03-18', 'alice.williams@example.com', '222-333-4444', '567 Elm St'),
    (5, 'Charlie', 'Brown', '1980-09-05', 'charlie.brown@example.com', '999-888-7777', '890 Maple Ave'),
    (6, 'Eva', 'Davis', '1995-11-30', 'eva.davis@example.com', '777-666-5555', '901 Cedar Ln'),
    (7, 'Frank', 'Miller', '1987-07-12', 'frank.miller@example.com', '444-555-6666', '345 Birch St'),
    (8, 'Grace', 'Taylor', '1983-01-25', 'grace.taylor@example.com', '666-777-8888', '678 Pine Ave'),
    (9, 'Harry', 'Smith', '1975-06-08', 'harry.smith@example.com', '111-222-3333', '234 Oak Ln'),
    (10, 'Ivy', 'Anderson', '1998-04-20', 'ivy.anderson@example.com', '333-444-5555', '789 Birch Ave'),
    (11, 'Jack', 'Martin', '1989-02-14', 'jack.martin@example.com', '777-888-9999', '567 Maple St'),
    (12, 'Katherine', 'Jones', '1970-10-28', 'katherine.jones@example.com', '222-333-4444', '901 Cedar Ave'),
    (13, 'Leo', 'Garcia', '1993-07-03', 'leo.garcia@example.com', '555-666-7777', '345 Pine Ln'),
    (14, 'Mia', 'Brown', '1982-04-15', 'mia.brown@example.com', '999-888-7777', '678 Elm Ave'),
    (15, 'Nathan', 'Anderson', '1973-09-22', 'nathan.anderson@example.com', '666-555-4444', '890 Cedar St'),
    (16, 'Olivia', 'Taylor', '1996-12-05', 'olivia.taylor@example.com', '444-333-2222', '123 Birch Ave'),
    (17, 'Paul', 'Miller', '1984-05-18', 'paul.miller@example.com', '111-222-3333', '456 Pine Ln'),
    (18, 'Quinn', 'Smith', '1977-08-11', 'quinn.smith@example.com', '888-999-0000', '789 Maple St'),
    (19, 'Rachel', 'Davis', '1991-02-28', 'rachel.davis@example.com', '222-111-0000', '901 Elm Ave'),
    (20, 'Samuel', 'Johnson', '1986-06-14', 'samuel.johnson@example.com', '777-666-5555', '345 Cedar Ln');
    
    select * from customers;
    
  

-- Insert 20 records into the accounts table
INSERT INTO accounts (account_id, customer_id, account_type, balance) VALUES
(1, 1, 'savings', 1500.00),
(2, 2, 'current', 500.00),
(3, 3, 'savings', 2000.00),
(4, 4, 'zero_balance', 0.00),
(5, 5, 'current', 1000.00),
(6, 6, 'savings', 2500.00),
(7, 7, 'savings', 1800.00),
(8, 8, 'current', 700.00),
(9, 9, 'zero_balance', 0.00),
(10, 10, 'savings', 3000.00),
(11, 11, 'current', 1200.00),
(12, 12, 'savings', 2200.00),
(13, 13, 'current', 800.00),
(14, 14, 'savings', 2700.00),
(15, 15, 'zero_balance', 0.00),
(16, 16, 'savings', 3200.00),
(17, 17, 'current', 1500.00),
(18, 18, 'savings', 2000.00),
(19, 19, 'current', 900.00),
(20, 20, 'savings', 3500.00);
select * from accounts;

-- Insert 20 records into the transactions table
INSERT INTO transactions (transaction_id, account_id, transaction_type, amount, transaction_date) VALUES
(1, 1, 'deposit', 500.00, '2023-01-01'),
(2, 2, 'withdrawal', 200.00, '2023-01-02'),
(3, 3, 'transfer', 1000.00, '2023-01-03'),
(4, 4, 'deposit', 300.00, '2023-01-04'),
(5, 5, 'withdrawal', 150.00, '2023-01-05'),
(6, 6, 'transfer', 700.00, '2023-01-06'),
(7, 7, 'deposit', 800.00, '2023-01-07'),
(8, 8, 'withdrawal', 400.00, '2023-01-08'),
(9, 9, 'transfer', 2000.00, '2023-01-09'),
(10, 10, 'deposit', 1000.00, '2023-01-10'),
(11, 11, 'withdrawal', 500.00, '2023-01-11'),
(12, 12, 'transfer', 1200.00, '2023-01-12'),
(13, 13, 'deposit', 600.00, '2023-01-13'),
(14, 14, 'withdrawal', 300.00, '2023-01-14'),
(15, 15, 'transfer', 1500.00, '2023-01-15'),
(16, 16, 'deposit', 2000.00, '2023-01-16'),
(17, 17, 'withdrawal', 700.00, '2023-01-17'),
(18, 18, 'transfer', 800.00, '2023-01-18'),
(19, 19, 'deposit', 1200.00, '2023-01-19'),
(20, 20, 'withdrawal', 500.00,'2023-01-20');
select * from transactions;

-- Task 4
-- 1. average account balance for all customers
SELECT  AVG(balance) AS average_balance FROM Accounts;

-- 2. retrieve the top 10 highest account balances
SELECT * FROM Accounts ORDER BY balance DESC LIMIT 10;

-- 3. calculate total deposits for all customers in specific date.
SELECT 
    c.customer_id,
    c.first_name,
    c.last_name,
    t.transaction_date,
    SUM(t.amount) AS total_deposits
FROM 
    Customers c
JOIN 
    Accounts a ON c.customer_id = a.customer_id
JOIN 
    Transactions t ON a.account_id = t.account_id
WHERE 
    t.transaction_type = 'deposit'
    AND t.transaction_date = '2023-01-10'
GROUP BY 
    c.customer_id, c.first_name, c.last_name;
    
-- 4. a)find oldest customer 
SELECT * FROM customers LIMIT 1;

-- 4. b)find newest customer
 SELECT * FROM customers ORDER BY customer_id DESC LIMIT 1;
   
-- 5. to Retrieve transaction details along with the account type
SELECT 
    t.transaction_id,
    t.account_id,
    t.transaction_type,
    t.amount,
    t.transaction_date,
    a.account_type
FROM 
    Transactions t
JOIN 
    Accounts a ON t.account_id = a.account_id;

-- 6. list of customers along with their account details.
SELECT
    c.customer_id,
    c.first_name,
    c.last_name,
    c.DOB,
    c.email,
    c.phone_number,
    c.address,
    a.account_id,
    a.account_type,
    a.balance
FROM
    Customers c
JOIN
    Accounts a ON c.customer_id = a.customer_id;

