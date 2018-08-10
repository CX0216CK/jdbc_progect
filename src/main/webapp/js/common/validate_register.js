$(function () {
    //获取鼠标失去光标的事件
    $("#username").blur(function () {
        //获取username的value
        var username = $("#username").val();
        if (username === "") {
            $("#errorName").html("用户名不允许为空");
        } else { //不为空就可以ajax提交到后台数据库
            $.ajax({
                url: "/login?methodName=validateName",
                data: {"username": username},
                type: "POST",
                dataType: "json",
                success: function (data) {
                    if (data.status == 0) {
                        $("#errorName").html("<h1>" + data.message + "</h1>");
                        return false;
                    } else {
                        $("#errorName").html("<h1>可以使用</h1>");
                    }
                }
            });
        }
    });

});
