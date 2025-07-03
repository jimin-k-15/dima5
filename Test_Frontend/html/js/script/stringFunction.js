'use strict';

/* 문자열 관련 메소드
    : 문자열의 특징 = sequence 데이터이면서 immutable한 타입이다. 

    1) 문자열.charAt(index), at(index) : index 위치에 있는 하나의 문자!를 반환
    2) 문자열.startsWith(부분문자열), endsWith(부분문자열), includes(문자열), search(문자열)
        : 특정 (부분) 문자열로 시작하는지, 끝나는지, 포함되어 있는지. 문자열의 위치
    3) 문자열.replace(문1, 문2): 문1을 찾아 문2로 수정
    4) slice(index1, index2) : 1~2까지의 부분문자열 반환 
        (substring() 함수는 ES5 이후 사용을 권장하지 않음)
    5) trim() : 공백 삭제
    6) 문자열.split(구분자) : 문자열을 구분자 단위로 쪼갠 후 배열로 반환
*/
console.log("==== charAt(), at() ====");
let data = "abcdefg";

console.log(data.charAt(3));
console.log(data.at(3));

console.log("==== search(), startsWith(), endsWith(), includes() ====");
data = 'Hello, World! Welcome to the Javascript World!';
console.log(data.startsWith('Hello'));  // boolean으로 반환
console.log(data.endsWith('!'));        // boolean으로 반환
console.log(data.includes('World'));    // boolean으로 반환
console.log(data.includes('earth'));    // boolean으로 반환

console.log(data.search('World'));      // 찾은 글자의 첫번째 인덱스 반환 (7)
console.log(data.search('earth'));      // 찾는 글자가 없으면 -1 반환 (-1)

console.log("==== replace() ====");
data = 'Hello, everyone!';
let temp = data.replace('Hello', 'Hi');
console.log('원본: ' + data);
console.log('수정: ' + temp);

console.log("==== slice(m, n) ====");
let tmp = data.slice(4, 8);
console.log(tmp);    // o, e
console.log(data.slice(-5, -1));  // yone

// 주의할 것: 앞 < 뒤, 만약 앞 > 뒤 일 경우 에러도 없고, 데이터도 없다!
console.log(data.slice(8, 4));
console.log(data.slice(-1, -5));

console.log("==== trim() ====");
let user = ' 홍길동 ';
console.log(user + " , " + user.length);
console.log(user.trim() + " , " + user.trim().length);

console.log("==== split() ====");
let party = '풍선:2000 / 케익:45000 / 선물:120000';

// 문제 : 파티에서 사용한 총 비용을 계산하면?
// parseInt(문자열)   => 정수형 숫자로 변경
// parseFloat(문자열) => 실수형 숫자로 변경
let p = party.split(" / ");
console.log(p);     // 배열 3개로 반환
let totalFee = 0;

p.forEach((x) => {
    totalFee += parseInt(x.split(":")[1]);  // 숫자 + 문자열 => 문자열
});
console.log(`총 파티비용: ${totalFee}원`);

/*
alert(경고문구) => modal 창을 더 많이 사용함
confirm()
prompt()
isNaN()
parseInt()
parseFloat()
*/