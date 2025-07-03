-- 종합실습: 아이돌 관리 테이블 설계하기

/*
 * [문제]
 * 아이돌 그룹과 팬클럽, 그리고 그룹 소속사를 관리하는 데이터베이스를 설계하려고 한다.
 * 필요하다고 판단되는 모든 테이블과 컬럼을 ERD로 그리고, 코드 설계하시오. *
 * 조건) 'idol' 이라는 이름의 데이터베이스를 생성한 후 작업을 하시오
 * [ 필수 테이블 ] 소속사, 아이돌그룹, 아이돌 멤버, 팬클럽
 *
 * [ 옵션 ] 추가적으로 필요하다고 판단되는 테이블은 추가할 수 있다.
*/


-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS idol;
USE idol;

-- 소속사 테이블
CREATE TABLE agency (
    agency_id INT AUTO_INCREMENT PRIMARY KEY,
    agency_name VARCHAR(100) NOT NULL,
    founded_year YEAR,
    ceo VARCHAR(100)
);

-- 아이돌 그룹 테이블
CREATE TABLE idol_group (
    group_id INT AUTO_INCREMENT PRIMARY KEY,
    group_name VARCHAR(100) NOT NULL,
    debut_date DATE,
    agency_id INT,
    FOREIGN KEY (agency_id) REFERENCES agency(agency_id)
);

-- 아이돌 멤버 테이블
CREATE TABLE idol_member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    member_name VARCHAR(100) NOT NULL,
    birthdate DATE,
    member_role VARCHAR(50),
    group_id INT,
    FOREIGN KEY (group_id) REFERENCES idol_group(group_id)
);

-- 팬클럽 테이블
CREATE TABLE fanclub (
    fanclub_id INT AUTO_INCREMENT PRIMARY KEY,
    fanclub_name VARCHAR(100) NOT NULL,
    founding_year YEAR,
    official_color VARCHAR(50), 
    group_id INT UNIQUE,
    FOREIGN KEY (group_id) REFERENCES idol_group(group_id)
);

-- 데이터 삽입
INSERT INTO agency (agency_name, founded_year, ceo)
VALUES 
('SM', 1995, '이수만'),
('JYP', 1996, '박진영'),
('하이브', 2005, '방시혁');

INSERT INTO idol_group (group_name, debut_date, agency_id)
VALUES 
('라이즈', '2023-09-04', 1),
('데이식스', '2015-09-07', 2),
('엔믹스', '2022-02-22', 2),
('투모로우바이투게더', '2019-03-04', 3);

INSERT INTO idol_member (member_name, birthdate, member_role, group_id)
VALUES 
('앤톤', '2004-03-21', '보컬', 1),
('성진', '1993-01-16', '리더', 2),
('해원', '2003-02-25', '리더', 3),
('수빈', '2000-12-05', '리더', 4);

INSERT INTO fanclub (fanclub_name, founding_year, official_color, group_id)
VALUES 
('브리즈', 2023, '파스텔블루', 1),
('마이데이', 2015, '민트', 2),
('엔써', 2022, '라이트그린', 3),
('모아', 2019, '하늘색', 4);

-- 데이터 확인
SELECT * FROM agency;
SELECT * FROM idol_group;
SELECT * FROM idol_member;
SELECT * FROM fanclub;

SHOW tables;















