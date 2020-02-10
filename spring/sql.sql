select * from tab;
select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') from dual;


select EMPLOYEE_id, first_name from EMPLOYEES;

desc employees;
select * from member;

select * from employees where employee_id = 100;

select count(*) from employees;

create table member(
userid varchar2(30) primary key,
password varchar2(30),
name varchar2(50),
phone varchar2(30) 
);
insert into member values ('È£È£', '±ò±ò', 'È¯', '¤·¤·')
INSERT into member values ('spring', 'spring', 'È«±æµ¿', '010-2222-4567');
INSERT into member values ('mybatis', 'mybatis', '±è¼ö¿Á', '010-555-4567');
INSERT into member values('mvc', 'mvc', 'À¯Àç¹ü', '010-2222-5765');
commit;