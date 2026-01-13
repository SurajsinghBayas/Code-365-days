
-- Winddow Function  in MYSQL
-- Window function perform calculations across a set of rows that are related to the curren row , without collapsing the result set like aggregate functions.
-- Syntax:
-- function_name (expression) OVER (
--     [PARTITION BY partition_expression]
--     [ORDER BY sort_expression]
--     [frame_clause]   
-- They give results similar to aggregate functions but do not group the result set into a single output row.
-- Instead, they return a single value for each row based on the calculations performed over a specified window of rows.
create database org
use org
create table department (dept_id INT primary key ,dept_name VARCHAR(20) );
insert into department  VALUES
(201,"HR"),
(202,"Finance"),
(203,"Operation"),
(204,"Sales"),
(205,"IT");
select * from department;

CREATE TABLE project (
    pro_id INT PRIMARY KEY,
    pro_name VARCHAR(30),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

INSERT INTO project (pro_id, pro_name, dept_id)
VALUES
(301, 'Hiring', 201),
(302, 'Event', 201),
(303, 'Audit', 202),
(304, 'Urban', 203),
(305, 'Rural', 203),
(306, 'Social Media', 204),
(307, 'Advertisement', 204),
(308, 'Front End', 205),
(309, 'Backend', 205),
(310, 'Data Science', 205);
select * from project;

create table employee (
employee_id INT Primary key,
employee_name VARCHAR(20),
manager_id varchar(20),
dept_id INT);

INSERT INTO employee (employee_id, employee_name, manager_id, dept_id)
VALUES
(401, 'AAA', 501, 201),
(402, 'BBB', 502, 201),
(403, 'CCC', 504, 201),
(404, 'DDD', 501, 202),
(405, 'EEE', 503, 202),
(406, 'FFF', 504, 202),
(407, 'GGG', 505, 202),
(408, 'HHH', 501, 203),
(409, 'III', 502, 203),
(410, 'JJJ', 501, 203),
(411, 'KKK', 506, 203),
(412, 'LLL', 506, 203),
(413, 'MMM', 501, 204),
(414, 'NNN', 503, 204),
(415, 'OOO', 504, 204),
(416, 'PPP', 505, 204),
(417, 'QQQ', 501, 205),
(418, 'RRR', 506, 205),
(419, 'SSS', 502, 205),
(420, 'TTT', 505, 205);

select * from employee;

CREATE TABLE nkocet_employee (
emp_id INT,
emp_name varchar(50),
department varchar(50),
salary INT, 
join_date DATE
);

insert into nkocet_employee
values
(1,"AAA","IT",50000,'2021-01-10'),
(2,"BBB","IT",60000,'2020-03-15'),
(3,"CCC","IT",60000,'2022-07-01'),
(4,"DDD","HR",40000,'2019-05-21'),
(5,"EEE","HR",45000,'2021-11-11');

insert into nkocet_employee
values
(6,"FFF","HR",45000,'2020-02-18'),
(7,"GGG","Sales",55000,'2021-08-08'),
(8,"HHH","Sales",50000,'2022-04-04'),
(9,"III","Sales",60000,'2020-12-12'),
(10,"JJJ","Sales",60000,'2019-06-06'),
(11,"KKK","Finance",65000,'2018-09-09'),
(12,"LLL","Finance",62000,'2021-10-10'),
(13,"MMM","Finance",62000,'2022-02-02'),
(14,"NNN","IT",52000,'2023-01-01'),
(15,"OOO","HR",48000,'2022-09-09');

select * from nkocet_employee;
-- row function 
-- Basic 
-- Q1) Assign the row Number by salary (Highest first)
-- Solution : 

select emp_name, salary, 
row_number() over (order by salary desc) as rn
from nkocet_employee;



-- CREATE TABLE nkocet_employee (
-- emp_id INT,
-- emp_name varchar(50),
-- department varchar(50),
-- salary INT, 
-- join_date DATE
-- );

-- Q2) Roll no within each department
-- Solution :

select emp_name, department, 
row_number() over (partition by department  order by emp_id) as rown
from nkocet_employee;

-- Q3) Show Joining order of employyes
-- Solution : 

select emp_name, join_date,
row_number() over (order by join_date) as jd
from nkocet_employee;

-- Q4) Get latest Joined employee in each department 
-- Soulution :

select * from 
(select *, row_number() over(
  partition by department  order by join_date) as rn
  from nkocet_employee
) x where rn=1;


-- Q5) GEt top 2 emplyees  by salary per Department.
-- Solution :
select * from (
select *,row_number() over (partition by department 
order by salary desc ) as rn from nkocet_employee) x where rn<=2;

-- Q6) remove duplicate salaries inside department 
-- Solution :
select * from (
select *, row_number() over(
partition by department,salary order by salary desc) as rn
from nkocet_employee
) x where rn=1;

-- Q7) Find the 1st hired employee per deaprtment.
-- Solution :
select * from (
select *, row_number() over( partition by department order by join_date ) as rn
from nkocet_employee
) 
x where rn=1;

-- Q8) Get third highest salary in each department
-- Solution :
select * from (
select *, row_number() over( partition by department order by salary desc ) as rn
from nkocet_employee
) 
x where rn=3;

-- Q9) identify employees who joined after the second joiner date
-- Solution :
select * from (
select *, row_number() over( partition by department order by join_date ) as rn
from nkocet_employee
) 
x where rn>2;

-- rank Based function Question
-- Q1) rank employees by salary
-- Solution :
select emp_name , salary , rank() over (order by salary desc) as rnk
from nkocet_employee;

-- Q2) Department wise rank employees by salary
-- Solution :
select emp_name , department , salary , rank() over (partition by department order by salary desc) as rnk
from nkocet_employee;

-- Q3) rank employees by joining date
-- Solution :

select *, rank() over (order by join_date) as rnk from nkocet_employee;

-- rank QUESTION
-- Q4) find the highest paid employee (including duplicates)
-- Solution :
SELECT * FROM(
SELECT *, RANK() OVER(ORDER by salary desc)
as rnk from nkocet_employee ) x  where rnk=1;

-- Q5) top three salary per department (including duplicates)
-- Solution :
Select * from(
Select *, rank() over(
partition by department order by salary desc) as rnk 
from nkocet_employee )x where rnk<=3;

-- Q6) end highest salary in each department
-- Solution :
select * from (
select *, rank() over(partition by department order by salary desc) as rnk
from nkocet_employee) x where rnk=2 ;

-- Q7) departments where multiple employees share highest salary
-- Solution :
select department, count(*) t  from (
select *, rank() over( partition by department order by salary desc  ) as rnk
from nkocet_employee) x where rnk=1 group by department having count(*)>1 ;

-- Q8) find employee is earning more than department average
-- Solution :
select * from (
select *, avg(salary) over (partition by department ) as avg_sal
from nkocet_employee) x where salary > avg_sal;

-- Q9) rank department by total salary
-- Solution :
select department,sum(salary) total_sal , rank() 
over (order by sum(salary) desc) as ts
from nkocet_employee
group by department ;
