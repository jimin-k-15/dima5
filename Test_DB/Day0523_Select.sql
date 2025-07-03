/* 2025. 5. 23.
 *   1. hr 데이터베이스 생성 후 작업을 완료
 */ 

USE hr; 

SELECT * FROM hr.employees e ;
SELECT first_name FROM employees;  
SELECT last_name FROM employees;  
SELECT first_name, last_name, salary 
FROM employees;

-- ALL : 모든 레코드를 전부 조회 (생략 가능)
SELECT ALL department_id  
FROM employees;

-- distinct : 중복 제거
SELECT DISTINCT  first_name, department_id  
FROM employees;

-- order by : 정렬 (문장의 마지막에)
SELECT DISTINCT first_name, department_id
FROM employees
ORDER BY first_name ;

-- order by : 정렬 (문장의 마지막에)
-- ASC(오름차순, 생략가능), DESC(내림차순, 생략불가능)
SELECT DISTINCT first_name, department_id
FROM employees
ORDER BY first_name DESC;

-- [연습] employees 테이블에서 이름, 급여, 부서번호를 급여의 내림차순
--        으로 조회하시오.
SELECT first_name, salary, department_id
FROM employees
ORDER BY salary DESC;

