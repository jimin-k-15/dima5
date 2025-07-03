/**
 * 
 */
'use strict';

initial();

function initial() {
	document.getElementById("btn").addEventListener('click', function () {
    let productName = document.getElementById("productName").value
    if (productName.trim().length < 1) {
		alert("제품명을 입력하세요");
		document.getElementById("productName").focus()
        return;
        }
        document.getElementById("stockProc").submit();
       });
    }