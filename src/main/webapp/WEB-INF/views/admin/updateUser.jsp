<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/12/13
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateUser</title>
</head>
<body>
<form action = "${website}updateUser" method="post">
    <input type="hidden" name="userId" value="${userId}"/>
    用户名： <input type="text" name="userName" value="${userName}"/> <br/>
    密码： <input type="password" name="password" value="${password}"/> <br/>
    <input type="submit" value="确定修改"/>
</form>
</body>
</html>
