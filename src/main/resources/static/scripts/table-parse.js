/*
* */
document.getElementById("download").addEventListener("click", parseTableToJson);
document.getElementById("delBtn").addEventListener("click", deleteSelectedRows);

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
        url: "/tables/toJson",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
    })
    alert("다운로드가 시작 됩니다.");
    location.href = "/tables/download";
}

const checkAll = document.getElementById("checkAll");
const checkboxes = document.querySelectorAll(".chk");
checkAll.addEventListener("change", function() {
    const isChecked = checkAll.checked;

    // 모든 개별 체크박스를 전체 선택 체크박스와 동일한 상태로 설정
    for (let i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = isChecked;
    }
});

function deleteSelectedRows() {
    let i;
// 모든 개별 체크박스 요소
    const checkboxes = document.querySelectorAll(".chk");

    // 선택된 체크박스를 담을 배열
    const selectedCheckboxes = [];

    // 선택된 체크박스를 찾아서 배열에 추가
    for (i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            selectedCheckboxes.push(checkboxes[i]);
        }
    }

    if (selectedCheckboxes.length === 0) {
        alert("선택된 항목이 없습니다.");
        return;
    }

    // 선택된 체크박스의 부모 행을 삭제
    for (i = 0; i < selectedCheckboxes.length; i++) {
        const row = selectedCheckboxes[i].closest("tr");
        if (row) {
            row.remove();
        }
    }
}

// print json to console
// var jsonData = parseTableToJson();
// console.log(jsonData);