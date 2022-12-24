--liquibase formatted sql
--changeset techgeeknext:create-tables

CREATE TABLE address(
   id INT PRIMARY KEY,
   city VARCHAR(40)
);

CREATE TABLE student(
   id INT PRIMARY KEY,
   name VARCHAR(40),
   address_id INT,
   FOREIGN KEY(address_id) REFERENCES address(id) ON DELETE CASCADE
   );

CREATE TABLE subject(
id INT PRIMARY KEY,
name VARCHAR(40),
student_id INT,
FOREIGN KEY(student_id) REFERENCES student(id) ON DELETE CASCADE
)
