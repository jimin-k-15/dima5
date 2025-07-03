/**
 * 사용자가 입력한 회원의 정보 검증 
 */
"use strict";

initial();

function initial() {
	let send = document.getElementById("send");
	
	send.addEventListener('click', validation);
}

function validation() {
	// 요소(Element를 찾음)
	let name = document.getElementById("name");
	let height = document.getElementById("height");
	let weight = document.getElementById("weight");
	
	// 1) 이름은 무조건 입력
	if(name.value.trim().length < 1) {
		alert("이름을 반드시 입력하시오!");
		name.select();
		return;
	}
	
	// 2) 키도 무조건 입력 + 숫자로만
	if(height.value.trim().length < 1 || isNaN(height.value)) {
		alert("키를 숫자로 입력하시오!");
		height.select();
		return;
	}
	
	// 3) 몸무게도 무조건 입력 + 숫자로만
	if(weight.value.trim().length < 1 || isNaN(weight.value)) {
		alert("몸무게를 숫자로 입력하시오!");
		weight.select();
		return;
	}
	
	document.getElementById("insert").submit();  // 데이터가 전송됨
}