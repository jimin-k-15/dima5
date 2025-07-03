<프로젝트>

1. 여러 명의 피트니스 회원을 관리하기 위해 
   ArrayList를 사용 (max는 100)
2. vo, ui, main, service로 나누어 처리
	1) vo: 회원 1명을 관리할 수 있는 Value 객체 + toString() + equals()
	2) ui: 이 프로젝트를 사용하는 사용자의 입출력을 위한 클래스 + Exception 추가
	3) service: ArrayList를 관리하고 ui로부터 데이터를 전달받아서 ArrayList 내에 데이터를 CRUD
	   interface 추가 

3. 주요 작업 : CRUD + Read All(전체회원 조회) + 현재 회원수(getCount) 

4. 구동: 
	main --> ui(print, keyin) ---(vo)---> service(ArrayList)