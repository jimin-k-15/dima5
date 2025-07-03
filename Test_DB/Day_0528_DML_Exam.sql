/* DML 연습
*/

-- AUTOCOMMIT 활성화(1)/비활성화(0)하기
SET AUTOCOMMIT = 0;

-- hr DB 사용
USE hr;

-- employees 테이블 확인
SELECT * FROM hr.employees e ;

-- 1) select로 나온 결과물로 새로운 테이블을 생성하는 방법
CREATE TABLE dima5.emp
AS 
	SELECT * FROM hr.employees e;

USE dima5;
SHOW tables;
SELECT * FROM dima5.emp;

/* [연습] */

-- 1) 사원번호 100번인 사람의 이름을 '오공'으로 수정하시오.
UPDATE dima5.emp
SET first_name = '오공'
WHERE employee_id = 100;

SELECT * FROM dima5.emp
WHERE employee_id = 100;

-- 2) SH_CLERK인 직급을 전부 SA_REP로 수정하시오.
UPDATE dima5.emp
SET job_id = 'SA_REP'
WHERE job_id = 'SH_CLERK';

SELECT * FROM dima5.emp;

-- 3) 커미션이 없는 직원을 삭제하시오.
DELETE FROM dima5.emp
WHERE commission_pct IS NULL;

SELECT * FROM dima5.emp;

-- 4) 모든 직원의 급여를 25% 올리고, 적용하시오(commit).
UPDATE dima5.emp
SET salary = salary * 1.25;

SELECT * FROM dima5.emp;

COMMIT;

-- 5) [문제]
/* 'hr' 스키마의 employees 테이블에서
 	사원번호, 이름, 이메일, 전화번호, 입사일, 직무, 급여 컬럼을 
 	'dima5' 스키마에 emp2 테이블로 데이터 복사하시오.
 	(이때, 급여가 10000 미만인 직원은 제외할 것)
 */
USE hr;

SELECT * FROM hr.employees e ;
CREATE TABLE dima5.emp2
AS 
	SELECT employee_id, first_name, email, phone_number, hire_date, job_id, salary
	FROM hr.employees e
	WHERE salary >= 10000;

SELECT * FROM dima5.emp2;












