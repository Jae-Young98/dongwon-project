const main = {
    init : function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-deleteSelected').on('click', function () {
            _this.deleteSelected();
        })
    },

    save : function () {
        const data = {
            work: $('#work').val(),
            category: $('#category').val(),
            type: $('#type').val(),
            orderCost: $('#orderCost').val(),
            name: $('#name').val(),
            query: $('#query').val(),
            description: $('#description').val(),
            others: $('#others').val()
        };
        let uri = $('#uri').val();

        $.ajax({
            type: 'POST',
            url: '/api/'+uri,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('업무가 추가 되었습니다.');
            window.location.href = '/manage/national-defense';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        const data = {
            category: $('#update-category').val(),
            type: $('#update-type').val(),
            orderCost: $('#update-orderCost').val(),
            name: $('#update-name').val(),
            query: $('#update-query').val(),
            description: $('#update-description').val(),
            others: $('#update-others').val()
        };

        let id = $('#data-id').val();
        let uri = $('#uri').val();

        $.ajax({
            type: 'PUT',
            url: '/api/'+uri+'/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('업무가 수정 되었습니다.');
            window.location.href = '/manage/national-defense';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        let id = $('#data-id').val();
        let uri = $('#uri').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/'+uri+'/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('업무가 삭제 되었습니다.');
            window.location.href = '/manage/national-defense';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    deleteSelected : function () {
        let i;
        const checkboxes = document.querySelectorAll(".chk");

        const idxArr = [];

        $("input:checkbox[name=child-chk]:checked").each(function () {
            idxArr.push($(this).val());
        });

        if (idxArr.length === 0) {
            alert("삭제할 항목을 선택해 주세요.");
            return false;
        }

        const confirmAlert = confirm("삭제하시겠습니까?");

        if (confirmAlert) {
            $.ajax({
                type: 'DELETE',
                url: '/api/nd-data/deleteSelected',
                data: JSON.stringify(idxArr),
                dataType: 'text',
                contentType: 'application/json; charset=utf-8'
            }).done(function () {
                alert('업무가 삭제 되었습니다.');
                window.location.href = '/manage/national-defense';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
    }
};

main.init();

const checkAll = document.getElementById("checkAll");
const checkboxes = document.querySelectorAll(".chk");
checkAll.addEventListener("change", function() {
    const isChecked = checkAll.checked;

    // 모든 개별 체크박스를 전체 선택 체크박스와 동일한 상태로 설정
    for (let i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = isChecked;
    }
});