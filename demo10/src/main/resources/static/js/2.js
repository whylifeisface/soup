datas = {
    username: $("ni").text(),
    password: $("pa").text()
}

// $("err").hide();
$("jqForm").ajax(url="http://local:8080/login/post",
    method= "post",
    data = datas).success(


).error(
    $("err").text("用户名或密码错误")
)