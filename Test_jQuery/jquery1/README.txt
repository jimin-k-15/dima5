2025년 7월 7일 

jQuery를 이용해 Front단 제어하는 방법

1) javascript를 DOM에 접근해서 처리하기 조금 어려웠었다! 
   --> 쉽게 개선하기 위한 JS Library이다. 
   
2) www.jquery.com에서 라이브러리 다운로드

3) jQuery 기초 문법
- 모든 문법이 전부 function이다!
- 자바스크립트 함수 중 
  window.adddEventListener('load', function() {});
  : 문서가 로드 완료(html, css, java)되면 함수를 실행함.
  
- jQuery에서는
  jQuery.function() {} 표현과 동일
  : 문서가 준비(html)되면 함수를 실행함. 
  : jQuery 키워드를 $로 대체함
  
- 기본적인 JS 코어 문법은 동일. DOM에 접근하는 방법만 다름

- DOM에 접근하는 방법은 CSS 선택자를 통해서! 

document.getElementById("name");
$("#name");						 --> 위 코드와 아래 코드 동일
  
4) 실행하기
  : 라이브러리를 문서에 등록하기
  <script defer src="@{/js/jquery-3.7.1.min.js}"></script>
  <script> 코드 </script> 
  
5) jQuery 특정 메소드 반환 타입
   - 값: 
   - jQuery가 반환되면 method chaining이 가능
   - 