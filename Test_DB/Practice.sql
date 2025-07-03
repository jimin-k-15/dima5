USE hr;

SELECT * FROM hr.employees e;
SELECT first_name FROM employees;
SELECT last_name FROM employees;
SELECT first_name, last_name, salary
FROM employees;

SELECT department_id FROM employees;
SELECT DISTINCT first_name, department_id FROM employees;
SELECT DISTINCT first_name, department_id FROM employees
ORDER BY first_name;
SELECT DISTINCT first_name, department_id FROM employees
ORDER BY first_name DESC ;

-- [연습]
SELECT first_name, salary, department_id 
FROM employees
ORDER BY salary DESC;

--------------------------------------------------------------------------

USE hr;
SHOW DATABASES;
SHOW tables;

SELECT * FROM hr.regions;
SELECT * FROM countries;
SELECT * FROM locations;
SELECT * FROM departments;
SELECT * FROM jobs;
SELECT * FROM employees;
SELECT * FROM job_history;

SELECT * FROM employees;
SELECT first_name, salary FROM employees;
SELECT department_id FROM employees;
SELECT DISTINCT department_id FROM employees;

SELECT first_name, salary, department_id FROM employees;
SELECT first_name, salary, department_id FROM employees ORDER BY salary DESC;
SELECT first_name, salary, department_id FROM employees ORDER BY first_name ASC;
SELECT first_name, hire_date, job_id FROM employees ORDER BY hire_date ;

SHOW DATABASES;
SHOW tables;

USE world;
SHOW tables;

USE sakila;
SHOW tables;

USE hr;

-- [연습]
SELECT * FROM employees 
WHERE salary >= 5000;

SELECT employee_id, first_name, department_id, manager_id FROM employees
WHERE manager_id = 103;

SELECT first_name, last_name, salary, hire_date FROM employees
WHERE first_name = 'William';

SELECT first_name, last_name, salary, department_id FROM employees;

SELECT first_name, last_name, salary, department_id FROM employees
WHERE department_id IS NULL;

SELECT first_name, last_name, salary, department_id FROM employees
WHERE department_id IS NOT NULL;

SELECT first_name, last_name, salary, department_id, commission_pct FROM employees
WHERE commission_pct IS NOT NULL;

SELECT first_name, last_name, salary, department_id FROM employees
WHERE manager_id IS NULL;

SELECT first_name, salary, email, phone_number FROM employees
WHERE salary > 10000 AND job_id = 'SA_REP';

SELECT first_name, salary, email, phone_number, job_id FROM employees
WHERE department_id = 60 OR salary >= 15000;

SELECT * FROM employees 
WHERE salary BETWEEN 5000 AND 10000
ORDER BY salary DESC ;

SELECT * FROM employees
WHERE department_id IN (10, 20, 30);

SELECT first_name, salary FROM employees
WHERE first_name LIKE 'W%';

SELECT first_name, salary FROM employees
WHERE first_name LIKE '%n';

SELECT first_name, salary FROM employees
WHERE first_name LIKE 'S%n';

SELECT first_name, salary FROM employees
WHERE first_name LIKE 'K____';

----------------------------------------------------------------------------------

USE hr;

SELECT first_name, department_id, salary, commission_pct FROM employees
WHERE commission_pct IS NOT NULL ;

SELECT 
	first_name, department_id, salary,
	salary * commission_pct AS "커미션" 
FROM employees
WHERE commission_pct IS NOT NULL ;

SELECT 
	first_name, department_id, salary,
	salary * commission_pct AS "커미션",
	salary + (salary * commission_pct) AS "총 수령액"
FROM employees
WHERE commission_pct IS NOT NULL ;

SELECT 
	first_name, department_id, salary,
	salary * commission_pct AS "커미션",
	salary + (salary * commission_pct) AS "총 수령액"
FROM employees
WHERE commission_pct IS NOT NULL AND salary + (salary * commission_pct) >= 15000;

SELECT first_name, hire_date FROM employees;

SELECT first_name, hire_date FROM employees
WHERE hire_date < '2007-01-01'
ORDER BY hire_date;

SELECT first_name, hire_date, salary FROM employees
WHERE hire_date LIKE '_____01%';

SELECT first_name, hire_date, salary FROM employees
WHERE hire_date LIKE '2007%';

SELECT first_name, hire_date, salary FROM employees
LIMIT 10;

SELECT FIRST_name, hire_date, salary FROM employees
LIMIT 10, 5;

SELECT first_name, hire_date, salary FROM employees
ORDER BY salary DESC 
LIMIT 15;

SELECT 10 % 3 FROM DUAL;

