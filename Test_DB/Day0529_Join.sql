/* JOIN *
 * 
 * 1) Cross Join (A x B) 
 * 2) Inner Join
 * 	  : 서로 관계를 맺고 있는 둘 이상의 테이블들로부터 데이터를 조회
 * 	  : FK값이 NULL인 경우에는 조회 대상에서 제외된다.
 *	  : inner 키워드 생략 가능
 *
 * 3) Outer Join
 * 	  : FK값이 NULL인 경우에도 조회
 * 	  : LEFT OUTER JOIN, RIGHT OUTER JOIN 
 * 	  : outer 키워드 생략 가능
 * 
 * 4) Self Join
 * 	  : 하나의 테이블 안에 PK, FK를 같이 가지고 있는 경우
 * 
 */

USE hr;

DESC employees;
DESC departments;

SELECT * FROM employees;		-- 107 (fk : employee_id)   
SELECT * FROM departments;		-- 27  (pk : department_id)

-- Cross Join
SELECT *
FROM employees e CROSS JOIN departments d;		-- 테이블에 별칭을 줄 때는 AS를 쓰지 않음 

-- Inner Join (모든 컬럼)
SELECT *
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id;

-- 1) 특정 컬럼만 추출 (이름, 부서명, 업무, 급여) - 급여 순으로 정렬
SELECT e.first_name, d.department_name, e.job_id, e.salary
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
ORDER BY 4;		-- 컬럼명으로 해도 되고, 컬럼 숫자로 해도 됨(4 = salary)

-- 2) 특정 컬럼만 추출 - USING 키워드 사용 (사원번호, 이름, 부서명, 급여)
SELECT 
	e.first_name, d.department_name, e.job_id, e.salary
FROM employees e INNER JOIN departments d
USING (department_id)	-- 비교해야 하는 컬럼명이 동일할 때 사용 -> e. d. 빼고 컬럼명만 적기
ORDER BY 4;	

-- 3) 급여가 5000을 초과하는 직원들의 이름, 급여, 부서명을 조회
 -- JOIN ON 사용
SELECT 
	e.first_name, e.salary, d.department_name
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
WHERE e.salary > 5000;

 -- USING 사용 
SELECT 
	e.first_name, e.salary, d.department_name
FROM employees e INNER JOIN departments d
USING (department_id)
WHERE e.salary > 5000;

-- 4) 부서명과 도시를 조회하시오. (단, 부서장이 없는 부서는 조회에서 제외)
SHOW tables;

SELECT * FROM departments;
SELECT * FROM locations;

SELECT d.department_name, l.city, d.manager_id		-- manager_id 추가해서 NULL 확인 
FROM departments d INNER JOIN locations l			-- INNER 빼고 JOIN으로만 입력해도 무방
USING (location_id)
WHERE d.manager_id IS NOT NULL;

-- [연습문제] 테이블 3개를 조인해보기
-- employees e, departments d, locations l
-- 직원명, 급여, 부서명, 근무하는 도시명을 조회하시오.

SELECT e.first_name, e.salary, d.department_name, l.city
FROM employees e INNER JOIN departments d 
USING (department_id)
INNER JOIN locations l
USING (location_id);

-- [연습문제] 직원명, 급여, 부서명, 근무하는 도시명을 조회하시오. 
-- 조회조건: 급여가 5000 이상
-- 급여의 내림차순
-- employees e, departments d, locations l

SELECT e.first_name, e.salary, d.department_name, l.city
FROM employees e INNER JOIN departments d 
USING (department_id)
INNER JOIN locations l
USING (location_id)
WHERE e.salary >= 5000 
ORDER BY e.salary DESC;

-- [연습문제] 부서명과 부서가 속한 도시와 해당 도시가 있는 나라를 조회하시오. 
--			  manager_id가 없는 부서를 제외하면 11개
--			  manager_id가 없는 부서도 포함하면 27개
SELECT 
	department_name, city, country_name -- 별칭을 붙이지 않아도 무관
FROM departments INNER JOIN locations
USING (location_id)
INNER JOIN countries 
USING (country_id)
WHERE departments.manager_id IS NOT NULL	-- manager_id 포함 여부에 따라 판단
ORDER BY department_name;

-- [연습문제] 부서명과 부서장의 이름, 부서가 속한 도시와 해당 도시가 있는 나라를 조회하시오. 
-- 조회조건: Manager가 없는 부서는 조회 조건에서 제외됨
-- departments의 manager_id와, employees의 employee_id를 비교해야 함
-- FK들끼리 비교하는 게 아니라 FK와 PK를 비교 
-- 11개

