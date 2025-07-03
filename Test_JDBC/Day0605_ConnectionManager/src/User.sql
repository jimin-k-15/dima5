/* Connection Manager를 통해서 DB에 접근하여 처리
   User를 관리하는 Database 
*/

USE jdbc;

-- 회원정보 테이블
CREATE TABLE userinfo
(
	id 	   varchar(20) PRIMARY KEY,								-- 회원 아이디
	name   varchar(20) NOT NULL,								-- 회원 이름
	gender char(1)     DEFAULT 'M' CHECK (gender IN ('M', 'F'))	-- 성별
);

-- 회원 주소 테이블
CREATE TABLE useraddr
(
	id      varchar(20)  REFERENCES userinfo(id) ON DELETE CASCADE, -- FK
	tel     varchar(20)  NOT NULL,				 				   -- 집 전화번호
	address varchar(100) NOT null
);

-- 샘플 데이터 삽입 (사용자)
INSERT INTO userinfo VALUES ('aaa', '홍길동', 'M');
INSERT INTO userinfo VALUES ('bbb', '임꺽정', 'M');
INSERT INTO userinfo VALUES ('ccc', '성춘향', 'F');

-- 샘플 데이터 삽입 (주소)
INSERT INTO useraddr VALUES ('aaa', '02-1234-5678', '서울시 강남구');
INSERT INTO useraddr VALUES ('bbb', '031-123-4567', '경기도 고양시');

COMMIT;