---------------------------------------

CREATE DATABASE IF NOT EXISTS `dima5` DEFAULT CHARACTER SET UTF8MB3;

SELECT DATABASE();

DROP TABLE IF EXISTS mytable;
CREATE TABLE IF NOT EXISTS mytable
(
	id integer PRIMARY KEY,
	name varchar(20)
);

USE dima5;
SELECT DATABASE();
SELECT * FROM mytable;

INSERT INTO mytable
(id, name)
VALUES
(1, '김홍도');

INSERT INTO mytable
(id, name)
VALUES
(2,'신윤복');

INSERT INTO dima5.mytable
VALUES
(3, '다빈치');

USE dima5;
SELECT database();
DROP TABLE IF EXISTS mytable2;
CREATE TABLE IF NOT EXISTS mytable2
(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(20) NOT NULL,
	phone varchar(20) UNIQUE,
	age int DEFAULT 20,
	gender char(1) CHECK (gender IN ('M', 'F'))
);

INSERT INTO mytable2
(name, phone, age, gender)
VALUES
('전우치', '1234', 29, 'M');

INSERT INTO mytable2
(name, phone, gender)
VALUES
('손오공', '1235', 'M')

SELECT * FROM mytable2;

USE dima5;
SHOW DATABASES;
SHOW TABLES;
DESC mytable2;

DROP TABLE IF EXISTS mytable3;
CREATE TABLE mytable3
(
	id int AUTO_INCREMENT,
	name varchar(20) NOT NULL,
	phone varchar(20) UNIQUE,
	age int DEFAULT 20,
	gender char(1)
	, PRIMARY KEY(id)
	, UNIQUE (phone)
	, CHECK (gender IN ('M', 'F'))
);

SELECT * FROM mytable3;

DROP TABLE IF EXISTS mytable5;
CREATE TABLE mytable5
(
	id int AUTO_INCREMENT,
	name varchar(20) NOT NULL,
	phone varchar(20) UNIQUE,
	age int DEFAULT 20,
	gender char(1)
	, CONSTRAINT mytable5_id_pk PRIMARY key(id)
	, CONSTRAINT mytable5_phone_uq UNIQUE (phone)
	, CONSTRAINT mytable5_gender_ck CHECK (gender IN ('M', 'F'))
);

SELECT * FROM mytable5;

-- -------------------------------------------------------------------
USE dima5;

DROP TABLE IF EXISTS dima5.fitness;
CREATE TABLE IF NOT EXISTS dima5.fitness
(
	id int AUTO_INCREMENT,
	name varchar(20) NOT NULL ,
	gender char(1),
	height decimal(5, 2),
	weight decimal(5, 2),
	std_weight decimal(5, 2),
	bmi decimal(4, 2),
	bmi_result varchar(30)
	, CONSTRAINT fitness_id_pk PRIMARY KEY (id)
	, CONSTRAINT fitness_gender_ck CHECK (gender IN ('남', '여'))
	, CONSTRAINT fitness_height_ck CHECK (150 < height < 200)
);

SHOW DATABASES;
USE information_schema;
SHOW tables;

SELECT * FROM table_constraints;

INSERT INTO dima5.fitness
(name, gender, height, weight, bmi)
VALUES
('사오정', '남', 175.05, 65, weight/(height*height*0.0001));

COMMIT;
USE dima5;
SELECT * FROM fitness;

INSERT INTO fitness
(name, gender, height, weight, bmi)
VALUES
('장원영', '여', 171, 45, weight/(height*height*0.0001));

USE dima5;
SELECT * FROM fitness;

DROP TABLE IF EXISTS mytable6;
CREATE TABLE IF NOT EXISTS mytable6
(
	userid int PRIMARY KEY AUTO_INCREMENT,
	username varchar(20) NOT NULL,
	birthday date,
	join_date datetime DEFAULT CURRENT_timestamp
);

SELECT * FROM mytable6;

INSERT INTO mytable6
(username, birthday)
VALUES
('삼장법사', '1980-01-01');

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
('전제환', '1998-11-11');

SELECT * FROM mytable6;

UPDATE mytable6
SET birthday = '2025-01-01'
WHERE userid = 3;

DELETE FROM mytable6
WHERE userid = 1;

COMMIT;
ROLLBACK;

USE dima5;
DROP TABLE IF EXISTS child1;
DROP TABLE IF EXISTS parent1;
CREATE TABLE IF NOT EXISTS parent1
(
	id int AUTO_INCREMENT
	, name varchar(30) NOT NULL
	, phone varchar(20) UNIQUE
	, age   decimal(3) DEFAULT 20
		, CONSTRAINT parent_id_pk PRIMARY KEY(id)
);

