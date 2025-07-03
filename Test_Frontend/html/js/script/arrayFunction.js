'use strict';

/* 배열과 관련된 함수의 종류
    1) 배열.join("") : 배열을 문자열로 합치는 메소드
    2) 배열.reverse() : 원본 데이터를 뒤집음
    3) 배열.slice(시작idx, 끝idx) : 원본은 그대로 두고, 부분 배열을 가져옴
    4) 배열.splice(idx j) : 원본을 수정하면서, 부분 배열을 가져옴 
    5) sort() : 배열 요소를 정렬
    6) concat() : 두 개 이상의 배열을 연결
    7) push(), pop() : 배열을 스택 자료구조처럼 다루는 메소드
    8) unshift(), shift() : 배열을 뒤집힌 스택 자료구조처럼 다루는 메소드
    9) toString() 
    10) map() : 원본은 그대로 두고 배열 내의 각 요소의 값을 변환
    11) filter() : 원본은 그대로 두고 배열 내의 각 요소 중 
        특정 조건에 만족하는 요소만 필터링하여 반환 (앞 코드 참고)
    12) indexOf()
    13) includes()
    14) flatMap()
    ※ delete 명령은 메모리에서 데이터를 삭제
*/

let ary = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(ary.join("/"));

// console.log(ary.reverse());

let temp = ary.slice(1, 5);     // 1번 인덱스 ~ 5-1인덱스까지
console.log(`슬라이스된 배열 : ${temp}`);
console.log(`원본 배열 : ${ary}`);

temp = ary.slice(0, -2);
console.log(`음수로 슬라이스된 배열 : ${temp}`);  // [1, 2, 3, 4, 5, 6, 7, 8]

// splice(i)
let color = ['빨', '주', '노', '초', '파', '남', '보'];
temp = color.splice(4);  // 4번 인덱스 ~ 끝 
console.log(`스플라이스된 배열 : ${temp}`);
console.log(`원본 배열 : ${color}`);

// splice(i, n, data...)
color = ['빨', '주', '노', '초', '파', '남', '보'];
color.splice(2, 1, 'Yellow', '노랭이');  // 2번 인덱스 1개를 'Yellow', '노랭이'로 대체
console.log(`스플라이스된 배열 : ${color}`);

// splice(i, n, data...)
color = ['빨', '주', '노', '초', '파', '남', '보'];
color.splice(2, 3, 'Yellow', '노랭이');  // 2번 인덱스 3개를 'Yellow', '노랭이'로 대체
console.log(`스플라이스된 배열 : ${color}`);

// 음수사용 가능!
color = ['빨', '주', '노', '초', '파', '남', '보'];
// == 2번 인덱스와 그 다음 인덱스 사이에 'Yellow', '노랭이'로 대체
// color.splice(2, -1, 'Yellow', '노랭이');

// == 2번, 3번 사이에 '파랭이', '노랭이', 두번째는 반드시 숫자가 와야 함
// color.splice(2, 'Yellow', '파랭이', '노랭이'); 

// == 마지막 위치 1개를 'Yellow', '노랭이'로 대체   
color.splice(-1, 1, 'Yellow', '노랭이');
console.log(`스플라이스된 배열 : ${color}`);

// concat() : 배열을 연결
console.log('==== concat() ====')
let food = ['케이크', '초밥', '빵'];
let drink = ['아메리카노', '아몬드밀크', '루이보스티'];
let fruit = ['오렌지', '무화과', '복숭아', '라즈베리'];

let lunch = food.concat(drink);
console.log(lunch);

lunch = food.concat(drink, fruit);
console.log(lunch);
console.log(lunch.toString());  // 배열요소를 콤마로 연결된 문자열로 반환

// push(), pop(): 배열을 stack처럼 
console.log('==== push(), pop() ====');
food.push("샐러드");
console.log(food);

let data;
while (data = food.pop()) // 데이터를 다 꺼내서 스택이 비어 있으면 undefined == falsy
    console.log('스택에서 꺼낸 데이터 => ' + data);

// unshift(), shift(): 배열을 뒤집힌 스택처럼 
console.log('==== unshift(), shift() ====');
drink = ['아메리카노', '아몬드밀크', '루이보스티'];
data = drink.shift();
console.log('뒤집힌 스택에서 꺼낸 데이터 : ' + data);

drink.unshift('오렌지에이드');
console.log('뒤집힌 스택에서 데이터 : ' + drink);

// sort()
console.log('==== sort() ====');
fruit = ['오렌지', '무화과', '복숭아', '라즈베리'];
fruit.sort();   // 원본을 정렬
console.log('정렬된 데이터 : ' + fruit);

// indexOf()
console.log('==== indexOf(데이터) ====');
fruit = ['오렌지', '무화과', '복숭아', '라즈베리'];
let idx = fruit.indexOf('복숭아');
console.log('복숭아의 인덱스 : ' + idx);
console.log('블루베리의 인덱스 : ' + fruit.indexOf('블루베리')); // 배열 내에 찾을 수 없으면 -1 반환

// delete : 함수는 아님. 사용을 권장하지 않음. 대신 push(), pop() 사용을 권함
console.log('==== delete 명령어 ====');
fruit = ['오렌지', '무화과', '복숭아', '라즈베리'];
delete fruit[2];  // 삭제한 자리에 구멍이 뚫린다!
console.log('delete 후의 fruit 배열의 상태 : ' + fruit);
console.log('fruit 배열의 개수 : ' + fruit.length);


// includes()
console.log('==== includes() ====');
fruit = ['오렌지', '무화과', '복숭아', '라즈베리'];
let isExist = fruit.includes('오렌지');  // true, false 반환
console.log('배열 안에 오렌지가 존재? ' + isExist);
console.log('배열 안에 딸기가 존재? ' + fruit.includes('딸기'));

// 배열.flatMap(함수)
console.log('==== flatMap(콜백함수) ====');
let myArr = [1, 2, 3, 4, 5];
let newArr = myArr.flatMap((x) => x ** 2);
console.log('원본배열: ' + myArr);
console.log('flatMap 처리 후 배열: ' + newArr);

newArr = myArr.flatMap((x) => [[x ** 2, x ** 3]]);  // 한 개만 반환 가능. 괄호가 중요! 
console.log('원본배열: ' + myArr);
// console.log('flatMap 처리 후 배열: ' + newArr);
console.log(newArr);  // 앞에 문자열 없이 출력해야 확인 가능

// 배열.flat(함수)
console.log('==== flat(콜백함수) ====');
myArr = [1, 2, 3, 4, 5];
let newArr1 = myArr.flatMap((x) => x ** 2);
let newArr2 = myArr.flat((x) => x ** 2);    // 함수를 전달하는 게 의미 없음. 원본의 차원을 축소

console.log('원본배열: ' + myArr);
console.log(newArr1);
console.log(newArr2);

let myArr2 = [[1, 2, 3, 4, 5], [1, 2, 3, 4, 5]];
newArr2 = myArr2.flat();  // 2차원을 1차원으로 축소 

console.log('원본배열: ' + myArr2);
console.log(newArr2);