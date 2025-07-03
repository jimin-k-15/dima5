-- hr 스키마의 데이터를 이용하여 아래 주어진 문제를 해결하시오.  
-- 힌트로 제공된 이미지가 있을 경우 참고
USE hr;

-- 1. 보너스 (급여 * 커미션 비율)를 계산하여 
--	  사원번호, 이름, 급여, 커미션 비율, 보너스금액을 
-- 	  사원번호 순으로 출력한다. 
-- 	  해당 사항 없는 영업부 이외의 사원은 0으로 처리한다.
SELECT employee_id, first_name, last_name, salary, commission_pct, 
	   salary * ifnull(commission_pct, 0)
FROM employees ORDER BY employee_id;

-- 2. 모든 사원들의 이름과 소속 부서명을 다음과 같이 출력하시오. (SUBQUERY 사용) 
SELECT concat(first_name, ' ', last_name) 이름,
	   (SELECT department_name FROM departments d
	    WHERE d.department_id = e.department_id) 부서
FROM employees e;

-- 3. 각 국가명과 속한 지역명을 다음과 같이 출력하시오. (SUBQUERY 사용) 
SELECT c.country_name 국가명, 
		(SELECT r.region_name FROM regions r WHERE r.region_id = c.region_id) 지역명
FROM countries c;

-- 4. 2007년 11월 1일 ~ 2008년 2월 10일 사이에 입사한 사원들의 모든 정보를 출력하시오. 
SELECT * FROM employees
WHERE hire_date >= '2007-11-1' AND hire_date < '2008-2-11';

-- 5. 커미션 비율이 NULL이 아닌 사람들 중 급여가 10000 이상인 사원들의 모든 정보를 출력하시오.
SELECT * FROM employees WHERE commission_pct IS NOT NULL AND salary >= 10000;

-- 6. 부서 코드가 50, 80, 100 중 하나이면서 급여가 7000~8000인 사원들의 모든 정보를 출력하시오.
SELECT * FROM employees
WHERE department_id IN (50, 80, 100)
AND salary BETWEEN 7000 AND 8000;

-- 7. 국가명과 지역명을 다음과 같이 정렬하여 출력하시오. (JOIN과 SUBQUERY 2가지 방법 모두)
-- 1) Inner Join
SELECT region_name, country_name
FROM regions, countries
WHERE regions.region_id = countries.region_id
ORDER BY region_name, country_name;

-- 2) Subquery
SELECT
	(SELECT region_name FROM regions
	 WHERE regions.region_id = countries.region_id) region_name, country_name 
FROM countries
ORDER BY region_name, country_name;


-- 8.  REGIONS 테이블의 각 지역별로 COUNTRIES 테이블에 등록된 국가의 수를 다음과 같이 출력하시오.
SELECT region_name 지역, count(*) 국가수
FROM regions r INNER JOIN countries c
ON r.region_id = c.region_id
GROUP BY region_name
ORDER BY region_name;


-- 9. 모든 도시의 이름을 속한 국가와 지역의 이름과 함께 도시명 순으로 정렬하여 출력하시오.
SELECT city, country_name, region_name
FROM locations l JOIN countries c
ON l.country_id = c.country_id
JOIN regions r
ON c.region_id = r.region_id
ORDER BY city;


-- 10. 국가별 부서의 총 개수를 다음과 같이 출력하시오. 
SELECT c.country_name, count(*)
FROM departments d JOIN locations l
ON d.location_id = l.location_id
JOIN countries c
ON l.country_id = c.country_id
GROUP BY c.country_name;


-- 11. 도시별 사원수를 출력하시오.
SELECT l.city, count(*)
FROM employees e JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
GROUP BY l.city
ORDER BY l.city;


-- 12. 도시별 사원의 급여 평균을 출력하시오. 
SELECT l.city, avg(salary)
FROM employees e JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
GROUP BY l.city
ORDER BY l.city;


-- 13. 사원수가 3명 이상인 부서의 이름과 사원수, 그 부서의 평균급여를 출력하시오.
SELECT d.department_name 부서명, count(*) 사원수, avg(salary) 평균급여
FROM employees e JOIN departments d
ON e.department_id = d.department_id
GROUP BY d.department_name
HAVING count(*) >= 3;


-- 14. 각 사원들의 관리자 이름을 다음과 같이 출력하시오.
SELECT tbl.* FROM 
	(SELECT employee_id "사번", first_name "이름", last_name "성",
			(SELECT e2.last_name
			 FROM employees e2
		 	 WHERE e1.manager_id = e2.employee_id) AS "관리자"
	FROM employees e1
	ORDER BY 4) tbl
WHERE 관리자 LIKE 'Cam%';





