let articleAmount = 0;
const articlesToLoad = 5;
const loadBorder = 100;
let requestSend = true;

function request() {
    if(document.body.scrollHeight - window.pageYOffset - document.body.clientHeight < loadBorder && requestSend){
        requestSend = false;
        $.ajax({url:"/feed?limit=" + articlesToLoad + "&offset=" + articleAmount,
            success:function (msg) {
                requestSend = true;
                $("#image-list").append(msg);
                articleAmount += articlesToLoad;
            }});
    }
}



$(function () {
    if(articleAmount === 0) {
        request();
    }
    $(document).on("scroll", request)
});

