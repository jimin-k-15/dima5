2025년 6월 25일

피트니스 회원관리 프로그램
: 8999로 포트번호 변환

- 포트번호 : resources 폴더 
  - application.properties
  - application.yml (야물) - 
   
  1~1024까지는 이미 사용처가 정해져 있음 (well known port)
  80 포트 : http에서 점유한 포트
  
  예) http://www.naver.com:80
  	  http://localhost:8080

DTO (FitnessDTO)
  이름(name), 성별(gender), 키(height), 몸무게(weight)
  
Controller
1) MainController
2) FitnessController
   - fitnessInsert() - post
   - fitnessProc()
   
3) html 파일
   - index.html
   - fitnessInsert.html
   - fitnessResult.html
   
4) static (정적파일)
   /images
   /css
   /js
