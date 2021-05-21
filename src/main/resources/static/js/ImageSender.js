$(function (){
    $('#upload').on('click', function (){
        let data = new FormData();
        data.append("file", $("#file").prop('files')[0]);
        console.log(data)
        $.ajax({
            url:'/image/upload?parentId=' + $('#parentId').val(),
            method: 'POST',
            data: data,
            cache: false,
            contentType: false,
            processData: false,
            success: function (msg){
                console.log(msg);
            },
            error: function (msg){
                console.log(msg);
            }
        });
    })
});