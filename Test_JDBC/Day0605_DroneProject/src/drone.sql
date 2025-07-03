-- Drone 프로젝트 테이블

USE jdbc;
DROP TABLE IF EXISTS drone;
CREATE TABLE IF NOT EXISTS drone
(
	serial_num int            PRIMARY KEY AUTO_INCREMENT,
	name       varchar(50)    NOT NULL,
	price      decimal(10, 0) DEFAULT 0 NOT NULL,
	wingcount  decimal(3, 0)  NOT NULL 
);