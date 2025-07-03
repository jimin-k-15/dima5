'use strict';

/* Number 클래스 : 숫자를 다루는 클래스
    1) 문자열을 숫자로 변경 : Number(), parseInt(), parseFloat()
    2) 최대, 최소값 확인 : MAX_VALUE, MIN-VALUE
*/
console.log('==== Number() ====');
let str = "2.5";
let num = Number(str);
console.log(num, typeof num);  // 2.5, 'number'
console.log(isNaN(str));       // 문자열 포함여부 확인 : true(문자포함), false(숫자로만 구성됨)
console.log(parseInt(str));    // 정수 변환이 가능한가? 가능한 부분까지만 변환
console.log(parseFloat(str));

// NaN은 == 로 비교할 수 없다!
let str2 = "2.5a7";
let num2 = Number(str2);       // NaN로 출력
console.log(num2, typeof num2);
console.log('NaN을 ==으로 비교 안 됨!' + Number(str2) == NaN);  // 하지 마시오!
console.log(parseInt(str2));

console.log("============");
let str3 = ".25E5";
console.log(`${str3}을 parseInt()한 결과 : ${parseInt(str3)}`);      // NaN
console.log(`${str3}을 parseFloat()한 결과 : ${parseFloat(str3)}`);  // 0.25 * 10^5 = 25000

// 자바스크립트의 최대, 최소값 확인
console.log(`숫자 최대: ${Number.MAX_VALUE}`);
console.log(`숫자 최소: ${Number.MIN_VALUE}`);