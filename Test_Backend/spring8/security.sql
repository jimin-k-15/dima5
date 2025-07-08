-- 2025년 7월 4일 (Spring Security)
USE dima5;

DROP TABLE IF EXISTS tbl_user;

CREATE TABLE tbl_user
(
	seq int   PRIMARY KEY AUTO_INCREMENT,
	user_id   varchar(255) UNIQUE,
	user_pwd  varchar(255) NOT NULL,
	user_name varchar(255) NOT NULL,
	role      varchar(255) DEFAULT 'ROLE_USER' 
		CHECK (role IN ('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGER'))
);

COMMIT;
SELECT * FROM tbl_user;