/**
 * 
 */

$(function() {
	$('#predictBtn').on('click', predictProc);
})

function predictProc() {
	let petalLength = $('#petalLength').val();
	let petalWidth = $('#petalWidth').val();
	let sepalLength = $('#sepalLength').val();
	let sepalWidth = $('#sepalWidth').val();
	
	// 문자열이 입력되지 않도록 체크
	if(isNaN(petalLength) || isNaN(petalWidth) || isNaN(sepalLength) || isNaN(sepalWidth)) {
		alert("데이터는 숫자로 입력해주세요");
		return;
	}
	
	let sendData = {
		"petalLength": petalLength, 
		"petalWidth": petalWidth, 
		"sepalLength": sepalLength, 
		"sepalWidth": sepalWidth};
		
	$.ajax({
		url: '/predict',
		method: 'POST',
		data: sendData,
		async: false,
		success: function(resp) { // resp = {"predict_result":'setosa'} <- 분석 결과가 resp라는 변수에 담김
			$('#result').text(resp["predict_result"]);
		}
		, error: function(resp) {
			$('#result').text("error:" + JSON.stringify(resp));
		}
	});
}