CREATE TABLE child1
(
	cid int AUTO_INCREMENT
	, id int 
	, major varchar(30) NOT NULL
	, grade decimal(2)
		, CONSTRAINT child1_cid_pk PRIMARY KEY (cid)
		, CONSTRAINT child1_id_fk  FOREIGN KEY (id) REFERENCES parent1(id)
		ON DELETE CASCADE ON UPDATE CASCADE 
);

USE dima5;
SELECT * FROM parent1;
SELECT * FROM child1;

INSERT INTO parent1 (name, phone) VALUES ('이몽룡', '1234');
INSERT INTO parent1 (name, phone) VALUES ('성춘향', '1212');
INSERT INTO parent1 (name, phone) VALUES ('심청이', '0012');
INSERT INTO parent1 (name, phone) VALUES ('뺑덕이', '5544');

INSERT INTO child1 (id, major, grade) VALUES (1, '컴퓨터공학', 4);
INSERT INTO child1 (id, major, grade) VALUES (2, '한국학', 2);
INSERT INTO child1 (id, major, grade) VALUES (3, '영어영문학', 1);
INSERT INTO child1 (id, major, grade) VALUES (4, '응용미술', 4);

COMMIT;

UPDATE parent1
SET id = 7 WHERE id = 1;

SELECT * FROM parent1;

DELETE FROM parent1
WHERE id = 4;

SELECT * FROM child1;

-- -------------------------------------------------
USE hr;

SELECT * FROM employees;
SELECT * FROM departments;

SHOW CREATE TABLE employees;
SHOW CREATE TABLE departments;

DESC employees;
DESC departments;

-- Cross Join
SELECT * 
FROM employees e CROSS JOIN departments d;

-- Inner Join
SELECT *
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id;

-- 1) 특정 컬럼만 추출 (이름, 부서명, 업무, 급여)
SELECT e.first_name, d.department_name, e.job_id, e.salary
FROM employees e JOIN departments d
ON e.department_id = d.department_id
ORDER BY 4 DESC ;

-- 2) 특정 컬럼만 추출 - USING 키워드 사용 (사원번호, 이름, 부서명, 급여)
SELECT e.employee_id, e.first_name, d.department_name, e.salary
FROM employees e JOIN departments d
USING (department_id)
ORDER BY salary DESC ;

-- 3) 급여가 5000을 초과하는 직원들의 이름, 급여, 부서명을 조회
 -- JOIN ON 사용 / USING 사용
SELECT e.first_name, e.salary, d.department_name
FROM employees e JOIN departments d
USING (department_id)
WHERE e.salary > 5000;

-- 4) 부서명과 도시를 조회하시오. (단, 부서장이 없는 부서는 조회에서 제외)
SHOW tables;
SELECT * FROM departments;
SELECT * FROM locations;

SELECT d.department_name, l.city
FROM departments d JOIN locations l
USING (location_id)
WHERE d.manager_id IS NOT NULL ;

-- [연습문제] 테이블 3개를 조인해보기
-- employees e, departments d, locations l
-- 직원명, 급여, 부서명, 근무하는 도시명을 조회하시오.
SELECT e.first_name, e.salary, d.department_name, l.city
FROM employees e JOIN departments d
USING (department_id)
JOIN locations l
USING (location_id);

-- [연습문제] 직원명, 급여, 부서명, 근무하는 도시명을 조회하시오. 
-- 조회조건: 급여가 5000 이상
-- 급여의 내림차순
-- employees e, departments d, locations l
SELECT e.first_name, e.salary, d.department_name, l.city
FROM employees e JOIN departments d
USING (department_id)
JOIN locations l
USING (location_id)
WHERE e.salary >= 5000
ORDER BY e.salary DESC ;

-- [연습문제] 부서명과 부서가 속한 도시와 해당 도시가 있는 나라를 조회하시오. 
--			  manager_id가 없는 부서를 제외하면 11개
--			  manager_id가 없는 부서도 포함하면 27개
SHOW tables;
SELECT * FROM departments;
SELECT * FROM locations;
SELECT * FROM countries;

SELECT d.department_name, l.city, c.country_name, d.manager_id
FROM departments d JOIN locations l
USING (location_id)
JOIN countries c
USING (country_id)
WHERE d.manager_id IS NOT NULL ;

