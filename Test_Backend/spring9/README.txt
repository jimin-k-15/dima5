2025년 7월 9일-

1) 테이블 생성
- 사용자
  userid		PK
  userpwd		NN (암호화)
  username		NN
  
- 게시판
  seq 			PK
  글제목		
  글내용
  글쓴이
  조회수
  작성일
  원본파일명
  저장파일명
  
- 댓글
  일련번호		PK
  댓글내용		NN
  글쓴이
  작성일		오늘날짜
  게시글번호	FK on delete cascade
  
2) resources 폴더 하위에 아래의 3 폴더 생성
   images - logo.png
   css
   js - jquery=3.7.1.js 파일을 위치시킨다.
     
3) 패키지 생성
- controller
- service
- repository
- dto
- entity

4) application.properties
DB 연동을 위한 코드

5) MainController