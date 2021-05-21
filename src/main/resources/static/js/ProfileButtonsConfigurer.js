$(function (){
    $('#ban-button').on('click', function (){
        let elem = $(this);
        if(elem.data('state') === 0){
            $.ajax({
                url:'/profile/ban',
                method: 'PATCH',
                data: {userId:elem.data('id')},
                success: function (){
                    elem.data('state', 1);
                    elem.html('Unban');
                },
                error: function (msg){
                    console.log(msg);
                }
            });
        }

        if(elem.data('state') === 1){
            $.ajax({
                url:'/profile/unban',
                method: 'PATCH',
                data: {userId:elem.data('id')},
                success: function (){
                    elem.data('state', 0);
                    elem.html('Ban');
                },
                error: function (msg){
                    console.log(msg);
                }
            });
        }
    });

    $('#subscribe-button').on('click', function (){
        let elem = $(this);
        console.log(elem.data('state'))
        if(elem.data('state') === 0){
            $.ajax({
                url:'/profile/subscribe',
                method: 'POST',
                data: {userId:elem.data('id')},
                success: function (){
                    elem.data('state', 1);
                    elem.html('Unsubscribe');
                    elem.removeClass('btn-success');
                    elem.addClass('btn-danger');
                },
                error: function (msg){
                    console.log(msg);
                }
            });
        }

        if(elem.data('state') === 1){
            $.ajax({
                url:'/profile/unsubscribe',
                method: 'POST',
                data: {userId:elem.data('id')},
                success: function (){
                    elem.data('state', 0);
                    elem.html('Subscribe');
                    elem.removeClass('btn-danger');
                    elem.addClass('btn-success');
                },
                error: function (msg){
                    console.log(msg);
                }
            });
        }
    });
});