-- 핵심 조인 조건
-- 1. departments.manager_id = employees.employee_id → 부서장 연결 (FK vs PK)
-- 2. departments.location_id = locations.location_id → 부서가 위치한 도시 연결
-- 3. locations.country_id = countries.country_id → 도시가 속한 나라 연결

SELECT 
	department_name, first_name, city, country_name
FROM departments d INNER JOIN employees e
ON d.manager_id = e.employee_id 	-- Manager가 없는 부서도 있음
INNER JOIN locations
USING (location_id)
INNER JOIN countries
USING (country_id);

SELECT * FROM departments;

-- Outer Join 연습
-- 문제: 부서명이 없는 직원을 포함하여 직원명, 급여, 부서명을 조회
-- Left outer join
SELECT e.first_name, e.salary, d.department_name 
FROM employees e LEFT OUTER JOIN departments d 
ON e.department_id = d.department_id;

SELECT e.first_name, e.salary, d.department_name 
FROM departments d RIGHT OUTER JOIN employees e		-- 순서가 바뀜에 따라 LEFT, RIGHT 다르게 하기 주의 
USING (department_id);

-- [연습문제] Right Outer Join을 이용해서 부서명과 부서가 위치한 도시, 나라를 조회하시오. 
-- 테이블 관계 구조
-- countries (country_id) ───▶ locations (country_id, location_id) ───▶ departments (location_id)
-- 부서가 최우선 기준이기 때문에 사실상 departments LEFT JOIN locations LEFT JOIN countries와 결과는 동일
SELECT d.department_name, l.city, c.country_name 
FROM hr.countries c 
RIGHT JOIN locations l
USING (country_id)
RIGHT JOIN departments d
USING (location_id);


-- Self Join
-- [문제] 사원번호, 이름, 상관의 사원번호, 상관의 이름을 조회하시오.

SELECT * FROM employees;
-- 출력 결과 예시 : 101 Neena 100 Steven
--					104 Bruce 103 Alexander

SELECT e1.employee_id AS "사원번호", e1.first_name AS "직원명", 
	   e1.manager_id AS "상관의 사원번호", e2.first_name AS "상관의 이름"
FROM employees e1 INNER JOIN employees e2	  -- manager_id를 가진 테이블을 자식, e1이 자식
ON e1.manager_id = e2.employee_id;			  -- USING절 쓸 수 없음
 -- 상관이 없는 사람(manager_id가 없는 사람)은 조회 안 됨

-- [문제] 사원번호, 이름, 상관의 사원번호, 상관의 이름을 조회하시오.
-- Steven King도 조회하시오.

SELECT e1.employee_id AS "사원번호", e1.first_name AS "직원명", 
	   e1.manager_id AS "상관의 사원번호", e2.first_name AS "상관의 이름"
FROM employees e1 LEFT JOIN employees e2	 
ON e1.manager_id = e2.employee_id;	


-- 연습문제

-- 1. JOIN을 이용하여 사원ID가 100번인 사원의 부서번호와 부서이름을 출력하시오.
SELECT e.employee_id, d.department_id, d.department_name
FROM employees e JOIN departments d
USING (department_id)
WHERE e.employee_id = 100;


-- 2. INNER JOIN을 이용하여 사원이름과 함께 그 사원이 소속된 도시이름과 지역명을 출력하시오.
SELECT * FROM locations;

SELECT 
	e.first_name, l.city, r.region_name		-- countries는 조회 조건에는 참여했지만 화면에는 보이지 않음
FROM 
	employees e, departments d, locations l, countries c, regions r	
WHERE e.department_id = d.department_id
	  AND 
	  d.location_id = l.location_id
	  AND 
	  l.country_id = c.country_id
	  AND 
	  c.region_id = r.region_id ; 


-- 3. INNER JOIN과 USING 연산자를 사용하여 100번 부서에 속하는 직원명과 직원의 담당 업무명, 속한 부서의 도시명을 출력하시오.
-- (100번 부서에는 직원 6명있음)
SELECT 
	e.first_name, j.job_title, l.city
FROM 
	employees e, departments d, jobs j, locations l 
WHERE 
	e.department_id = 100
	AND
	e.job_id = j.job_id
	AND
	e.department_id = d.department_id
	AND
	d.location_id = l.location_id;


