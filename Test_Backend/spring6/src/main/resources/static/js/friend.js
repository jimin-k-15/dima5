/**
 * 
 */

initial();

function initial() {
	let delBtn = document.getElementsByClassName("deleteFriend");
	for(let i=0; i<delBtn.length; ++i)
		delBtn[i].addEventListener('click', deleteFriend);
	
	let updateBtn = document.getElementsByClassName("updateFriend");
	for(let i=0; i<updateBtn.length; ++i)
		updateBtn[i].addEventListener('click', updateFriend);
}

function deleteFriend() {
	let id = this.getAttribute("data-id");  // this = 이벤트를 일으킨 버튼
	
	if(confirm("삭제하시겠습니까?")) {
		location.href="/delete?id=" + id;  	// location, 즉 브라우저의 주소 표시줄 객체에 값을 넣기
	} 
}

function updateFriend() {
	let id = this.getAttribute("data-id");
	location.href="/update?id=" + id;    	// 정보를 조회한 다음 update 화면에 뿌려달라고 하기
}