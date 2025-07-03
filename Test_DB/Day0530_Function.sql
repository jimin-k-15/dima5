/* 2025년 5월 30일
   if함수, 다중행 함수(= 집계함수, 그룹함수)   **중요** 
   서브쿼리
*/ 

-- 날짜함수
SELECT makedate(2025, 100);  -- 2025.1.1에서 100일 후 날짜
SELECT maketime(10, 23, 30); -- 정수 3개를 입력받아 날짜로 변환

-- null 관련 함수
USE sakila;

-- if(조건, 참, 거짓)
SELECT * FROM payment;
SELECT count(*) FROM payment;
SELECT if(amount >= 5, '5이상', '5미만') FROM payment;

-- case~when~then~end
SELECT * FROM film_actor;

SELECT DISTINCT 
	CASE film_id
		WHEN 1 THEN 'Drama'
		WHEN 2 THEN 'Adventure'
		WHEN 3 THEN 'Horror'
		ELSE 'Everything'
	END
FROM film_actor;

-- ifnull수식1, 수식2)
USE world;

SELECT * FROM country;

-- ifnull, nullif 헷갈릴 수 있으니 주의!!

-- ifnull(컬럼, 값) : 컬럼의 값이 null인지 확인 후 
-- null이면 2번째 값, null이 아니면 원래 값 그대로 
SELECT name, region, ifnull(gnpold, '없음') FROM country;

-- nullif(컬럼1, 컬럼2) : 1, 2가 같으면 null 반환, 다르면 첫번째 값 반환
SELECT name, localname FROM country;
SELECT name, localname, nullif(name, localname) FROM country;


USE world;
-- [문제] if함수를 이용해서 name, localname 같으면 '같다', 혹은 '같지않다'
-- 출력 컬럼은 name, localname, if 결과
SELECT name, localname, if(name = localname, '같다', '같지않다') FROM country;


USE hr;
-- [연습] ifnull()을 이용
-- hr.employees 테이블에 직원들 중 manager_id가 없는 사람은
-- manager_id가 null인 사람은 "최고 경영자"라고 출력,
-- manager_id가 있는 사람은 manager_id 출력
-- 조회 컬럼: 이름, 급여, 매니저아이디
-- 조회 조건: 급여순으로 내림차순 정렬, 상위 30명만 출력
SELECT first_name, salary, ifnull(manager_id, '최고 경영자') AS "Manager"  
FROM employees
ORDER BY salary DESC
LIMIT 30;


-- [연습] hr.departments 테이블에서 매니저가 null인 경우 처리
-- 매니저번호가 없는 경우 "No Manager"라고 출력,
-- 매니저가 있으면 매니저 이름
-- 조회 컬럼: 부서번호, 부서명, 매니저명
-- hint: join 사용
SELECT * FROM employees;
SELECT * FROM departments;

SELECT 
	d.department_id, d.department_name, ifnull(e.first_name, 'No Manager') AS "Manager Name"
FROM departments d LEFT OUTER JOIN employees e 
ON d.manager_id = e.employee_id;

/* 그룹함수 */
-- count(컬럼명): null은 세지 않는다!
SELECT count(employee_id) FROM employees;		-- 107
SELECT count(commission_pct) FROM employees; 	-- 35 

-- max(컬럼명), min(컬럼명)
SELECT max(salary), min(salary) FROM employees;

-- sum(컬럼명), avg(컬럼명)
SELECT sum(salary) "급여합계", round(avg(salary), 2) "급여평균" FROM employees; -- avg는 소수점 이하 2자리까지 출력

-- group by 명령을 이용해서 특정 컬럼을 그룹화함 ==> 그룹함수 사용
-- 각 부서별 인원수
SELECT department_id, count(*) AS "부서인원"
FROM employees 
GROUP BY department_id;

