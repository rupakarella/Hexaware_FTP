-- SQL CASE STUDY
use hexaware;
-- creating employee table
create table employee(eID int, eName varchar(10), loc varchar(10), dept varchar(10), annSal int, yoj int, mgrID int) ;

-- inserting values
insert into employee values(1,'Anil','Hyd','IT',700000,2017,6);
insert into employee values(2,'Kavya','Mum','HR',500000,2016,1);
insert into employee values(3,'Arjun','Bnglr',NULL,450000,2016,2);
insert into employee values(4,'Rohit','Chennai','Sales',550000,2015,3);
insert into employee values(5,'Janvi','Pune','Sales',400000,2019,5);
insert into employee values(6,'Meera','Pune','IT',750000,2016,3);
insert into employee values(7,'Priya','Mum','IT',950000,2015,2);
insert into employee values(8,'Anjali','Hyd',NULL,600000,2015,4);
insert into employee values(9,'Praveen','Mum','IT',1200000,2017,2);
insert into employee values(10,'Surya','Chennai','HR',400000,2019,4);
insert into employee values(11,'Mohan','Bnglr','IT',700000,2018,1);
insert into employee values(12,'Mahesh','Pune','HR',650000,2016,6);
insert into employee values(13,'Priya','Mum','IT',950000,2015,2);
insert into employee values(14,'Ajay','Hyd','Mrkt',400000,2021,3);
insert into employee values(15,'Vamsi','Chennai','Mrkt',550000,2018,5);
insert into employee values(16,'Anand','Mum','Sales',400000,2022,4);
insert into employee values(17,'Rupa','Bnglr','IT',550000,2019,1);
insert into employee values(18,'Sri','Pune','Sales',350000,2023,6);
insert into employee values(19,'Surya','Chennai','HR',400000,2019,4);
insert into employee values(20,'Sai','Pune',NULL,1000000,2016,1);

-- display table
select * from employee;

-- display second highest salary 
select max(annSal) as 2ndHighSalary from employee where annSal<(select max(annSal) from employee);

-- find duplicate rows in table
select eName,annSal,loc,yoj,mgrID,dept,count(*) as count from employee group by eName,annSal,loc,yoj,mgrID,dept having count(*)> 1;

-- to fetch monthly Salary of Employee if annual salary is given
select *, annSal/12 as monSal from employee;

-- to fetch first record from Employee table
select * from employee limit 1;

-- to fetch last record from Employee table
select * from employee order by eID desc limit 1;

-- display first 5 Records from Employee table
select * from employee limit 5;

-- display Nth Record from Employee table(say n=12)
-- select * from employee limit 1 offset (n-1);
select * from employee limit 1 offset 11;

-- display 3 Highest salaries records from Employee table
select * from employee order by annSal desc limit 3;

-- Display Odd rows in the Employee table
select * from employee where eID%2!=0;

-- Display even rows in the Employee table
select * from employee where eID%2=0;

-- to fetch 3rd highest salary using Rank Function
select * from (select *,rank() over(order by annSal desc) as SalRank from employee) employee where SalRank=3 ;

-- create table with same structure of Employee table
create table newemployee like employee;
select * from newemployee;

-- Display first 50% records from Employee table
select * from employee where eid<=(select count(eid)/2 from employee);

-- Display last 50% records from Employee table
select * from employee where eid>(select count(eid)/2 from employee);

-- create a table with the same structure with data from the Employee table
create table newemployee1 as select * from employee;
select * from newemployee1;

create table manager(mgrID int,mName varchar(10));
insert into manager values(1, 'Akshay');
insert into manager values(2, 'Neha');
insert into manager values(3, 'Srija');
insert into manager values(5, 'Satya');
insert into manager values(6, 'vinod');
insert into manager values(9,'John');
insert into manager values(4,'Nitin');
insert into manager values(8,'Amelia');
select * from manager;

-- fetch only common records between 2 tables
select * from employee inner join manager on employee.mgrID = manager.mgrID;

-- get information of Employee where Employee is not assigned to the department
select * from employee where dept IS NULL;

-- display all records from Employee table whose name is ‘Anil and ‘Praveen’
select * from employee where ename='Anil' OR ename='Praveen';

-- display all records from Employee table whose name is not ‘Anil and ‘Praveen’
select * from employee where ename!='Anil' AND ename!='Praveen';

-- fetch all the records from Employee whose joining year is  2017
select * from employee where yoj=2017;

-- find maximum salary of each department
select  dept,max(annsal) from employee where dept is not null group by dept ;

-- find all Employees with its managers
select * from employee left outer join manager on employee.mgrid = manager.mgrid;

-- Display the name of employees who have joined in 2016 and salary is greater than 10000;
select * from employee where yoj=2016 having annsal/12>10000;

-- remove duplicate rows from table
create table manager_NoDup as select distinct * from manager;
select * from manager_NoDup;

-- find count of duplicate rows 
select mgrID,mname, count(*) from manager group by mgrID,mname having count(*)>1;

-- get distinct records from table
select mgrID,mname from manager group by mgrID,mname having count(*)=1;

-- How to display following using query?
-- *
-- **
-- ***
select repeat('*',1) as pattern
union
select repeat('*',2)
union
select repeat('*',3);

-- display 1 to 100 Numbers with query
with recursive series 
as(select 1 as number union all select number+1 from  series where number <100) 
select number from series;

-- email validation
WITH CustomersWithEmailValidation AS (
    SELECT
        customer_id,
        first_name,
        last_name,
        email,
        CASE
            WHEN email LIKE '%_@__%.__%' AND email NOT LIKE '%@%@%' THEN 'Valid'
            ELSE 'Invalid'
        END AS email_validation_status
    FROM
        Customers
)
SELECT * FROM CustomersWithEmailValidation;


-- display "databse" each char in a row
select 'd' as output
union
select 'a'
union all
select 't'
union all
select 'a'
union all
select 'b'
union all
select 'a'
union all
select 's'
union all
select 'e';


