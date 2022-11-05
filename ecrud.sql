create database employeemanagement;
use employeemanagement;
create table employee_table(employee_id int auto_increment primary key, name varchar(100), designation varchar(20),dob date,
salary int, Email varchar(150),password varchar(8),joining_date date , contact_no smallint, address text,
gender enum('m','f') , attendance int default(0),leave_count int,status varchar(10) default'non-active');
create table notice(rel_time date,notice text);
Create table complain(complain_id int auto_increment primary key, employee_id int ,complain_text text);
alter table employeemanagement.employee_table modify contact_no int;
alter table employeemanagement.employee_table modify status enum('non-active','active') default'non-active';
