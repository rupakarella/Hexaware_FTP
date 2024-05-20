use hexaware;

create table employees(first_name varchar(10), last_name varchar(10), age int, dept varchar(5));
insert into employees values('Mesa', 'Loop', 30, 'Acct');
insert into employees values('Smith', 'Oak', 27, 'Devl');
insert into employees values('John', 'Jorz', 37, 'QA');
insert into employees values('Hary', 'Gaga', 32, 'QA');
select * from employees;

-- 1. name of employee whose age>30 
select concat(first_name, ' ', last_name) as Name from employees where age>30;

-- 2. get user, current date and mysql version
select current_user() as CurrentUser, current_date() as CurrentDate, version() as SQLVersion;

-- 3. get an item id, item, price of the most expensive item
create table items(item_id int, item varchar(10), price int);
insert into items values(1, 'Laptop', 65000);
insert into items values(2, 'Camera', 55000);
insert into items values(3, 'Earphones', 3000);
insert into items values(4, 'SmartWatch', 6000);
insert into items values(5, 'Mobile', 92000);
insert into items values(6, 'SmartTV', 125000);
select * from items;

-- 4. create a new user and set a password and privileges for an existing database
create user 'rupa'@'localhost' identified by 'Rupa@123';
grant all privileges on hexaware to rupa@localhost;
show grants for rupa@localhost;

-- 5. select data of only CS and IT departments
create table students(id int, name varchar(15), department varchar(5),age int);
insert into students values(1,'Maria Gloria','CS',22);
insert into students values(2, 'John Smith', 'IT', 23);
insert into students values(3, 'Gal Rao', 'CS', 22);
insert into students values(4, 'Jakey Smith', 'EC', 24);
insert into students values(5, 'Rama Saho', 'IT', 22);
insert into students values(6, 'Maria Gaga', 'EC', 23);
select * from students where department='CS' or department='IT';

-- 6. select data of all departments in descending order by age.
select * from students order by age desc;

-- 7. to determine the age of each of the students
create table students1(id int, name varchar(15), department varchar(5),birth varchar(10));
insert into students1 values(1,'Maria Gloria','CS','1994-03-12');
insert into students1 values(2, 'John Smith', 'IT', '1993-02-07');
insert into students1 values(3, 'Gal Rao', 'CS', '1992-09-11');
insert into students1 values(4, 'Jakey Smith', 'EC', '1990-08-31');
insert into students1 values(5, 'Rama Saho', 'IT', '1994-12-09');
insert into students1 values(6, 'Maria Gaga', 'EC', '1993-10-09');
select *, year(current_date())-year(birth) as age from students1;

-- 8. statement to retrieve name beginning with 'm'.
select * from students1 where name like 'm%';

create table students2(id int, name varchar(15), deptid int,birth varchar(10));
insert into students2 values(1,'Maria Gloria','2','1994-03-12');
insert into students2 values(2, 'John Smith', '1', '1993-02-07');
insert into students2 values(3, 'Gal Rao', '4', '1992-09-11');
insert into students2 values(4, 'Jakey Smith', '2', '1990-08-31');
insert into students2 values(5, 'Rama Saho', '1', '1994-12-09');
insert into students2 values(6, 'Maria Gaga', '4', '1993-10-09');

create table department(deptid int, deptName varchar(25), deptBlock varchar(10));
insert into department values(1,'Computer Science','B-Block');
insert into department values(2,'Information Technology','C-Block');
insert into department values(3,'Mechanical','A-Block');
insert into department values(4,'Electronic Communication','D-Block');

-- 9. to find the name, birth, department name, department block from the given tables. 
select students2.name, students2.birth, department.deptName, department.deptBlock 
from students2 left join department on students2.deptid=department.deptid;

drop table student;
-- 10. to get the names of students containing exactly four characters
create table student(id int, name varchar(15), deptid int,birth varchar(10));
insert into student values(1,'Maria','2','1994-03-12');
insert into student values(2, 'John', '1', '1993-02-07');
insert into student values(3, 'Gal', '4', '1992-09-11');
insert into student values(4, 'Jakey', '2', '1990-08-31');
insert into student values(5, 'Rama', '1', '1994-12-09');
insert into student values(6, 'Maria', '4', '1993-10-09');
select name from student where char_length(name)=4;

drop table book;
-- 11. to delete duplicate row from the table
create table book(bookName varchar(25), price int);
insert into book values('Your Name',196);
insert into book values('Life Switch',82);
insert into book values('It ends with us',139);
insert into book values('Who moved my cheese',120);
insert into book values('Your Name',196);
insert into book values('It ends with us',139);
select * from book;
delete b1 from book b1 
join(
  select bookName, price from book group by bookName, price having count(*) > 1
) b2
on b1.bookName = b2.bookName and b1.price = b2.price;

-- 12. display alternate records
select * from student where id%2=0;

-- 13. delete alternate rows
delete from student where id%2=0;

-- 14. update multiple rows in one query
update emp set sal=18000 where dept='Sales';
select * from emp where dept='Sales';

-- 15. a) nth highest paid salary
-- select * from employee order by annSal desc limit 1 Offset n-1;
select * from employee order by annSal desc limit 1 Offset 5; -- say n=6

-- 15. b) to get nth least paid
-- select * from employee order by annSal  limit 1 Offset n-1;
select * from employee order by annSal  limit 1 Offset 4; -- say n=5