-- 4. JOIN을 사용하여 커미션을 받는 모든 사원의 이름, 부서ID, 도시명을 출력하시오.
SELECT 
	e.first_name, d.department_id, l.city
FROM 
	employees e
	LEFT OUTER JOIN
	departments d
	ON e.department_id = d.department_id
	LEFT OUTER JOIN locations l
	ON d.location_id = l.location_id
WHERE 
	e.commission_pct IS NOT NULL;


-- 5. INNER JOIN과 와일드카드를 사용하여 이름에 A가 포함된 모든 사원의 이름과 부서명을 출력하시오(단, 대소문자 구분 없음)
SELECT 
	e.first_name, d.department_name
FROM 
	employees e 
INNER JOIN 
	departments d
ON 
	e.department_id = d.department_id
AND e.first_name LIKE '%A%';

 
-- 6. JOIN을 사용하여 Seattle에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오
SELECT 
	e.first_name, j.job_title, e.department_id, d.department_name
FROM 
	employees e INNER JOIN departments d
	USING (department_id)
	JOIN jobs j
	USING (job_id)
	JOIN locations l
	USING (location_id)
WHERE 
	l.city = 'Seattle';


-- 7. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함한 모든 직원을 조회 (사원번호를 기준으로 내림차순 정렬)
SELECT 
	e1.employee_id, e1.first_name AS "직원명",
	e1.manager_id, e2.first_name AS "Manager"
FROM 
	employees e1 LEFT OUTER JOIN employees e2	 
ON 
	e1.manager_id = e2.employee_id;	
ORDER BY 1 DESC;


-- 8. SELF JOIN을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을
--	  매니저 이름 및 입사일과 함께 출력하시오.
SELECT 
	e1.first_name AS "직원명", e1.hire_date AS "직원 입사일",
	e2.first_name AS "관리자", e2.hire_date AS "관리자 입사일"
FROM 
	employees e1 JOIN employees e2	 
ON 
	e1.manager_id = e2.employee_id
AND 
	e1.hire_date < e2.hire_date;


-- 9. Last name이 ‘King’을 Manager로 둔 사원의 이름과 급여를 조회하시오.
SELECT 
	e1.first_name, e1.salary
FROM
	employees e1 JOIN employees e2
ON 
	e1.manager_id = e2.employee_id
WHERE 
	e2.last_name = 'King';
 

-- 10. Finance부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
SELECT 
	e.department_id, e.first_name, j.job_title
FROM employees e JOIN departments d
USING (department_id)
JOIN  jobs j 
USING (job_id)
WHERE d.department_name = 'Finance'; 

/**
 * view 만들기
 */

-- view 생성 
CREATE VIEW emp_view
AS 
	SELECT 
		e.first_name, d.department_name, e.job_id, e.salary
	FROM employees e INNER JOIN departments d
	ON e.department_id = d.department_id
	ORDER BY 4;

-- view 사용
SELECT * FROM emp_view;

/* 함수(Function) 
 *   - 단일행 함수: 모든 레코드에 함수를 적용시켜 결과를 얻는 함수
 * 			조건을 where 절에 부여
 * 	 - 그룹행 함수: 레코드들을 특정 그룹으로 묶어서 처리한 후에 결과를 얻는 함수
 * 			조건을 having 절로 그룹에 부여할 때 주의해야 한다.  
 */

-- (1) 문자열 함수 'Everybody loves the things you do'
SELECT ascii ('A'), char(97) FROM dual; -- DUAL은 dummy 테이블

SELECT concat('Database', ' ', 'MySQL') ;

USE hr;
SELECT concat(first_name, ' ', last_name, '입니다.') AS "Full Name" FROM employees;

-- length(문자열)
SELECT length('Everybody loves the things you do') AS "글자수";

SELECT reverse('Everybody loves the things you do');

SELECT repeat('korea', 10);

SELECT locate('E', 'Everybody loves the things you do');

SELECT insert('I love you!', 3, 4, 'miss');

SELECT locate('you', 'I love you!');
SELECT insert('I love you!', 3, 4, 'me');  -- you -> me 

-- 하나로 합치기
SELECT insert('I love you!', locate('you', 'I love you!'), 3, 'me');

-- substring(문자열, 위치, 개수)
SELECT substring('Everybody loves the things you do', 11, 4) AS "부분문자"

-- 대소문자 변환
SELECT upper('Everybody loves the things you do')
	  ,lower('Everybody loves the things you do');

