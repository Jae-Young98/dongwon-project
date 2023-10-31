$(document).ready(function(){
    const fileTarget = $('.files .upload-hidden');

    // 값이 변경되면
    fileTarget.on('change', function(){
        let filename;
        if(window.FileReader){  // modern browser
            filename = $(this)[0].files[0].name;
        }
        else {  // old IE
            filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
        }

        // 추출한 파일명 삽입
        $(this).siblings('.upload-name').val(filename);
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const confirmButton = document.getElementById('confirm-button');
    const uploadForm = document.getElementById('upload-form');
    const fileInput = document.getElementById('filename');

    confirmButton.addEventListener('click', function () {
        if (fileInput.files.length === 0) {
            alert("선택된 파일이 없습니다. 파일을 선택해 주세요.");
        } else {
            const fileName = fileInput.files[0].name;
            if (confirm("주의! 올바른 파일이 맞습니까?\n" + fileName)) {
                uploadForm.submit();
            }
        }
    })
})

function validateInput(inputElem) {
    const notification = document.getElementById("notification");

    if (isNaN(inputElem.value)) {
        inputElem.classList.add("error");
        notification.style.display = "block";
    } else {
        inputElem.classList.remove("error");
        notification.style.display = "none";
    }
}