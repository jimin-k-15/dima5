-- -------- Fitness 데이터 처리 (JPA)
USE dima5;
DROP TABLE IF EXISTS fitness;

CREATE TABLE fitness
(
	id 		int PRIMARY KEY AUTO_INCREMENT,
	name	varchar(20) NOT NULL,
	gender  char(1) DEFAULT 'M',
	height  decimal(5, 2),
	weight  decimal(5, 2)
);

COMMIT;
SELECT * FROM fitness;