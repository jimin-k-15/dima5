-- 2025년 5월 28일 (Insert, Create, Select)

/*

** 연산자
1) 비교 연산자 : <  >  <=  <=  =  != 
2) 논리 연산자 : and or not 
				 컬럼 BETWEEN A AND B 
				 컬럼 IN (값1, 값2...)  
3) NULL 연산자 : 컬럼 IS NULL, 컬럼 IS NOT NULL
4) LIKE 연산자 : % _ (문자열 내에 포함된 특별한 문자값을 찾아서 조회) 
   % : 0개 이상의 글자를 의미
   _ : _ 한 개당 글자 하나를 의미
   
5) 산술 연산자 : + - * / %
6) LIMIT : 조회된 결과의 일부만 재추출해서 조회할 때 사용

	LIMIT 개수 : 조회된 결과의 앞에서 n개만큼 조회
	LIMIT n1, n2 : n1개를 건너뛰고 n2개를 조회
*/

USE hr;

-- 1) 커미션을 받는 직원의 이름, 부서번호, 급여, 커미션 비율을 조회하시오.
SELECT first_name, department_id, salary, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

-- 2) 커미션을 받는 직원의 이름, 부서번호, 급여, 커미션 금액을 조회하시오.
SELECT 
	first_name, department_id, salary, 
	salary * commission_pct AS "커미션" -- 별칭
FROM employees
WHERE commission_pct IS NOT NULL;

-- 3) 위 코드에 계산 컬럼을 추가하시오. "총 수령액" = 커미션 + salary
SELECT
	first_name, department_id, salary,
	salary * commission_pct AS "커미션",
	salary + (salary * commission_pct) AS "총 수령액"
FROM employees
WHERE commission_pct IS NOT NULL;

-- 4) 위 코드에서 총 수령액이 15000 이상인 사람만 조회하시오.
SELECT
	first_name, department_id, salary,
	salary * commission_pct AS "커미션",
	salary + (salary * commission_pct) AS "총 수령액"
FROM employees
WHERE commission_pct IS NOT NULL 
AND salary + (salary * commission_pct) >= 15000;

-- 직원의 이름과 입사연도를 조회
SELECT first_name, hire_date
FROM employees;

-- 2007년 이전에 입사한 직원의 이름과 입사연도를 조회
-- 날짜 타입은 비교연산, Like 
SELECT first_name, hire_date
FROM employees
WHERE hire_date < '2007-01-01'
ORDER BY hire_date;

-- [연습] 1월에 입사한 직원의 이름, 입사일, 급여를 조회하시오.
SELECT first_name, hire_date, salary
FROM employees
WHERE hire_date LIKE '_____01%';

-- [연습] 2007년도에 입사한 직원의 이름, 입사일, 급여를 조회하시오.
SELECT first_name, hire_date, salary
FROM employees
WHERE hire_date LIKE '2007%';

/* LIMIT : 출력되는 레코드의 개수를 제한할 때 */
-- LIMIT는 ORDER BY보다 밑에 있어야 한다.

-- 조회된 전체 결과의 앞에서 10개만 출력
SELECT first_name, hire_date, salary
FROM employees
LIMIT 10;

-- 조회된 전체 결과의 앞에서 10개를 건너뛰고 5개만 출력
SELECT first_name, hire_date, salary
FROM employees
LIMIT 10, 5;

-- [연습] 직원의 이름, 입사일, 급여를 급여순으로 내림차순 후 상단 15개를 조회
SELECT first_name, hire_date, salary
FROM employees 
ORDER BY salary DESC
LIMIT 15; 

-- 10을 3으로 나눈 나머지값을 조회하시오. (FROM절이 없어도 가능)     
SELECT 10 % 3 FROM DUAL;	-- DUAL : 더미테이블 

-- -----------------------------------------------------
/* SQL 명령어의 종류
 *  1) DDL : create, alter, drop
 *  2) DML : select, update, delete, insert
 *  3) TQL : commit, rollback, savepoint
 *  4) DCL : grant, revoke 
 * 
 */

-- 테이블 생성하기 : CREATE
/* 
 * CREATE TABLE 테이블명
 * (
 * 		컬럼명 타입 [제약조건]		-- PK, FK, NN, CK, UQ, (default)
 * 		컬럼명 타입, 
 * 		컬럼명 타입
 * 
 * );
 */

