--liquibase formatted sql
--changeset techgeeknext:create-tables

insert into address(id,city) values(1,'Nagpur');
insert into student values (1,'Pratik', 1);
insert into subject values (1,'JAVA',1);
insert into subject values (2,'Spring Boot',1);
insert into subject values (3,'Junit',1);


insert into address(id,city) values(2,'UK');
insert into student values (2,'Gaurav', 2);
insert into subject values (4,'Angular',2);
insert into subject values (5,'CSS',2);
insert into subject values (6,'Javascript',2);


insert into address(id,city) values(3,'France');
insert into student values (3,'Rex', 3);
insert into subject values (7,'Git',3);
insert into subject values (8,'Jenkins',3);
insert into subject values (9,'Jira',3);