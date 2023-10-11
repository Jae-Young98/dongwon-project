const getCategory = document.getElementById("manage").value;

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
        })
    },

    save : function () {
        const data = {
            category: $('#category').val(),
            type: $('#type').val(),
            orderCost: $('#orderCost').val(),
            name: $('#name').val(),
            query: $('#query').val(),
            description: $('#description').val(),
            others: $('#others').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/nd-data',
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

        $.ajax({
            type: 'PUT',
            url: '/api/nd-data/'+id,
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

        $.ajax({
            type: 'DELETE',
            url: '/api/nd-data/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('업무가 삭제 되었습니다.');
            window.location.href = '/manage/national-defense';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();