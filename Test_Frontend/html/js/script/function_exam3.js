document.getElementById("receiveBtn").addEventListener('click', display);

function display() {
    // 서버에서 아래와 같은 형태의 데이터를 받았다!
    let receivedData = [
        { id: "100", firstname: "홍길동", salary: 12000, department: "홍보부" },
        { id: "200", firstname: "전우치", salary: 25000, department: "영업팀" },
        { id: "300", firstname: "손오공", salary: 12900, department: "전산팀" },
        { id: "400", firstname: "사오정", salary: 30000, department: "기획팀" },
        { id: "500", firstname: "저팔계", salary: 26500, department: "R&D팀" }
    ];
    let total = 0;
    let result =
        `<table><thead>
        <tr>
            <th>사원번호</th>
            <th>이름</th>
            <th>급여</th>
            <th>부서</th>
        </tr></thead>`;

    receivedData.forEach(emp => {
        let { id, firstname, salary, department } = emp;
        result +=
            `<tr>
            <td>${id}</td>
            <td>${firstname}</td>
            <td>${salary}</td>
            <td>${department}</td>
        </tr>`;
        total += salary;
    });
    result +=
        `<tr>
        <td colspan="2">급여총액</td>
        <td>${total}</td>
        <td></td>
    </tr>
    </table>`;
    // 데이터를 target에 꽂는 코드
    document.getElementById("target").innerHTML = result;
}