-- 부서별 평균급여, 총급여, 최대급여, 최소급여
SELECT 
	department_id, count(*) AS "부서인원"
	, avg(salary), sum(salary)
	, max(salary), min(salary)
FROM employees 
GROUP BY department_id;

-- [문제] 직무별 직무아이디(job_id), 평균급여를 조회하시오.
SELECT 
	job_id, avg(salary)
FROM employees 
GROUP BY job_id
ORDER BY 2;

-- [문제] 부서별 평균급여와 인원수를 조회
--		  부서별로 값이 NULL이거나 1명인 경우는 제외
SELECT 
	department_id, round(avg(salary),2) AS "평균급여", count(*) AS "부서인원"
FROM employees
GROUP BY department_id
HAVING 
	department_id IS NOT NULL 
	AND 
	count(*) >= 2;

-- [문제] 입사연도별 입사인원을 조회하시오.
-- 		  년도 4자리, 입사인원
SELECT YEAR(hire_date) AS "입사연도", count(*) AS "입사인원"
FROM employees
GROUP BY YEAR(hire_date)
ORDER BY 입사연도;		-- ORDER BY절에서는 별칭 사용 가능


-- [문제] 모든 사원의 이름과, 전화번호 첫 3자리를 출력하시오.
SELECT first_name, left(phone_number, 3) AS "전화번호 첫 3자리" FROM employees;
SELECT first_name, substring(phone_number, 1, 3) phone_number FROM employees;		-- 교수님 버전

-- [문제] 모든 사원의 이름과 성, 그리고 (이름과 성을 합한 글자수)를 출력하시오.
SELECT first_name, last_name, concat(first_name, last_name), length(concat(first_name, last_name))
FROM employees;

/**
 * 서브쿼리(Subquery)
 *  - 서브쿼리 
 *  - 메인쿼리
 * 
 * 서브쿼리의 종류
 *  1) 단일행 서브쿼리
 *  2) 다중행 서브쿼리
 *  3) 다중컬럼 서브쿼리
 */

-- 사원번호 162번의 급여가 얼마인가?
SELECT salary 
FROM employees
WHERE employee_id = 162; -- 결과가 딱 하나, 즉 단일 행

-- [연습] 사원번호 162번의 급여와 같은 액수의 급여를 받는 직원의 
--		  이름, 급여, 부서번호를 조회하시오.
-- 1) 두 번 작업 
SELECT salary 
FROM employees
WHERE employee_id = 162;

SELECT first_name, salary, department_id FROM employees
WHERE salary = 10500;	-- 2개의 쿼리를 하나로 묶는 작업이 바로 서브쿼리 

-- 2) 서브쿼리로 한 번에 작업
SELECT first_name, salary, department_id 
FROM employees
WHERE salary = (SELECT salary
				FROM employees
				WHERE employee_id = 162);

-- [연습] 'Oliver'라는 직원과 같은 부서에서 근무하는 동료직원의 부서번호, 이름을 조회하시오. 
SELECT department_id
FROM employees
WHERE first_name = 'Oliver';

SELECT department_id, first_name
FROM employees
WHERE department_id = 80;

-- 서브쿼리로 해결하기
SELECT department_id, first_name
FROM employees
WHERE department_id = (SELECT department_id
					   FROM employees
					   WHERE first_name = 'Oliver');

-- [연습] 위와 동일 - 부서명과 직원명으로 조회하시오. 
SELECT department_name, first_name
FROM employees e JOIN departments d
	 USING (department_id)
WHERE department_id = (SELECT department_id
					   FROM employees
					   WHERE first_name = 'Oliver');

-- 2) 다중행 서브쿼리
-- 30번 부서에서 근무하는 직원들의 직급과 동일한 직급이 다른 부서에도 있는지 조회하자.
--	  (1)
SELECT DISTINCT job_id 
FROM employees
WHERE department_id = 30;