-- [연습문제] 부서명과 부서장의 이름, 부서가 속한 도시와 해당 도시가 있는 나라를 조회하시오. 
-- 조회조건: Manager가 없는 부서는 조회 조건에서 제외됨
-- departments의 manager_id와, employees의 employee_id를 비교해야 함
-- FK들끼리 비교하는 게 아니라 FK와 PK를 비교 
-- 11개
SELECT department_name, first_name, city, country_name
FROM departments d JOIN employees e
ON d.manager_id = e.employee_id
JOIN locations l
USING (location_id)
JOIN countries c
USING (country_id);

SELECT * FROM departments;

SELECT e.first_name, e.salary, d.department_name
FROM employees e LEFT JOIN departments d
USING (department_id);

SELECT e.first_name, e.salary, d.department_name
FROM departments d LEFT JOIN employees e
USING (department_id);

-- [연습문제] Right Outer Join을 이용해서 부서명과 부서가 위치한 도시, 나라를 조회하시오.
SELECT d.department_name, l.city, c.country_name
FROM countries c RIGHT JOIN locations l
USING (country_id)
RIGHT JOIN departments d
USING (location_id);

-- Self Join
-- [문제] 사원번호, 이름, 상관의 사원번호, 상관의 이름을 조회하시오.
SELECT * FROM employees;

SELECT e1.employee_id AS "사원번호", e1.first_name "이름",
	   e1.manager_id AS "상관의 사원번호", e2.first_name AS "상관의 이름"
FROM employees e1 JOIN employees e2
ON e1.manager_id = e2.employee_id;

-- --------------------------------------------------------------------
-- 시험 중
CREATE USER 'dimauser'@'localhost' identified BY 'dima2025';
CREATE USER 'newuser'@'localhost' identified BY 'newuser';


-- 4. 부서 코드가 50, 80, 100 중의 하나이면서 
-- 급여가 7000이상, 8000이하인 사원들의 이름, 급여, 부서번호를 출력하시오.
USE hr;
SELECT first_name, salary, department_id
FROM employees 
WHERE department_id IN (50, 80, 100) AND (salary BETWEEN 7000 AND 8000);

-- 5. 프로그램 실행 날짜를 기준으로 근무한 기간이 18년 미만인 사원들의 이름과 입사일을 
-- 입사일 기준으로 오름차순하여 출력하시오. 
USE hr;
SELECT hire_date FROM employees;
SELECT first_name, last_name, hire_date
FROM employees
WHERE datediff(curdate(), hire_date) < 18 * 365
ORDER BY hire_date;

-- 6. 사원별로 이름과, 성, 급여, 부서 번호 및 자신 부서의 평균 급여를 
-- 부서별 오름차순으로 조회하시오. 
-- (단, 부서 평균 급여보다 급여가 많은 직원만 조회되어야 하며  
-- 평균 급여는 소수점 2 자리까지 출력)
USE hr;
SELECT e.first_name "이름", e.last_name "성", e.salary "급여", e.department_id "부서번호", round(부서평균, 2) "부서 평균 급여"
FROM 
	(SELECT department_id AS "부서번호", avg(salary) AS "부서평균"
	 FROM employees
	 GROUP BY department_id) tbl , employees e 
WHERE tbl.부서번호 = e.department_id
AND e.salary > tbl.부서평균
ORDER BY 4;

-- 7. JOB_HISTORY, JOBS 테이블 사용하여 사원 번호, 업무 기간, 업무 명이 출력 되도록 하시오.
-- 업무 기간은 올림으로 처리하시오
USE hr;
SELECT * FROM jobs; -- job_title "업무명"
SELECT * FROM job_history; -- period_diff(end_date - start_date) "업무기간", employee_id "사원번호"

SELECT employee_id "사원번호", concat(CEIL(datediff(end_date, start_date)/31), '개월') "업무기간", job_title "업무명"
FROM jobs JOIN job_history
USING (job_id);

-- 8. 2025년 한 해가 오늘을 기준으로 몇 일 남았는지 출력하는 SQL문장을 작성하시오.
-- (아래의 처리 결과와 다를 수 있으며 참고만 할 것)
SELECT concat('2025년 한 해가 오늘을 기준으로 ', datediff('2025-12-31', curdate()), '일 남았습니다.') AS "남은일수";
SELECT datediff('2025-12-31', curdate()) AS "남은일수";

-- 9. Subquery를 사용하여 각 부서별 평균근무일을 다음과 같이 조회하시오
USE hr;
SELECT * FROM employees;
SELECT * FROM departments; -- department_name "부서명"
SELECT * FROM job_history; -- datediff(start_date, end_date) "평균 근무일"
SELECT datediff(start_date, end_date) FROM job_history;

SELECT department_name AS 부서명, 
	(SELECT avg(datediff(end_date, start_date)) FROM job_history j
	 WHERE d.department_id = j.department_id) "평균 근무일"