-- 공백 자르기
SELECT length('    Everybody loves the things you do    '),
	   length(trim('    Everybody loves the things you do    ')),
	   length(ltrim('    Everybody loves the things you do    ')),
	   length(rtrim('    Everybody loves the things you do    '));

SELECT trim(LEADING '~' FROM '~~~~Everybody loves the things you do~~~~'),
	   trim(TRAILING '~' FROM '~~~~Everybody loves the things you do~~~~'),
	   trim(BOTH '~' FROM '~~~~Everybody loves the things you do~~~~');

-- [문제] employees, departments 테이블의 정보를 이용해서 아래와 같이 출력하시오.
--		  부서가 없는 사람의 정보는 제외시킨다. 
/*
 * Steve의 부서는 Administration입니다.
 * xxxx의 부서는 oooo입니다.
 * xxxx의 부서는 oooo입니다.
 */

SELECT
	concat(e.first_name, '의 부서는 ', d.department_name, '입니다.') AS "사원정보"
FROM 
	employees e 
INNER JOIN
	departments d
USING
	(department_id)
ORDER BY first_name;


-- [문제] employees, departments 테이블의 정보를 이용해서 아래와 같이 출력하시오.
--		  부서가 없는 사람의 정보는 제외시킨다. 
/*
 * Steve는 Administration 부서에서 xxxx 일을 합니다.
 * xxx는 xxx 부서에서 oooo일을 합니다.
 * xxx는 xxx 부서에서 oooo일을 합니다.
 */

SELECT
	concat(e.first_name, '는/은 ', d.department_name, ' 부서에서 ', j.job_title, ' 일을 합니다.') AS "사원정보"
FROM 
	employees e 
INNER JOIN
	departments d
USING
	(department_id)
INNER JOIN
	jobs j
USING 
	(job_id)
ORDER BY first_name;

-- (2) 수학 함수
SELECT abs(-45.34), abs(45.34);			-- 절대값

SELECT floor(-45.653), floor(45.653);	-- 음의 방향에서 만나는 첫 번째 정수 값을 반환

SELECT ceil(-45.653), ceil(45.653);		-- 양의 방향에서 만나는 첫 번째 정수 값을 반환

SELECT round(-45.653, 1), round(45.653, 1);			
SELECT round(-45.653, 0), round(45.653, 0);		 	
SELECT round(-45.653, -1), round(45.653, -1);		 

-- truncate: 절삭
SELECT truncate(-45.653, 1), truncate(45.653, 1);	
SELECT truncate(-45.653, 0), truncate(45.653, 0);	
SELECT truncate(-45.653, -1), truncate(45.653, -1);	

-- 최댓값, 최솟값 구하기
SELECT greatest(2, 5, 8, 1), least(2, 5, 8, 1);

-- 파이
SELECT pi();

-- 제곱근
SELECT sqrt(81), pow(2.5, 3), power(3, 2.5);

-- (3) 날짜/시간 함수
SELECT now(), sysdate();

SELECT curdate(), curtime();

SELECT YEAR(now()), MONTH(now()), DAY(now());

SELECT HOUR(now()), MINUTE(now()), SECOND(now());

SELECT date(now()), time(now());

SELECT curdate(), curtime(), date(now()), time(now());	-- 같은 표현

-- datediff(미래날짜, 과거날짜) : 경과일 
SELECT datediff('1950-06-25', '1945-08-15');

-- timediff(미래시간, 과거시간) : 경과시간 
SELECT timediff(curtime(), '10:00:00');

-- [문제] 오늘부터 수료일(8.27)까지 며칠이 남았나요?
-- 출력결과: 오늘부터 수료일까지 90일이 남았습니다.
SELECT concat('오늘부터 수료일까지 ', datediff('2025-08-27', curdate()), '일이 남았습니다.') AS "남은 기간";

-- dayofweek(), monthname(), dayofyear()
SELECT dayofweek(sysdate()), monthname(sysdate()), dayofyear(sysdate());

-- [문제] 경과일과 경과시간을 구하시오.
-- 나는 태어난 지 xx일, 시간은 xx시간이 지났다.
-- timestampdiff(코드, 과거날짜, 미래날짜)
SELECT concat('나는 태어난 지 ', datediff(curdate(), '1996-08-31'), 
			  '일, 시간은 ', timestampdiff(HOUR, '1996-08-31 14:00:00', now()),		-- HOUR, MINUTE, SECOND
			  '시간이 지났다.') AS "태어난 후 경과일, 경과시간";































