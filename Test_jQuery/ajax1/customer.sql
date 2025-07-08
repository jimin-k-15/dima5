-- --------- ajax로 저장하는 customer table
USE dima5;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
	seg int PRIMARY KEY AUTO_INCREMENT,
	name     varchar(20) NOT NULL, 
	phone    varchar(20) NOT NULL,
	gender   varchar(20) CHECK (gender IN ('남성', '여성')),
	location varchar(255) 
);

COMMIT;
SELECT * FROM customer;