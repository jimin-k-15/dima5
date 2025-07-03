-- DB(MySQL) 평가

-- 1. 제약조건 6개를 쓰시오.
-- PK, FK, NN, UNIQUE, CHECK, DEFAULT

-- 2. CREATE 명령을 이용해 사용자 "dima_user"의 비밀번호를 "dima2025"를 생성하는 코드를 쓰시오.
CREATE USER 'dimauser'@'localhost' identified BY 'dima2025';

-- 3. 트랜잭션을 처리하는 가장 중요한 2개의 명령어는 무엇인가?
-- COMMIT, ROLLBACK


USE hr;
-- 4. 부서 코드가 50, 80, 100 중의 하나이면서 
-- 급여가 7000이상, 8000이하인 사원들의 이름, 급여, 부서번호를 출력하시오.
SELECT first_name, last_name, salary, department_id
FROM employees 
WHERE department_id IN (50, 80, 100) 
AND (salary BETWEEN 7000 AND 8000);

-- 5. 프로그램 실행 날짜를 기준으로 근무한 기간이 18년 미만인 사원들의 이름과 입사일을 
-- 입사일 기준으로 오름차순하여 출력하시오. 
SELECT first_name, last_name, hire_date
FROM employees
WHERE datediff(now(), hire_date) / 365 < 18
ORDER BY 3;

-- 6. 사원별로 이름과, 성, 급여, 부서 번호 및 자신 부서의 평균 급여를 
-- 부서별 오름차순으로 조회하시오. 
-- (단, 부서 평균 급여보다 급여가 많은 직원만 조회되어야 하며  
-- 평균 급여는 소수점 2 자리까지 출력)
SELECT first_name "이름", last_name "성", salary "급여", department_id "부서번호", 
	   avgsal "부서 평균 급여"
FROM employees join
	(SELECT department_id, round(avg(salary), 2) AS avgsal
	FROM employees
	GROUP BY department_id) tbl
USING (department_id)
WHERE salary > tbl.avgsal 
ORDER BY 4;

-- 7. JOB_HISTORY, JOBS 테이블 사용하여 사원 번호, 업무 기간, 업무 명이 출력 되도록 하시오.
-- 업무 기간은 올림으로 처리하시오
SELECT j.employee_id "사원번호"
	   , concat(timestampdiff(MONTH, j.start_date, j.end_date), '개월') "업무기간"
	   , js.job_title "업무명"
FROM job_history j JOIN jobs js
USING (job_id);

-- 8. 2025년 한 해가 오늘을 기준으로 몇 일 남았는지 출력하는 SQL문장을 작성하시오.
-- (아래의 처리 결과와 다를 수 있으며 참고만 할 것)
SELECT datediff('2025-12-31', now()) AS "남은일수";

-- 9. Subquery를 사용하여 각 부서별 평균근무일을 다음과 같이 조회하시오.
SELECT 
	d.department_name "부서명", round(avg(datediff(sysdate(), e.hire_date))) "평균근무일"
FROM employees e JOIN departments d
USING (department_id) 
GROUP BY d.department_name
ORDER BY 1 DESC;

-- 10. Employees 테이블에서 매니저가 같은 사원들의 평균급여가 4000이상인 사원의 
-- 평균급여, 최대급여, 최소급여를 그림과 같이 출력하시오. 
-- 단, 매니저번호가 없는 사원은 0번으로 출력하고, 평균급여는 소수점 이하 올림하시오.
SELECT 
	ifnull(manager_id, 0) "매니저 번호", 
	ceil(avg(salary)) "평균급여",
	max(salary) "최대급여",
	min(salary) "최소급여"
FROM employees
GROUP BY manager_id
HAVING ceil(avg(salary)) >= 4000
ORDER BY 1;

-- 11. 각 부서별로 해당 부서의 급여 평균 미만의 급여를 수령하는 직원 명단을 조회하시오
-- (조회 컬럼: 사원번호, 이름, 부서명, 급여)
-- 부서명 오름차순 정렬할 것
SELECT
	e.employee_id, e.first_name, d.department_name, e.salary
FROM employees e JOIN departments d
USING (department_id)
WHERE salary < (SELECT avg(salary) FROM employees e1
				WHERE e1.department_id = e.department_id
				HAVING count(department_name) != 1)
				ORDER BY 3;

