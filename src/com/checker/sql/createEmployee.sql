CREATE DATABASE IF NOT EXISTS  mybatis;

USE mybatis;

CREATE TABLE IF NOT EXISTS t_employee(
 id INT(11) NOT NULL AUTO_INCREMENT,
 empname VARCHAR(50) NOT NULL,
 gender INT(1),
 email VARCHAR(100),
 PRIMARY KEY(id)
)ENGINE=innodb DEFAULT CHARSET=utf8;