FROM departments d;

-- 모든 사원들의 이름과 소속 부서명을 다음과 같이 출력하시오. (SUBQUERY 사용) 
SELECT concat(first_name, ' ', last_name) 이름,
	   (SELECT department_name FROM departments d
	    WHERE d.department_id = e.department_id) 부서
FROM employees e;

-- 10. Employees 테이블에서 매니저가 같은 사원들의 평균급여가 4000이상인 사원의 
-- 평균급여, 최대급여, 최소급여를 그림과 같이 출력하시오. 
-- 단, 매니저번호가 없는 사원은 0번으로 출력하고, 평균급여는 소수점 이하 올림하시오.




-- 11. 각 부서별로 해당 부서의 급여 평균 미만의 급여를 수령하는 직원 명단을 조회하시오
-- (조회 컬럼: 사원번호, 이름, 부서명, 급여)
-- 부서명 오름차순 정렬할 것
USE hr;
SELECT
	e.employee_id, e.first_name, d.department_name, e.salary
FROM (SELECT department_id, avg(salary) AS "부서평균"
	  FROM employees e
	  GROUP BY department_id) tbl, employees e JOIN departments d
ON e.department_id = d.department_id  
WHERE tbl.department_id = e.department_id
AND e.salary < tbl.부서평균
ORDER BY 3;

-- 12. 날짜관련 함수를 이용하여 
-- 입사일이 3월인 모든 사원의 정보를 출력하시오. ( LIKE 연산자 사용하면 안됨)
USE hr;
SELECT first_name, last_name, hire_date, job_id FROM employees
WHERE month(hire_date) = 3;



-- 13. 나라명 대한민국('KOR') 의 도시중 도시명이 'Kwangju'의 인구수가 
-- 대한민국 전체 인구 수의 몇 퍼센트를 차지하는지 구하시오.



-- 14. country, city 테이블을 조인하여 국가 이름, 도시 수를 출력하는 쿼리를 작성하시오.
USE world;
SHOW tables;
SELECT * FROM city;
SELECT * FROM country;

SELECT co.Name 국가명, count(*) 도시수
FROM country co JOIN city ci
ON ci.CountryCode = co.Code
GROUP BY co.Name;


-- 15. 각 국가별로 전체 도시 인구 수 평균을 넘는 도시 목록을 출력하는 쿼리를 작성하시오




-- 16. 테이블의 생성
CREATE TABLE IF NOT EXISTS Categories 
(
	CATEGORY_ID CHAR(7) 	  PRIMARY KEY CHECK (CATEGORY_ID IN ('WR_PROD', 'PA_PROD', 'AR_PROD', 'ME_PROD', 'ET_PROD')),
	CATEGORY_NAME VARCHAR(30) UNIQUE CHECK (CATEGORY_NAME IN ('필기구', '종이류', '미술용품', '측정용품', '기타')),
	CATEGORY_DESC VARCHAR(3000) DEFAULT 'None'
);

-- 17. 테이블의 생성
CREATE TABLE IF NOT EXISTS Products
(
	PROD_ID int PRIMARY KEY AUTO_INCREMENT,
	PROD_NAME varchar(30) NOT NULL,
	COUNTRY varchar(50) NOT NULL,
	MANUFACTURES varchar(50) NOT NULL,
	MAKING_DATE datetime,
	CATEGORY_ID char(7), 
		CONSTRAINT products_ctid_fk FOREIGN KEY (CATEGORY_ID) REFERENCES Categories (CATEGORY_ID)
		ON DELETE CASCADE
);

-- 18. 테이블의 생성
CREATE TABLE IF NOT EXISTS Stock
(
	STOCK_ID int PRIMARY KEY AUTO_INCREMENT,
	PROD_ID int, 
	RECEIVE_DATE datetime,
	FORWARD_DATE datetime DEFAULT CURRENT_TIMESTAMP,
	UNIT_PRICE decimal(10, 2) DEFAULT 0,
	TOTAL_STOCK int(7) DEFAULT 0,
		CONSTRAINT Stock_pdid_fk FOREIGN KEY (PROD_ID) REFERENCES Products (PROD_ID)
		ON DELETE CASCADE 
);

-- 19. 위에서 생성한 Product 테이블에 
-- 'Bigo' 라는 이름의 컬럼을 'making_date' 컬럼뒤에 추가하는 명령을 쓰시오
-- * 컬럼명 : BIGO - 가변길이문자열 200
SELECT * FROM Products;

ALTER TABLE Products
ADD BIGO varchar(200) 
AFTER MAKING_DATE;





















