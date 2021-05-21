$('.delete-btn').on('click', function () {
    let elem = $(this);

    $.ajax({
        url: elem.data("url"),
        method: 'DELETE',
        success: function () {
            elem.parent().remove();
        },
        error: function (msg) {
            console.log(msg);
        }
    });
});
