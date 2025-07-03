'use strict';

initial();

function initial() {
    // 이벤트 소스와 이벤트 핸들러를 연결
    document.getElementById("inner").addEventListener('click', inner);
    document.getElementById("afterend").addEventListener('click', afterendFunc);
    document.getElementById("afterbegin").addEventListener('click', afterbeginFunc);
    document.getElementById("beforeend").addEventListener('click', beforeendFunc);
    document.getElementById("beforebegin").addEventListener('click', beforebeginFunc);
}
// Handler
function inner() {
    let data = `<b>동구밖</b> 과수원길 아카시아 <br>꽃이 활짝폈네`;
    document.getElementById('innerTarget').innerHTML = data;    // 속성값으로 데이터를 변경
}

function afterendFunc() {
    let data = `<b>동구밖</b> 과수원길 아카시아 <br>꽃이 활짝폈네`;
    let list = document.getElementById("list");
    list.insertAdjacentHTML('afterend', data);  // list의 동생으로 데이터를 추가
}

function afterbeginFunc() {
    let data = `<b>송아지</b> 송아지 얼룩 송아지<br>엄마소도 얼룩소 엄마 닮았네`;
    let list = document.getElementById("list");
    list.insertAdjacentHTML('afterbegin', data);  // list의 첫번째 자식 요소로 추가
}

function beforeendFunc() {
    let data = `학교종이 땡땡땡 어서모이자, 선생님이 우리를 기다리신다.`;
    let list = document.getElementById("list");
    list.insertAdjacentHTML('beforeend', data);   // list의 마지막 자식 요소로 추가
}

function beforebeginFunc() {
    let data = `<p>바람이 서늘도하여 뜰앞에 나섰더니...</p>`;
    let list = document.getElementById("list");
    list.insertAdjacentHTML('beforebegin', data);
}