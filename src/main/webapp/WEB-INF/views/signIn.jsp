<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/23
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
    <%--<script>--%>
        <%--window.onload = function () {--%>
            <%--var userName = document.getElementById("name");--%>
            <%--var lableName = document.getElementById("lname");--%>
            <%--var password = document.getElementById("pwd");--%>
            <%--var lablePassword = document.getElementById("lpass");--%>

            <%--userName.onblur = function () {--%>
                <%--var nameValue = userName.value;--%>
                <%--var pattern = /^[a-zA-Z_]\w{5,19}$/g;--%>
                <%--if (nameValue == "" || nameValue == null) {--%>
                    <%--lableName.innerHTML = "用户名不能为空!";--%>
                <%--}--%>
                <%--else if (pattern.test(nameValue)) {--%>
                    <%--lableName.innerHTML = "";--%>
                <%--}--%>
                <%--else {--%>
                    <%--lableName.innerHTML = "数字不能开头,长度在6-20位之间！";--%>
                <%--}--%>
            <%--}--%>

            <%--password.onblur = function () {--%>
                <%--var passValue = password.value;--%>
                <%--var pattern = /^\w{6,15}$/g;--%>
                <%--if (pattern.test(passValue)) {--%>
                    <%--lablePassword.innerHTML = "";--%>
                <%--}--%>
                <%--else if (passValue == "" || passValue == null) {--%>
                    <%--lablePassword.innerHTML = "密码不能为空!";--%>
                <%--}--%>
                <%--else {--%>
                    <%--lablePassword.innerHTML = "密码长度在6-15位之间！";--%>
                <%--}--%>
            <%--}--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>
<form action="${website}signIn" method="post">
    用户名： <input type="text" name="userName"/> <br/>
    <%--<label id="lname"></label><br/>--%>
    密码： <input type="password" name="password"/> <br/>
    <%--<label id="lpass"></label><br/>--%>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
