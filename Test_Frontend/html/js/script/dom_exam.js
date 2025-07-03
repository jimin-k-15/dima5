'use strict';
/*
    일정 시간이 지나면 (0.5이 지나면 그림이 바뀌도록 하시오)
    img1.png 부터 img10.png 까지 1~10번 그림이 반복적으로 보여짐
*/
let i = 1;
setInterval(() => {
    console.log(`./images/img${i}.png`);
    document.getElementById("one").setAttribute("src", `./images/img${i}.png`);
    if (++i > 10) i = 1;
}, 500);