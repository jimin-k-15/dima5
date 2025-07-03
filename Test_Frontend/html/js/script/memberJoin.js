'use strict';

initial();

function initial() {
    // 이벤트 소스 얻어오기
    document.getElementById("join").addEventListener('click', joinCheck);
    document.getElementById("userid").addEventListener('keyup', idCheck);
    document.getElementById("email2").addEventListener('change', emailCheck);
}

// 아이디를 입력했을 때 처리하는 이벤트 핸들러
function idCheck() {
    let userid = document.getElementById('userid');
    let idCheck = document.getElementById('idCheck');

    if (userid.value.trim().length < 3 || userid.value.trim().length > 5) {
        idCheck.style.color = 'red';
        idCheck.innerText = "아이디는 영대소문자, 숫자 포함 3~5글자로 입력해주세요";
        return;
    }
    idCheck.innerText = "";
}

// 이메일의 선택상자의 상태가 변경되었을 때 처리하는 이벤트 핸들러
function emailCheck() {
    let email2 = document.getElementById("email2").value;

    if (email2.length != 0) {
        document.getElementById("email3").value = email2
    } else { // 이메일을 선택하지 않은 경우
        document.getElementById("email3").value = "";
        document.getElementById("email3").focus();
    }
}


// 서버로 최종 전달하는 함수
function joinCheck() {
    // 1) 이름의 길이 체크 (3~5자리 사이로)
    let username = document.getElementById("username");
    if (username.value.trim().length < 3 || username.value.trim().length > 5) {
        alert("이름은 실명으로 3~5자 내로 입력해주세요")
        username.select();
        return;
    }

    // 2) 아이디 길이 체크
    let userid = document.getElementById('userid');

    if (userid.value.trim().length < 3 || userid.value.trim().length > 5) {
        alert("아이디는 영대소문자, 숫자 포함 3~5글자로 입력해주세요");
        userid.select();
        return;
    }

    // 3-1) 패스워드 길이 체크
    let userpwd = document.getElementById('userpwd');

    if (userpwd.value.trim().length < 3 || userpwd.value.trim().length > 5) {
        alert("비밀번호는 영대소문자, 숫자 포함 3~5글자로 입력해주세요");
        userpwd.select();
        return;
    }

    // 3-2) 패스워드와 확인값이 같은지 체크  
    let pwdcheck = document.getElementById('pwdcheck');

    if (userpwd.value.trim() != pwdcheck.value.trim()) {
        alert("비밀번호는 비밀번호 확인값과 같아야 합니다.");
        pwdcheck.value = "";
        pwdcheck.focus();
        return;
    }

    // 4-1) 전화번호 맨 앞자리 얻어오기
    let phone1 = document.getElementById("phone1").value;

    // 4-2) 전화번호 중간자리 얻어오기
    let phone2 = document.getElementById("phone2");
    if (isNaN(phone2.value)
        || phone2.value.trim().length < 3
        || phone2.value.trim().length > 4) {
        alert("전화번호를 숫자로 정확히 입력하세요");
        phone2.select();
        return;
    }

    // 4-3) 전화번호 끝자리 얻어오기
    let phone3 = document.getElementById("phone3");
    if (isNaN(phone3.value)
        || phone3.value.trim().length < 3
        || phone3.value.trim().length > 4) {
        alert("전화번호를 숫자로 정확히 입력하세요");
        phone3.select();
        return;
    }
    let phone = phone1 + phone2.value.trim() + phone3.value.trim();

    // 5-1) 이메일 앞자리 얻어오기
    let email = ''; // 완성된 이메일을 합칠 변수

    let email1 = document.getElementById("email1");
    if (email1.value.trim().length == 0) {
        alert("이메일을 입력해 주세요");
        email1.select();
        return;
    }

    let email2 = document.getElementById("email3")
    if (email3.value.trim().length == 0) {
        alert("이메일을 정확히 입력해 주세요");
        email3.select();
        return;
    }
    email = email1.value + '@' + email3.value.trim();

    // 5-2) 이메일 가운데+끝 얻어오기
    /*
    let email2 = document.getElementById("email2").value;
    let email3;
    if (email2 == '직접입력') {
        document.getElementById("email.3").focus();
        email3 = document.getElementById("email3");
        if (email3.value.trim().length == 0) {
            alert("이메일을 입력해 주세요");
            email3.select();
            return;
        }
        email = email1.value + '@' + email3.value.trim();
    } else {
        email = email1.value + '@' + email2;
    }
    alert(email);
    */


    // 6) 주소 + 상세주소 얻어오기
    let addr1 = document.getElementById("addr1").value;
    let addr2 = document.getElementById("addr2");

    if (addr2.value.trim().length == 0) {
        alert("상세 주소를 입력하세요.")
        addr2.focus();
        return;
    }

    let address = `${addr1} ${addr2}`;

    // 7) 사이트를 알게 된 경로 : 체크박스이기 때문에 여러 개 선택될 수 있다.

    let p = document.querySelectorAll('input[class="path"]:checked')
    let path = '';
    p.forEach((item) => path += item.value + ' ');

    // 8) 이메일 수신여부 확인
    // receive = document.querySelector("input[type='radio'].receive:checked").value; // 위아래 둘 다 가능
    let receive = document.querySelector("input[name='receive']:checked").value;

    // 9) 카카오톡 수신 동의 여부 확인
    let kakao = document.querySelector("input[name='kakaotalk']:checked");
    let kakaoreceive = false;
    // 체크를 안 했을 경우 null
    if (kakao == null) {
        kakaoreceive = false;
    } else {
        kakaoreceive = true;
    }

    // 최종 결과물을 출력하는 코드
    let finalResult = `<h2>[ 최종 결과물 ]</h2>
    <ul> `;

    finalResult += `<li>이름: ${username.value}</li>`;
    finalResult += `<li>아이디: ${userid.value}</li>`;
    finalResult += `<li>비밀번호: ${userpwd.value}</li>`;
    finalResult += `<li>전화번호: ${phone}</li>`;
    finalResult += `<li>이메일: ${email}</li>`;
    finalResult += `<li>주소: ${address}</li>`;
    finalResult += `<li>사이트를 알게 된 경로: ${path}</li>`;
    finalResult += `<li>이메일 수신 여부: ${receive}</li>`;
    finalResult += `<li>카카오톡 수신 동의: ${kakaoreceive ? '동의' : '미동의'}</li>`;
    finalResult += `</ul>`;

    document.getElementById("final").innerHTML = finalResult;
}
