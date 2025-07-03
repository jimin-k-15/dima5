'use strict';

/* 자바스크립트로 문서에 접근하기 */

// 1) getElementById('id값')
console.log('==== getElementById() ====')
let writer = document.getElementById('writer');
console.log(writer);                    // 요소(Element)를 반환: <h3 id="writer">김춘수</h3>

// 2) getElementsByTagName('tag명')
console.log('==== getElementsByTagName() ====')
let tags = document.getElementsByTagName('p');
console.log(tags);                    // 배열 반환: [p, p, p.poem, p.poem, p.poem]
console.log(tags.length);
console.log(tags[0]);

// 3) getElementsByClassName('class명') : 's'주의
console.log('==== getElementsByClassName() ====')
let poems = document.getElementsByClassName('poem');
console.log(poems.length);
console.log(poems[poems.length - 1]);

// 4) querySelector("CSS 선택자")
//  선택자의 맞는 데이터가 여러 개일 경우 첫번째 1개만 반환
console.log('==== querySelector() ====')
let poems2 = document.querySelector(".poem"); // 요소 1개만 반환하므로 length 사용X(undefined)
console.log(poems2);                          // 첫번째 poem요소 가져옴

// 5) querySelectorAll("CSS 선택자")
//  선택자의 맞는 데이터가 여러 개일 경우 전체 데이터 반환
//  - getElementsByClassName(): HTMLCollections 타입으로 반환
//  - querySelectorAll(): nodeList 타입으로 반환
// 차이점은 있지만 교수님은 혼용해서 사용하신대 ~

console.log('==== querySelectorAll() ====')
let poems3 = document.querySelectorAll(".poem");
console.log(poems3.length);                  // 3
console.log(poems3[0]);                      // 첫번째 시 구절

// style 접근하기 (CSS)
// RV는 문자열로 줘야함!
poems3[0].style.color = 'red';
poems3[1].style.backgroundColor = 'lightblue';

// 6) 태그가 가지고 있는 속성에 접근
//  속성값 가져오기: getAttribute("속성명")
//  속성값 바꾸기: setAttribute("속성명", "값")
console.log('==== getAttribute() ====')
let src = document.getElementById('image').getAttribute("src") // 태그를 가져온 후 속성 가져오기
console.log(`이미지의 src값: ${src}`);                      // ./images/flowers.jpg

let alt = document.getElementById('image').getAttribute("alt")
console.log(`이미지의 alt값: ${alt}`);                      // 꽃


console.log('==== setAttribute() ====')
// 태그만 이벤트를 걸 수 있고, 이벤트를 거는 함수는 addEventListener
// 이벤트 소스: 버튼
document.getElementById('change').addEventListener('click', () => {
    // 그림을 가져오기 > 속성 바꾸기 (//html입장(현재 문서)에서 images 디렉토리에 접근해야 함 ./)
    document.getElementById('image').setAttribute('src', './images/flowers2.jpg')
})

// 이벤트 소스: 이미지
// mouseenter: 이미지 위에 마우스를 올리면 그림이 바뀜
document.getElementById('image').addEventListener('mouseenter', () => {
    document.getElementById('image').setAttribute('src', './images/flowers2.jpg')
})