SELECT job_id, department_id
FROM employees
WHERE job_id IN (SELECT DISTINCT job_id 
				 FROM employees
				 WHERE department_id = 30);

-- world 스키마에서 제공하는 데이터베이스를 확인한 후 
-- 공식 언어를 'Spanish'로 사용하는 나라의 이름과 공식언어를 조회하는 코드를 서브쿼리로 작성하시오. 
USE world;
SHOW tables;
SELECT * FROM city;
SELECT * FROM country;
SELECT * FROM countrylanguage;

-- 국민 모두(100%)가 스페인어를 사용하는 나라 코드
SELECT countrycode
FROM countrylanguage
WHERE Percentage = 100 
AND 
	`LANGUAGE` = 'Spanish';

SELECT name, population
FROM country
WHERE code IN (SELECT countrycode
			   FROM countrylanguage
			   WHERE Percentage = 100 
			   AND 
				   `LANGUAGE` = 'Spanish');

--
USE hr;

/* 1) ANY 연산자 */

-- "< ANY"는 서브쿼리에서 나온 그 어떤 값보다 작은 값
-- (즉, 서브쿼리의 가장 큰 값보다 작으면 됨)
SELECT first_name, salary 
FROM employees
WHERE salary < ANY (SELECT salary
					FROM employees
					WHERE job_id = 'ST_MAN'
					ORDER BY salary) -- 5800 ~ 8200 
ORDER BY salary;

-- "> ANY"는 서브쿼리에서 나온 가장 작은 값보다 큰 값
-- (즉, 서브쿼리의 가장 큰 값보다 작으면 됨)
SELECT first_name, salary 
FROM employees
WHERE salary < ANY (SELECT salary
					FROM employees
					WHERE job_id = 'ST_MAN'
					ORDER BY salary)  
ORDER BY salary;

-- "= ANY" 
SELECT first_name, salary 
FROM employees
WHERE salary = ANY (SELECT salary
					FROM employees e INNER JOIN jobs j 
					USING (job_id)
					WHERE job_title LIKE '%Manager')
ORDER BY salary;

/* ALL 연산자 */
-- = ALL은 서브쿼리에서 나온 모든 값과 같은 값을 가진 SALARY를 조회함
-- 없음!! 이런 값은 실제적으로 존재하지 않음
SELECT employee_id, first_name, salary
FROM employees
WHERE salary = ALL (SELECT salary
					FROM employees e INNER JOIN jobs j
					USING (job_id)
					WHERE job_title LIKE '%Manager' ORDER BY 1);

-- 다중 컬럼 서브쿼리
-- [문제]
-- 1)단계
SELECT department_id, max(salary)
FROM employees
GROUP BY department_id;

-- 2)단계 
SELECT * FROM employees
WHERE 
department_id = 30
AND 
salary = 11000;

-- 위 두 쿼리를 합쳐서 하나의 서브쿼리로 작성
SELECT *
FROM employees
WHERE 
(department_id, salary) IN (SELECT department_id, max(salary)
						  	FROM employees
						  	GROUP BY department_id);

-- [문제] 각 부서별로 급여를 가장 많이 받는 직원의 사번, 이름, 급여, 부서명, 직급명을 조회
-- join과 서브쿼리를 함께 사용
SELECT 
	employee_id, concat(first_name, ' ', last_name) AS "name",
	salary, department_name, job_title
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
INNER JOIN jobs j
ON e.job_id = j.job_id
WHERE (e.department_id, e.salary) IN (SELECT department_id, max(salary)
									  FROM employees e
									  GROUP BY department_id);

/* 스칼라 서브쿼리 : 서브쿼리의 사용위치가 select from 사이에! */ 

SELECT 
	(SELECT last_name FROM employees WHERE first_name = 'Bruce') AS "Bruce의 성",
	(SELECT last_name FROM employees WHERE first_name = 'Daniel') AS "Daniel의 성";