CREATE DATABASE IF NOT EXISTS `dima5` DEFAULT CHARACTER SET UTF8MB3;
USE dima5;

SELECT DATABASE();

/*
데이터타입 : 
  1) 수치(정수, 실수) - decimal(10, 2), integer, float
  2) 문자열 (고정길이형, 가변길이형) : char(10), varchar(10)
  
   	 'Korea'  ---> char(10) --> 'Korea     '
   	 'Korea'  ---> varchar(10) --> 'Korea'
  3) 날짜타입 : date 
*/

DROP TABLE IF EXISTS mytable;
CREATE TABLE IF NOT EXISTS mytable
(
   id integer PRIMARY KEY,
   name varchar(20)
);

USE dima5;
SELECT DATABASE();
SELECT * FROM mytable;

INSERT INTO dima5.mytable 
(id, name)
VALUES
(1, '김홍도');

INSERT INTO dima5.mytable 
(id, name)
VALUES
(2, '신윤복');
   	  
-- 모든 컬럼의 데이터를 전부 넣을 때 values 앞 괄호를 생략 가능
INSERT INTO dima5.mytable 
VALUES
(3, '다빈치');

SELECT * FROM mytable;

-- 새로운 테이블
USE dima5;
SELECT DATABASE();
DROP TABLE IF EXISTS mytable2;
CREATE TABLE IF NOT EXISTS mytable2 -- 같은 이름의 테이블이 없을 경우에만 생성함. 중복 생성 방지
(
   id int PRIMARY KEY AUTO_INCREMENT,  -- id는 기본키이며, 자동으로 1씩 증가하는 정수
   name varchar(20) NOT NULL, -- 이름은 최대 20자이며, 반드시 입력되어야 함 (NULL 허용 X)
   phone varchar(20) UNIQUE, -- 전화번호는 최대 20자이며, 중복 불가 (동일한 값 2개 저장 불가)
   age int DEFAULT 20, -- 나이 값이 없을 경우 기본값 20이 자동으로 입력됨
   gender char(1) CHECK (gender IN ('M', 'F')) -- 성별은 문자 1글자만 가능하고, M 또는 F만 허용
); 

-- 데이터 삽입하기 
INSERT INTO mytable2
(name, phone, age, gender)
VALUES
('전우치', '1234', 29, 'M');

INSERT INTO mytable2
(name, phone, gender)
VALUES
('손오공', '1235', 'M');

SELECT * FROM mytable2;

-- -----------------------------------------------------
USE dima5;

SHOW DATABASES;
SHOW tables;
DESC mytable2; -- DESCRIBE mytable2; 해당 테이블의 구조(스키마) 확인

-- ----- 컬럼레벨의 제약조건과 테이블레벨의 제약조건
-- mytable3과 mytable5의 기능적인 차이는 없음.
-- 제약조건에 이름을 명시적으로 지정했는가 여부가 가장 큰 차이. 
-- 학습 단계에서는 mytable3처럼 써도 충분하지만, 실무에서는 mytable5처럼 이름을 지정하는 것이 권장됨.
-- 제약조건을 관리하고 유지보수할 필요가 있을 때 좋음 (이름 지정)
-- 제약조건 이름을 알아야 ALTER TABLE DROP CONSTRAINT 가능 

DROP TABLE IF EXISTS mytable3;
CREATE TABLE mytable3
(
   id int AUTO_INCREMENT, 
   name varchar(20) NOT NULL,	-- 주의** NN은 테이블레벨 제약조건을 줄 수 없다.
   phone varchar(20) UNIQUE,	-- 같은 번호가 두 번 들어갈 수 없음. 컬럼레벨 제약조건이지만, 아래에서 테이블레벨로도 다시 설정함 (중복).
   age int DEFAULT 20,  
   gender char(1) 				-- 아래에서 CHECK 제약조건으로 범위를 제한
   , PRIMARY KEY(id)			-- 여기서부터 테이블레벨 제약조건: id 컬럼을 기본키로 설정 + 중복 안 되고, NULL도 불가하며, 레코드를 구분하는 기준이 됨.
   , UNIQUE (phone) 			-- 위에서 했기 때문에 중복 (실행은 되지만 하나만 써도 됨).
   , CHECK (gender IN ('M', 'F'))
); 

