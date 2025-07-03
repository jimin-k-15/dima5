2025년 7월 2일 

Friend 정보를 DB에 CRUD하는 프로젝트

- DB에 연동함 (연동 정보: application.properties)
- 4개의 Layer로 구성
  Client, Controller, Service, Repository
- record 타입의 데이터를 이용해 Client --> Controller
- class 타입의 데이터를 이용해 Controller --> Client
- DB와 직접 연동하는 Entity 클래스 사용
- 기본적인 CRUD 모두 가능