/* Inline View : 쿼리의 결과가 다중행 + 다중컬럼일 경우 where에 사용하기 어려우므로 
 * 				 서브쿼리의 위치를 from절에 두어서 그 결과를 마치 하나의 가상 테이블로 
 * 				 처리하는 개념
 * 
 */

-- Oracle에는 없고 MySQL에만 있는 독특한 문법
SET @rownum := 0;	-- 변수를 선언하고 초기화

SELECT @rownum := @rownum + 1;		-- 변수의 값을 조회

SELECT tbl.*
FROM 
	(SELECT @rownum := @rownum + 1 AS seq, employee_id, first_name, 
			salary , department_id
	 FROM employees
	 WHERE department_id = 80) tbl
WHERE salary > 9000;


-- [문제] 서브쿼리를 이용하여 아래 문제를 해결하시오
-- 각 부서별로 해당 부서의 급여 평균 미만의 급여를 수령하는 직원 명단 조회
-- (부서번호, 사원번호, 이름, 급여, 부서별 평균급여를 조회한 결과가 출력되어야 함)
-- avg(salary) --> 그룹함수이므로 사원번호나 이름과 같이 그룹화되지 않은 컬럼과 함께 사용할 수 없다!

-- 각 부서별 평균급여
SELECT e.department_id, e.employee_id, e.first_name, e.salary, round(부서번호)
FROM 
	(SELECT department_id AS "부서번호", avg(salary) AS "부서평균"
	 FROM employees
	 GROUP BY department_id) tbl , employees e 
WHERE tbl.부서번호 = e.department_id
AND e.salary < tbl.부서평균
ORDER BY 1, salary DESC;



-- 서브쿼리 연습문제

USE hr;

-- 1. SELF JOIN을 사용하여 'Oliver' 사원의 부서명, 그 사원과 동일한 부서에서
-- 근무하는 동료 사원의 이름을 조회. 단, 각 열의 별칭은 부서명, 동료로 할 것.
SELECT d.department_name AS "부서명", e2.first_name AS "동료"
FROM employees e1
JOIN employees e2 ON e1.department_id = e2.department_id
JOIN departments d ON e1.department_id = d.department_id
WHERE e1.first_name = 'Oliver'
  AND e2.first_name != 'Oliver';


-- 2. 사원번호가 109인 사원보다 급여가 많은 사원을 표시(사원이름과 담당) 조회하시오.



-- 3. 최소 급여를 받는 직원과 같은 급여를 받는 사원의 이름, 담당업무명, 급여를 조회하시오.
-- (그룹함수 사용 + 서브쿼리 + 조인)

-- 9. SELF JOIN을 사용하여 'Oliver' 사원의 부서명, 그 사원과 동일한 부서에서
-- 근무하는 동료 사원의 이름을 조회. 단, 각 열의 별칭은 부서명, 동료로 할 것. (서브쿼리로!)
SELECT d.department_name AS "부서명", e.first_name AS "동료"
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE e.department_id = (SELECT department_id
  						 FROM employees
  						 WHERE first_name = 'Oliver')
  AND e.first_name != 'Oliver';



-- 4. 전체 평균 급여보다 적은 급여를 받은 사원들의 담당 업무를 찾아 담당업무(JOB_ID)와 급여를 조회하시오.

-- 5. 담당 업무가 IT_PROG인 사원보다 급여가 적으면서 업무가 IT_PROG가 아닌 사원들을 조회(사원번호, 이름, 담당업무) 하시오

-- 6. 성이 'Chen'과 동일한 부서에 있는 사원의 이름과 입사일을 조회하시오

-- 7. 급여가 평균 급여보다 많은 사원들의 사원번호와 이름을 표시하되 결과를 급여에 대해 오름차순으로 정렬하시오

-- 8. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원번호와 이름을 표시하는 질의를 작성하시오

-- 9. 평균 급여보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원번호, 이름, 급여를 조회하시오.







 