-- 제약조건명 지정하기 (테이블명_컬럼명_제약조건)
DROP TABLE IF EXISTS mytable5;
CREATE TABLE mytable5
(
   id int AUTO_INCREMENT, 
   name varchar(20) NOT NULL,
   phone varchar(20) UNIQUE, 
   age int DEFAULT 20,
   gender char(1) 
   , CONSTRAINT mytable5_id_pk PRIMARY KEY(id)
   , CONSTRAINT mytable5_phone_uq UNIQUE (phone)
   , CONSTRAINT mytable5_gender_ck CHECK (gender IN ('M', 'F'))
); 

SELECT * FROM mytable5;

-- [연습] 제약조건은 테이블레벨로 만드시오. 제약조건명은 임의로 
/*
 * 피트니스 회원의 정보를 저장하는 테이블을 생성하시오.
 * 테이블명: fitness
 *  id : 자동증가, 정수
 *  name : 가변길이 문자열(20), 
 *  gender : 성별, 문자 1개 체크 '남', '여'
 *  height : 키 숫자형(5, 2), ck 150 ~ 200
 * 	weight : 몸무게 숫자형(5, 2) 
 *  std_weight : 표준체중 숫자형(5, 2)
 *  bmi : 숫자형(4, 2)
 *  bmi_result : 가변길이 문자열(30)
 * 
 */
USE dima5;

DROP TABLE IF EXISTS dima5.fitness;
CREATE TABLE dima5.fitness
(
	id int AUTO_INCREMENT
	, name varchar(20) NOT NULL
	, gender char(1)
	, height decimal(5, 2)
	, weight decimal(5, 2)
	, std_weight decimal(5, 2)
	, bmi decimal(4, 2)
	, bmi_result varchar(30)
		, CONSTRAINT fitness_id_pk PRIMARY KEY(id)
		, CONSTRAINT fitness_height_ck CHECK(height BETWEEN 150 AND 200)
); 

SHOW DATABASES;
USE information_schema;		-- 시스템 메타정보 데이터베이스 선택 (사용자가 만든 테이블, 컬럼, 제약조건, 인덱스, 사용자 정보 등)
SHOW tables;

SELECT * FROM table_constraints;	-- 테이블마다 설정된 제약조건 목록 확인

USE dima5;

-- dima5.fitness 테이블에 다음 회원의 정보를 입력하시오.
/*
 * 사오정, 남, 175.05, 65, bmi값을 계산해서 넣으시오.
 * 장원영, 여, 171, 45, bmi값을 계산해서 넣으시오.
 */
INSERT INTO dima5.fitness 
(name, gender, height, weight, bmi)
VALUES
('사오정', '남', 175.05, 65, weight/(height * height * 0.0001));

COMMIT;
SELECT * FROM dima5.fitness;

INSERT INTO dima5.fitness 
(name, gender, height, weight, bmi)
VALUES
('장원영', '여', 171, 45, weight/(height * height * 0.0001));

COMMIT;
SELECT * FROM dima5.fitness;

-- 날짜 데이터 다루기
USE dima5;
SELECT * FROM dima5.fitness;

DROP TABLE IF EXISTS mytable6;
CREATE TABLE IF NOT EXISTS mytable6
(
	userid int PRIMARY KEY AUTO_INCREMENT,			-- 고유 사용자 ID, 자동 증가, 기본키
	username varchar(20) NOT NULL,					-- 사용자 이름, 최대 20자, 필수 입력
	birthday date,									-- 생년월일, 연-월-일 형식 (YYYY-MM-DD)
	join_date datetime DEFAULT CURRENT_TIMESTAMP	-- 가입 일시, 기본값은 현재 시간 (CURRENT_TIMESTAMP)
);

INSERT INTO mytable6
(username, birthday)
VALUES
('삼장법사', '1980-01-01');

SELECT * FROM mytable6;

-- 3명의 정보를 더 넣으시오.
INSERT INTO mytable6
(username, birthday, join_date)
VALUES
('사오정', '1991-12-05', '2021-11-11');