-- 12. 날짜관련 함수를 이용하여 
-- 입사일이 3월인 모든 사원의 정보를 출력하시오. ( LIKE 연산자 사용하면 안됨)
SELECT first_name, last_name, hire_date, job_id FROM employees
WHERE month(hire_date) = 3;



USE world;
-- 13. 나라명 대한민국('KOR') 의 도시중 도시명이 'Kwangju'의 인구수가 
-- 대한민국 전체 인구 수의 몇 퍼센트를 차지하는지 구하시오.
SELECT 
	co.name "국가", co.population "총인구수", 
	ci.name "도시", ci.population "도시 인구수",
	concat((ci.population / co.population * 100), '%') "인구비율"
FROM country co, city ci
WHERE co.code = ci.countrycode
AND co.code = 'KOR'
AND ci.name = 'Kwangju';

-- 14. country, city 테이블을 조인하여 국가 이름, 도시 수를 출력하는 쿼리를 작성하시오.
SELECT 
	co.name "국가명",
	count(ci.id) AS "도시수"
FROM country co, city ci
WHERE co.code = ci.countrycode
GROUP BY ci.countrycode;

-- 15. 각 국가별로 전체 도시 인구 수 평균을 넘는 도시 목록을 출력하는 쿼리를 작성하시오
SELECT name, population FROM city
WHERE population > (SELECT avg(population) FROM city);



-- 16. 테이블의 생성
USE dima5;ddddddddddddddddddddddddddddddddddddddd
CREATE TABLE Categories 
(
	CATEGORY_ID CHAR(7) PRIMARY KEY 
		CHECK (CATEGORY_ID IN ('WR_PROD', 'PA_PROD', 'AR_PROD', 'ME_PROD', 'ET_PROD')),
	CATEGORY_NAME VARCHAR(30) UNIQUE 
		CHECK (CATEGORY_NAME IN ('필기구', '종이류', '미술용품', '측정용품', '기타')),
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
	CATEGORY_ID char(7) REFERENCES categories(category_id)
);

-- 18. 테이블의 생성
CREATE TABLE Stock
(
	STOCK_ID int PRIMARY KEY AUTO_INCREMENT,
	PROD_ID int REFERENCES products(prod_id) ON DELETE CASCADE, 
	RECEIVE_DATE datetime,
	FORWARD_DATE datetime DEFAULT CURRENT_TIMESTAMP,
	UNIT_PRICE decimal(10, 2) DEFAULT 0,
	TOTAL_STOCK decimal(7) DEFAULT 0
);

-- 19. 위에서 생성한 Product 테이블에 
-- 'Bigo' 라는 이름의 컬럼을 'making_date' 컬럼뒤에 추가하는 명령을 쓰시오
-- * 컬럼명 : BIGO - 가변길이문자열 200
ALTER TABLE Products
ADD BIGO varchar(200) AFTER MAKING_DATE;


-- 20. 부모 테이블의 데이터가 기본키가 수정되면
-- 자식 테이블의 FK도 함께 수정되도록 하는 키워드는? 
-- ON UPDATE CASCADE  



-- 종합실습과제 : 아이돌 관리 테이블 설계하기
/*
 * [문제]
 * 아이돌 그룹과 팬클럽, 그리고 그룹 소속사를 관리하는 데이터베이스를 설계하려고 한다.
 * 필요하다고 판단되는 모든 테이블과 컬럼을 ERD로 그리고, 코드 설계하시오. *
 * 조건) 'idol' 이라는 이름의 데이터베이스를 생성한 후 작업을 하시오
 * [ 필수 테이블 ] 소속사, 아이돌그룹, 아이돌 멤버, 팬클럽
 *
 * [ 옵션 ] 추가적으로 필요하다고 판단되는 테이블은 추가할 수 있다.
*/

CREATE DATABASE idol;
USE idol;

DROP TABLE ido.IDOL_FAN_CLUB		-- 팬클럽
DROP TABLE ido.IDOL_IDOL_MEMBER		-- 아이돌 멤버
DROP TABLE ido.IDOL_TEAM			-- 아이돌
DROP TABLE ido.IDOL_AGENCY			-- 소속사









