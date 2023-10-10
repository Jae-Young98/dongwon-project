const getCategory = document.getElementById("manage").value;

const main = {
    init : function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
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
        }

        const id = $('#id').val();

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
    }
};

main.init();