INSERT INTO mytable6
(username, join_date)
VALUES
('저팔계', '2024-05-30');

INSERT INTO mytable6
(username, birthday)
VALUES
('손오공', '1998-11-11');

SELECT * FROM mytable6;

UPDATE mytable6
SET birthday = '2025-01-01'
WHERE userid = 3;

-- 삼장법사 삭제하기
DELETE FROM mytable6
WHERE userid = 1;

SELECT * FROM mytable6;

COMMIT;
ROLLBACK;

/* 둘 이상의 테이블 관계 설정하기
 * PK(부모), FK(자식)
 * 자바에서의 부모 / 자식 관계와는 다르다!
 * 
 * - 부모 테이블의 PK, UQ --> 자식 테이블에서 참조
 * - 생성은 부모 --> 자식 테이블을 생성
 * - 삭제는 자식 --> 부모 테이블을 삭제
 * - 부모 테이블의 특정 레코드를 삭제하면 자식에서 오류 발생
 *   ---> 자식 테이블을 생성할 때 on delete cascade를 설정한다.
 * 
 * - 부모 테이블의 특정 레코드의 PK를 수정하면 자식에서 오류 발생
 *   ---> 자식 테이블을 생성할 때 on update cascade를 설정한다. (오라클에는 없음)
 */

USE dima5;
-- 학생의 신상정보
CREATE TABLE parent1
(
	id int AUTO_INCREMENT 
	, name 	varchar(30) NOT NULL
	, phone varchar(20) UNIQUE
	, age 	decimal(3) DEFAULT 20
		, CONSTRAINT parent_id_pk PRIMARY KEY(id)  -- id 컬럼을 기본키(Primary Key)로 설정하고, 그 제약조건의 이름을 parent_id_pk로 지정
);

-- 학생의 학과정보
CREATE TABLE child1
(
	cid  int AUTO_INCREMENT
	, id int
	, major varchar(30) NOT NULL
	, grade decimal(2)
		, CONSTRAINT child1_cid_pk PRIMARY KEY (cid)  -- cid 컬럼을 기본키로 설정, 이 제약조건의 이름을 child1_cid_pk로 지정
		, CONSTRAINT child1_id_fk  FOREIGN KEY (id) REFERENCES parent1(id)  -- id 컬럼은 외래키로 설정, 이는 parent1 테이블의 id 컬럼을 참조, 제약조건 이름은 child1_id_fk로 지정
		ON DELETE CASCADE ON UPDATE CASCADE
);

-- 두 테이블 간의 참조 무결성 보장
-- 이 관계를 통해 child1.id에 들어가는 값은 반드시 parent1.id에 존재하는 값이어야 함.
-- 즉, 존재하지 않는 학생에 대한 학과정보는 저장할 수 없음. 

-- 데이터 삽입하기 (부모)
INSERT INTO parent1 (name, phone) VALUES ('이몽룡', '1234');
INSERT INTO parent1 (name, phone) VALUES ('성춘향', '1212');
INSERT INTO parent1 (name, phone) VALUES ('심청이', '0012');
INSERT INTO parent1 (name, phone) VALUES ('뺑덕이', '5544');

-- 자식 테이블에 데이터 삽입하기
SELECT * FROM parent1;
INSERT INTO child1 (id, major, grade) VALUES (1, '컴퓨터공학', 4);
INSERT INTO child1 (id, major, grade) VALUES (2, '한국학', 2);
INSERT INTO child1 (id, major, grade) VALUES (3, '영어영문학', 1);
INSERT INTO child1 (id, major, grade) VALUES (4, '응용미술', 4);

SELECT * FROM dima5.parent1;
SELECT * FROM child1;

COMMIT;

-- 1) 몽룡이의 id를 7번으로 수정하고 자식 테이블에서 수정되었는지 확인하시오.
UPDATE dima5.parent1
SET id = 7 WHERE id = 1;

-- 2) 뺑덕이 정보를 삭제하고 자식 테이블에서 삭제되었는지 확인하시오. 
DELETE FROM parent1
WHERE id = 4;

SELECT * FROM parent1;
SELECT * FROM child1;










