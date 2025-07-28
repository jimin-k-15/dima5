/**
 * 
 */
/**
 * 전역공간: 아이디 체크여부를 저장하는 변수 선언
 */
let idCheck = false; 	// false인 경우 가입 불가능

$(function() {
	$('#userId').on('blur', function() {
		$('#confirmId').text('')
	});
	$('#userId').on('keyup', confirm);
	$('#joinBtn').on('click', join);
});
// 회원가입 처리
function join() {
	// alert("JOIN Btn +", idCheck);
	// submit을 button으로 바꿀 경우 태그 내의 required가 동작하지 않으므로
	// 이곳에서 전체 검증 코드가 필요 (추후 만들어야 함)
	if(!idCheck) return;
	$('#login-up').submit();
}

// 중복된 아이디인지 체크
function confirm() {
	let userId = $("#userId").val();
	
	if(userId.trim().length < 3 || userId.trim().length > 5) {
		$("#confirmId").css({'color': 'red', 'font-size': '0.8em'});
		$("#confirmId").html('아이디는 3~5자 사이로 입력하시오.');
		return;
	}	
	
	$.ajax({
		url: '/user/confirmId',
		method: 'POST',
		data: {"userId" : userId},
		success: function(resp) { // true면 가입 가능
			if(resp) {
				$("#confirmId").css({'color': 'blue', 'font-size': '0.8em'});
				$("#confirmId").html('사용 가능한 아이디입니다.');
				idCheck = true;
			} else {
				$("#confirmId").css({'color': 'red', 'font-size': '0.8em'});
				$("#confirmId").html('사용 불가능한 아이디입니다.');
				idCheck = false;
			}
		}
	});
}