'use strict';

// 이벤트 소스
let join = document.getElementById("join");

// 이벤트 타겟
let userid = document.getElementById("userid");
let birthday = document.getElementById("birthday");

// 이벤트 소스와 이벤트 핸들러와 연결
join.addEventListener('click', validate);

function validate() {
    // 회원이 입력한 아이디와 생년월일을 읽어옴
    // 아이디는 4~7 사이의 글자를 입력
    let id = userid.value;
    if (!(id.length >= 4 && id.length <= 7)) {
        alert("아이디는 4~7 사이의 글자를 입력하세요!");
        userid.select();
        return;
    }

    // 생년월일의 길이는 8자리여야 한다. 숫자만 입력
    let birth = birthday.value;  // RR, LW
    if (!(birth.length == 8 && !isNaN(birth))) {
        alert("생년월일은 숫자 8자리로만 입력하세요!");
        // birthday.select();  // focus/select를 넣으려면 대상이 태그여야 함(userid, birthday)
        birthday.value = "";
        return;
    }

    let result = `<b>당신의 아이디는 <span style="color:red;"> ${id}</span>`
    result = `, 생년월일은 ${birth}</b>`;

    document.getElementById("result").innerHTML = result;
}