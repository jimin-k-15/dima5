-- 1. 테이블 생성

-- 테이블 삭제
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS bbs;
DROP TABLE userinfo;

-- 1) 테이블명: userinfo - 사용자 정보
CREATE TABLE userinfo
(
	id 		 varchar(20) NOT NULL PRIMARY KEY, -- NOT NULL은 빼도 무방
	name     varchar(20) NOT NULL,
	password varchar(20) NOT NULL
);

-- 2) 테이블명: bbs - 게시글 정보
CREATE TABLE bbs
(
	bbs_num  int 		   PRIMARY KEY AUTO_INCREMENT,
	id       varchar(20)   NOT NULL,
	title    varchar(20),
	bbs_text varchar(2000) NOT NULL,
	regdate  datetime 	   DEFAULT CURRENT_TIMESTAMP 
);

-- 3) 테이블명: comment - 한 줄 댓글
CREATE TABLE comment
(
	comment_num  int 		  PRIMARY KEY AUTO_INCREMENT,
	bbs_num 	 int,
	id 			 varchar(20)  NOT NULL,
	comment_text varchar(200) NOT NULL,
	regdate 	 datetime 	  DEFAULT CURRENT_TIMESTAMP,
	-- 외래키 설정: bbs 테이블의 bbs_num을 참조하고, 게시글 삭제 시 자동 삭제
	-- FOREIGN KEY (bbs_num): 댓글 테이블의 bbs_num은 게시글 테이블의 bbs_num을 참조
	-- REFERENCES bbs(bbs_num): bbs 테이블의 기본키를 참조
	-- ON DELETE CASCADE: 게시글 삭제 시, 관련 댓글도 자동 삭제
	-- CONSTRAINT comment_bbs_fk: 외래키 제약조건 이름 (지정은 선택이지만 추천됨)
		CONSTRAINT comment_bbs_fk FOREIGN KEY (bbs_num) REFERENCES bbs (bbs_num) 
		ON DELETE CASCADE 
);


-- 2. 테스트 데이터 입력

INSERT INTO userinfo VALUES ('AAA', '홍길동', '1234'); 
INSERT INTO userinfo VALUES ('BBB', '박찬호', '5678'); 
SELECT * FROM userinfo;

INSERT INTO bbs (ID, TITLE, bbs_text) VALUES ('AAA', '글제목1', '글내용11'); 
INSERT INTO bbs (ID, TITLE, bbs_text) VALUES ('AAA', '글제목2', '글내용22'); 
INSERT INTO bbs (ID, TITLE, bbs_text) VALUES ('BBB', '글제목3', '글내용33'); 
SELECT * FROM bbs;

INSERT INTO comment (bbs_num, ID, comment_text) VALUES (1, 'AAA', '리플내용'); 
INSERT INTO comment (bbs_num, ID, comment_text) VALUES (1, 'BBB', '리플내용'); 
INSERT INTO comment (bbs_num, ID, comment_text) VALUES (1, 'BBB', '리플내용'); 
INSERT INTO comment (bbs_num, ID, comment_text) VALUES (2, 'AAA', '리플내용'); 
INSERT INTO comment (bbs_num, ID, comment_text) VALUES (2, 'BBB', '리플내용');
SELECT * FROM comment;

COMMIT;

-- 1) 게시판의 글번호와 작성자의 ID, 이름 그리고 글제목을 다음과 같이 출력하시오.  
--    (JOIN과 SUBQUERY 2가지 방법으로) 

-- Subquery 
SELECT 
	bbs_num 글번호, 
	concat(id, ' (', (SELECT name FROM userinfo WHERE bbs.id = userinfo.id), ')') 작성자,
	title 제목
FROM bbs;

-- Join (PK, FK 관계는 아니지만 같은 값을 갖는 컬럼이 있으므로 JOIN 가능)
SELECT bbs_num 글번호,
	concat(b.id, ' (', u.name, ')') 작성자, title 제목
FROM userinfo u, bbs b WHERE u.id = b.id;
	

-- 2) 1번 글에 달린 리플 목록을 다음과 같이 출력하시오. 
SELECT r.bbs_num, r.id, name, comment_text
FROM comment r, userinfo u
WHERE r.id = u.id AND r.bbs_num = 1;


-- 3) 모든 글과 모든 리플 정보를 다음과 같은 형식으로 출력한다. 
SELECT b.bbs_num 본문글번호, u.name 본문작성자, r.comment_num 리플번호, u2.name 리플작성자
FROM userinfo u, userinfo u2, bbs b, comment r
WHERE b.bbs_num = r.bbs_num AND u.id = b.id AND u2.id = r.id
ORDER BY b.bbs_num, r.comment_num;


-- 4) 각 본문 글에 달린 리플의 개수를 다음과 같이 출력하시오.
SELECT b.bbs_num 본문글번호, count(*) 리플개수
FROM bbs b, comment r
WHERE b.bbs_num = r.bbs_num
GROUP BY b.bbs_num;


