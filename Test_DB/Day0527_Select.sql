-- 2025년 5월 27일 (SELECT)
/*

***** SQL(Structured Query Language)
- DBMS에 접근해서 처리하는 모든 명령어
- 국제 표준이지만 각 벤더별로 명령문이 조금씩 다르다. 
- 명령어의 종류

1) DDL(Database Definition Language) : 객체를 다루는 명령어
   Create(생성), Alter(변경), Drop(전체 삭제)
   
2) DML(Database Manipulation Language) : 테이블의 레코드를 다루는 명령어
   Insert(삽입), Update(수정), Delete(일부 삭제), Select(조회)

3) TCL(Transaction Control Language) : 트랜잭션을 다루는 명령어
   Commit(저장), Rollback(전체 되돌림), Savepoint(지정된 위치까지 되돌림)
   
4) DCL(Database Control Language) : 권한을 다루는 명령어
   Grant(권한 부여), Revoke(권한 회수)
   
** SQL명령은 ; 로 끝나야 한다.
*/ 

/* Select문 : 조회 

SELECT [DISTINCT | ALL] 컬럼명 FROM 테이블명
ORDER BY 컬럼명 [DESC | ASC]   -- 가장 마지막!
*/

USE hr;
SHOW DATABASES;

SELECT * FROM hr.regions;
SELECT * FROM countries;
SELECT * FROM locations;
SELECT * FROM departments;
SELECT * FROM jobs;
SELECT * FROM employees;    -- 직원정보
SELECT * FROM job_history;

SELECT * FROM employees;

SELECT first_name, salary FROM employees;
SELECT department_id FROM employees;
SELECT DISTINCT department_id FROM employees; -- 중복 제거

-- [연습] 이름, 급여, 부서번호를 조회하시오.
SELECT first_name, salary, department_id FROM employees;

-- [연습] 이름, 급여, 부서번호를 급여 기준으로 내림차순 조회하시오.
SELECT first_name, salary, department_id 
FROM employees
ORDER BY salary DESC;

-- [연습] 이름, 급여, 부서번호를 부서 기준으로 오름차순 조회하시오.
-- ASC : 오름차순, DESC : 내림차순
SELECT first_name, salary, department_id 
FROM employees
ORDER BY department_id ASC, salary DESC, first_name ASC;

-- [연습] employees 테이블에서 이름(first_name), 입사일(hire_date), 업무(job_id)를 조회하시오. 
--        입사일 기준 오름차순
SELECT first_name, hire_date, job_id
FROM employees
ORDER BY hire_date ASC;

-- 데이터베이스 조회
SHOW DATABASES;

-- 테이블을 조회
SHOW tables;

USE world;
SHOW tables;

USE sakila;
SHOW tables;

USE hr;
-- -------------- 조건을 이용한 조회
/*
 *
 * SELECT [DISTINCT | ALL] 컬럼명 FROM 테이블명
 * WHERE 조건
ORDER BY 컬럼명 [DESC | ASC]   -- 가장 마지막! 

<비교 연산자>
	>   <   >=   <=   =   !=
	
<null 비교>
	컬럼명 is null
	컬럼명 is not null
	
<논리연산> 	
	and, or, not
	조건 and 조건 
	조건 or 조건
	
	컬럼명 IN (값1, 값2, 값3)	--> 이산 데이터
	컬럼명 BETWEEN 값 AND 값	--> 연속 데이터
	
<문자열 비교 연산>
- 문자열을 표시할 때에는 ''로 표시해야 한다.
- 문자열을 비교할 때  비교연산자를 사용하면, 정확히 해야 한다.
- like를 이용하여 연산을 할 수 있다. 

- 와일드카드 : % (0개 이상), _ (_ 하나당 글자 하나로 글자수 제한)

  컬럼명 LIKE 'W%'	: W로 시작하는!
  컬럼명 LIKE '%s' 	: s로 끝나는!
  컬럼명 LIKE '%i%' : i가 포함되는!
  컬럼명 LIKE '%%' 	: 모든 글자!
  
<산술연산자>
	+ - * / % 

 */

-- [연습] 급여가 5000 이상인 사람을 모두 조회하시오.
SELECT * FROM employees
WHERE salary >= 5000;

-- [연습] 매니저 번호가 103번인 직원의 사원번호(employee_id), 이름, 부서(department_id), 매니저 번호(manager_id)를 조회하시오. 
SELECT employee_id, first_name, department_id, manager_id
FROM employees
WHERE manager_id = 103;

-- [연습] 이름이 'William'인 사람의 이름, 성, 급여, 입사일을 조회하시오.
SELECT first_name, last_name, salary, hire_date 
FROM employees
WHERE first_name = 'William';

-- 이름, 성, 급여, 부서번호를 조회하시오.
SELECT first_name, last_name, salary, department_id 
FROM employees;

-- 이름, 성, 급여, 부서번호를 조회하시오. (부서번호가 NULL인 사람)
SELECT first_name, last_name, salary, department_id 
FROM employees
WHERE department_id IS NULL;  -- department_id = NULL 은 틀린 표현 !!

-- 이름, 성, 급여, 부서번호를 조회하시오. (부서번호가 NULL이 아닌 사람)
SELECT first_name, last_name, salary, department_id 
FROM employees
WHERE department_id IS NOT NULL; 

-- [연습] 이름, 성, 급여, 부서번호, 커미션을 조회 (커미션을 받는 사람)
SELECT first_name, last_name, salary, department_id, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

-- [연습] 매니저가 없는 직원의 이름, 성, 급여, 부서번호
SELECT first_name, last_name, salary, department_id
FROM employees
WHERE manager_id IS NULL;

-- 논리연산을 이용한 조회
-- 급여가 10000을 초과하면서 직급이 'SA_REP'인 직원의 정보
-- (이름, 급여, 이메일, 전화번호, 직급)을 조회하시오.
SELECT first_name, salary, email, phone_number, job_id
FROM employees
WHERE salary > 10000 AND job_id = 'SA_REP';

-- [연습] 부서번호가 60이거나 급여가 15000 이상인 직원의 정보
-- (이름, 급여, 이메일, 전화번호, 직급)을 조회하시오.
SELECT first_name, salary, email, phone_number, job_id
FROM employees
WHERE department_id = 60 OR salary >= 15000;

-- 급여가 5000 이상 10000 이하인 직원정보 조회 (급여기준 내림차순)
SELECT first_name, salary
FROM employees
WHERE salary BETWEEN 5000 AND 10000
ORDER BY salary DESC;

-- 부서가 10, 20, 30인 직원정보 조회 
SELECT first_name, salary, department_id
FROM employees
WHERE department_id IN (10, 20, 30);

-- 이름이 W로 시작하는 사람의 정보 (이름, 급여)
SELECT first_name, salary
FROM employees
WHERE first_name LIKE 'W%';

-- 이름이 n으로 끝나는 사람의 정보 (이름, 급여)
SELECT first_name, salary
FROM employees
WHERE first_name LIKE '%n';

-- 이름이 S로 시작해서 n으로 끝나는 사람의 정보 (이름, 급여)
SELECT first_name, salary
FROM employees
WHERE first_name LIKE 'S%n';

-- 이름이 K로 시작해서 5글자인 직원의 정보 (이름, 급여)
SELECT first_name, salary
FROM employees
WHERE first_name LIKE 'K____';












