-- 2025년 7월 2일

USE dima5;
DROP TABLE IF EXISTS friend;
SELECT * FROM friend;

-- Friend 테이블 직접 생성
CREATE TABLE friend
(
	id  	 int PRIMARY KEY AUTO_INCREMENT,
	name 	 varchar(20) NOT NULL, 
	age 	 int DEFAULT 25, 
	birthday date,
	phone	 varchar(20),
	active	 char(1)
);

COMMIT;