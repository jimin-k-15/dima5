'use strict';

/* Math클래스는 수학과 관련된 메소드를 제공
    1) 값 : PI(원주율), E(오일러 상수)
        Math.PI, Math.E와 같이 자바의 static 데이터 사용하는 것과 동일

    2) 메소드
*/
console.log('==== 상수의 사용 : PI, E ====');
console.log(`원주율 : ${Math.PI}`);
console.log(`오일러상수 : ${Math.E}`);

// abs(n) : 절대값 반환(Falsy, Truthy: MDN 사이트에서 확인해야 함)
console.log('==== abs() ====');
console.log(Math.abs(-1));            // 1
console.log(Math.abs('-2'));          // 2 (자동 파싱)
console.log(Math.abs(undefined));     // NaN
console.log(Math.abs(null));          // 0 (Falsy 값)
console.log(Math.abs(''));            // 0
console.log(Math.abs(' '));           // 0
console.log(Math.abs('Korea'));       // NaN
console.log(Math.abs([]));            // 0
console.log(Math.abs([1, 2, 3]));     // NaN

// ceil(n) : 올림. 주어진 n 값의 양의 방향으로 이동했을 때 만나는 첫번째 정수
console.log('==== ceil() ====');
console.log(Math.ceil(0.95));          // 1
console.log(Math.ceil(5.00000001));    // 6
console.log(Math.ceil(5));             // 5
console.log(Math.ceil((-0.95)));       // -0     // -0.0, 0.0 (IEE754)
console.log(0 == -0);                  // true
console.log(Math.ceil(-5.00000001));   // -5

// floor(n) : 버림. 주어진 n 값의 음의 방향으로 이동했을 때 만나는 첫번째 정수
console.log('==== floor() ====');
console.log(Math.floor(0.95));          // 0
console.log(Math.floor(5.00000001));    // 5
console.log(Math.floor(5));             // 5
console.log(Math.floor((-0.95)));       // -1     
console.log(Math.floor(-5.00000001));   // -6

// trunc(n) : 절삭
console.log('==== trunc() ====');
console.log(Math.trunc(0.95));          // 0
console.log(Math.trunc(5.00000001));    // 5
console.log(Math.trunc(5));             // 5
console.log(Math.trunc((-0.95)));       // -0    
console.log(Math.trunc(-5.00000001));   // -5

// round(n) : 반올림(주의: 소수점 이하 자릿수를 제어할 수 없다.)
console.log('==== round() ====');
console.log(Math.round(0.95));          // 1
console.log(Math.round(5.00000001));    // 5
console.log(Math.round(5));             // 5
console.log(Math.trunc((-0.95)));       // -0    
console.log(Math.trunc(-5.00000001));   // -5

// 참고 : 0으로 나누기. 나누기를 할 때 실수 연산
console.log("==== Infinity ====");
console.log(0 / 0);     // NaN
console.log(10 / 0);    // Infinity(양의 무한대)
console.log(10 / -0);    // Infinity(음의 무한대)

console.log("==== min(), max() ====");
console.log(Math.min(1, 5, 3));     // 1
console.log(Math.min(-1, -5, -3));  // -5
console.log(Math.min());            // Infinity
console.log(Math.min(-0.93));       // -0.93

console.log(Math.max(1, 5, 3));     // 5
console.log(Math.max(-1, -5, -3));  // -1
console.log(Math.max([-1, -5, -3]));// 배열은 구할 수 없다. NaN
console.log(Math.max());            // -Infinity
console.log(Math.max(-0.93));       // -0.93

// [문제] random() 함수를 이용해서 0~50 사이의 난수 10개를 발생시켜서 배열에 넣는다. 
// 배열 내의 데이터에서 최대값, 최소값을 구하여 출력하시오.
let data = [];

for (let i = 0; i < 10; ++i) {
    data.push(Math.floor(Math.random() * 51));
}
console.log(`원본 배열 : ${data}`);
console.log(`최댓값 : ${Math.max(...data)}`);
console.log(`최솟값 : ${Math.min(...data)}`);
console.log(`정렬 : ${data.sort()}`); // 자릿수가 맞지 않으면 안 됨.(x)
console.log(`정렬 : ${data.sort((x, y) => x - y)}`); // 전달인자로 콜백함수를 사용 (o)

console.log("==== pow(n1, n2) : n1 ^ n2 ====");
console.log(Math.pow(5, 3));    // 125
console.log(5 ** 3);            // 125
console.log(Math.pow(4, 0.5));  // 2
console.log(4 ** 0.5);          // 2
console.log(Math.pow(4, -2));   // 0.0625
console.log(4 ** -2);           // 0.0625

console.log(Math.pow(-5, 3));    // -125
console.log((-5) ** 3);          // -125
console.log(Math.pow(-4, -2));   // 0.0625
console.log(Math.pow(-4, -0.5));   // NaN

console.log("==== random() : 0~1 ====");

// toFixed(n): 소수 이하 자릿수 제어
console.log("==== toFixed(n) ====");
let number = Math.random();
console.log(`발생 값 : ${number}`);
console.log(`소수 이하 2자리 : ${number.toFixed(2)}`);
console.log(`소수 이하 4자리 : ${number.toFixed(4)}`);