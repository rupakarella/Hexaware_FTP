show databases;
create database Hexaware;
show databases;
use hexaware;
show tables;

create table emp(eid int, ename varchar(10));
select *from emp;
insert into emp values("343", 'Mohan');
alter table emp add sal int;
alter table emp add loc varchar(10);
update emp set sal=25000;
update emp set loc='Hyd';
insert into emp values("570", 'Rupa', 20000, 'chennai');
insert into emp values("579", 'Ali', 16500, 'Hyd');
insert into emp values("242", 'Hari', 30000, 'Bnglr');
insert into emp values("520", 'Seetha', 12000, 'Mumbai');
insert into emp values("464", 'Surya', 17000, 'Hyd');
insert into emp values("603", 'Ram', 22500, 'Bnglr');
insert into emp values("782", 'Ali', 16500, 'Hyd');
insert into emp values("254", 'Prem', 20000, 'chennai');
insert into emp values("806", 'Siva', 22500, 'Bnglr');
insert into emp values("420", 'Richa', 22000, 'Hyd');
insert into emp values("560", 'Satya', 21000, 'Mum');
insert into emp values("362", 'Janvi', 20000, 'chennai');
insert into emp values("222", 'Sunny', 195000, 'Bnglr');
insert into emp values("555", 'Mridul', 24000, 'Hyd');
insert into emp values("389", 'Rohit', 15000, 'Mum');
insert into emp values("108", 'Suresh', 20000, 'chennai');
insert into emp values("165", 'Janvi', 20000, 'Mum');
insert into emp values("199", 'Ali', 19500, 'Hyd');
insert into emp values("999", 'Ritu', 25000, 'Bnglr');
update emp set ename='Rupa' where eid=254;

select *from emp;

select *from emp order by loc;

select count(eid), sal from emp group by sal ;

select count(eid), loc from emp group by loc ;

select count(eid), loc, ename from emp group by loc, ename ;

select count(eid), loc, ename, sal from emp group by loc, ename, sal ;

select min(sal) from emp where sal>(select min(sal) from emp);

select * from emp where loc='Hyd' having sal<20000;

select loc,max(sal) from emp group by loc;

select loc,sum(sal) from emp group by loc;

-- Day 2
alter table emp add dept varchar(10);

update emp set dept='Sales' where eid=782;

select dept,sum(sal) from emp group by dept;

select dept,loc,max(sal) from emp group by dept, loc order by dept;

select eid,ename,sal from emp order by sal;

select * from emp where sal=(select max(sal) from emp where sal<(select max(sal) from emp));

create table customer(cid int primary key, cname varchar(10));
insert into customer values(123,'ram');
insert into customer values(234,'sita');
insert into customer values(345,'Lucky');
select *from customer;



create table e(eid int, ename varchar(10), loc varchar(10));
insert into e values(1,'Abhi','Hyd');
insert into e values(2,'Ajay','Bnglr');
insert into e values(3,'Sita','Mum');
insert into e values(4,'Anvi','Pune');
insert into e values(5,'Raji','Pune');
insert into e values(6,'Janvi','Mum');
insert into e values(7,'Surya','Hyd');
insert into e values(8,'Mohan','Bnglr');
insert into e values(9,'Mridul','Chennai');
insert into e values(10,'Ritu','Hyd');
select * from e;



create table d(did int, dname varchar(10), sal int);
insert into d values(3,'sales',15000);
insert into d values(4,'HR',17000);
insert into d values(6,'IT',25000);
insert into d values(11,'marketing',17500);
select * from d;


select * from e inner join d on e.eid = d.did;

select * from e inner join d on e.eid!=d.did;

select * from e left outer join d on e.eid = d.did;

select * from e right outer join d on e.eid = d.did;

select * from e full join d on e.eid = d.did;

select * from e cross join d;



