/*
* */
document.getElementById("download").addEventListener("click", parseTableToJson);

function parseTableToJson() {
    const table = document.getElementById("data-table");
    const data = [];

    // 테이블의 행을 반복
    for (let i = 1; i < table.rows.length; i++) {
        const row = table.rows[i];
        const rowData = {};

        // 각 행의 셀을 반복
        for (let j = 1; j < row.cells.length; j++) {
            const cell = row.cells[j];
            const header = table.rows[0].cells[j].innerText; // 헤더 값 가져오기
            const value = cell.innerText;
            rowData[header] = value;
        }

        data.push(rowData);
    }

    console.log(data);
    // return JSON.stringify(data); // JSON 문자열로 변환
    $.ajax({
        type: "POST",
        url: "/tables/download",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
    })
    alert("다운로드가 시작 됩니다.");
    location.href = "/tables/download/test";
}

// print json to console
// var jsonData = parseTableToJson();
// console.log(jsonData);