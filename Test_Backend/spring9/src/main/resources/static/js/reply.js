/**
 * 
 */

$(function(){
	init();
	$("#replyBtn").on('click', replyWrite);
	$("#updateBtn").on('click', replyUpdateProc);
});

// DB에서 현재 게시글의 모든 댓글정보를 가져와서 화면에 출력
function init() {
	let boardSeq = $("#boardSeq").val();
	
	$.ajax({
		url: '/reply/replyAll',
		method: 'GET',
		data: {"boardSeq": boardSeq},
		success: output
	});
}

// [ {}, {} ] -> 배열 안의 객체 형태 
function output(resp) {
	// console.log(resp);	// [ {"writer":"kildong"}, {}, {} ] --> resp[0]["writer"]
	let loginId = $('#loginId').val(); 		// 로그인한 사람의 아이디
	
	let tag = `
	<table>
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th></th>
		</tr>`;
	$.each(resp, function(index, item) {
		tag += `
		<tr>
			<td class='no'>${index + 1}</td>
			<td class='content'>${item["replyContent"]}</td>
			<td class='writer'>${item["replyWriter"]}</td>
			<td class='date'>${item["createDate"].substr(0, 10)}</td>
			<td class='btns'>
				<input type="button" value="삭제" class="btn btn-danger delBtn" data-seq="${item['replySeq']}"
				${item["replyWriter"] == loginId ? '' : 'disabled'}>
				
				<input type="button" value="수정" class="btn btn-info updateBtn" data-seq="${item['replySeq']}"
				${item["replyWriter"] == loginId ? '' : 'disabled'}>
			</td>
		</tr>`;
	});
	tag += "</table>";
	$("#reply-list").html(tag);
	
	// 삭제, 수정버튼에 이벤트 등록
	$('.delBtn').on('click', replyDelete)
	$('.updateBtn').on('click', replyUpdate)
}

// 댓글 삭제
function replyDelete() {
	let replySeq = $(this).attr('data-seq');	// 댓글번호 읽어옴
	
	$.ajax({
		url: '/reply/replyDelete',
		method: 'POST',
		data: {"replySeq": replySeq},
		success: function() {
			clear();
			init();
		}
	});
}
// 댓글 수정을 위해 조회(select)하기
function replyUpdate() {
	let replySeq = $(this).attr('data-seq');	// 댓글번호 읽어옴

	$.ajax({
		url: '/reply/replyUpdate',
		method: 'GET',
		data: {"replySeq": replySeq},
		success: function(resp) {
			clear();
			let replyContent = resp["replyContent"];
			$("#replyText").val(replyContent);
			
			// 버튼을 뒤집고 댓글번호를 꽂아주는 작업
			$('#updateBtn').css('display', 'inline');	// 댓글 수정 버튼은 보이고
			$('#updateBtn').attr('data-seq', resp["replySeq"]);		// 글번호 꽂고
			
			$('#replyBtn').css('display', 'none');		// 댓글 입력 버튼은 안 보이게
		}
	});	
}

// 댓글을 DB에서 수정하도록 요청
function replyUpdateProc() {
	let replySeq = $(this).attr('data-seq');
	let replyContent = $("#replyText").val();
	let sendData = {"replySeq": replySeq, "replyContent": replyContent};
	
	console.log(JSON.stringify(sendData));
	
	$.ajax({
		url: '/reply/replyUpdateProc',
		method: 'POST',
		data: sendData,
		success: function() {
			clear();
			// 버튼을 다시 뒤집는 작업
			$('#updateBtn').css('display', 'none');		// 댓글 수정 버튼은 안 보이고			
			$('#replyBtn').css('display', 'inline'); 	// 댓글 입력 버튼은 보이게 
			init();
		}
	});
}




// 댓글 저장
function replyWrite() {
	let replyContent = $("#replyText").val();
	if(replyContent.trim().length < 1) {
		alert("댓글을 입력하시오");
		return;
	}
	
	let boardSeq = $("#boardSeq").val();
	let replyWriter = $("#loginId").val();
	
	let sendData = {
		"boardSeq": boardSeq
		, "replyContent": replyContent
		, "replyWriter": replyWriter
	};
	
	console.log(JSON.stringify(sendData));
	
	$.ajax({
		url: '/reply/replyWrite',
		method: 'POST',
		data: sendData,
		success: function() {
			clear();
			init();
		}
	});
	
}
function clear() {
	$("#replyText").val('');
}