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
    <title>Title</title>
</head>
<body>
<form action="${website}login" method="post">
    用户名: <input type="text" name="userName"/> <br/>
    密码： <input type="password" name="password"/> <br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
