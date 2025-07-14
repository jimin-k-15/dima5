-- 게시판 관련 테이블
-- 1) 사용자 테이블
USE dima5;

DROP TABLE IF EXISTS boarduser;
CREATE TABLE boarduser
(
	user_id   varchar(50),
	user_name varchar(50),
	user_pwd  varchar(100),
	email	  varchar(50),
	roles 	  varchar(20) DEFAULT 'ROLE_USER' CHECK (roles IN ('ROLE_USER', 'ROLE_ADMIN')),
	enabled   char(1) DEFAULT '1' CHECK (enabled IN ('1', '0')),   -- '1': enabled, '0': disabled
		CONSTRAINT boarduser_id_pk PRIMARY KEY(user_id) 
);

COMMIT;
SELECT * FROM boarduser;

-- 2) 게시판 테이블
DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS board;
CREATE TABLE board
(
	board_seq	      bigint AUTO_INCREMENT,
	board_writer      varchar(50) NOT NULL,
	board_title 		      varchar(200) DEFAULT 'untitled',
	board_content     varchar(3000),
	hit_count	      int DEFAULT 0,
	create_date       datetime DEFAULT CURRENT_TIMESTAMP, 
	update_date   	  datetime DEFAULT CURRENT_TIMESTAMP,
	original_filename varchar(100),	
	saved_filename    varchar(500),		
		CONSTRAINT board_seq PRIMARY KEY(board_seq)
);

COMMIT;
SELECT * FROM board;

-- 3) 댓글 테이블
CREATE TABLE reply
(
	reply_seq     int AUTO_INCREMENT,
	board_seq     bigint,
	reply_writer  varchar(50) NOT NULL,
	reply_content varchar(1000) NOT NULL,
	create_date   datetime DEFAULT CURRENT_TIMESTAMP,
		CONSTRAINT reply_seq PRIMARY KEY(reply_seq),
		CONSTRAINT reply_board_seq FOREIGN KEY(board_seq) 
		REFERENCES board(board_seq) ON DELETE CASCADE
);

COMMIT;
SELECT * FROM reply;