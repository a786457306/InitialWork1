<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/12/13
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>admin</title>
</head>
<body>
<h1 align="center">后台管理系统</h1>
<p>欢迎您，#{user.userName}!</p>
<p>用户列表</p>
<table>
    <tr>
        <td>用户编号</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td colspan="2">操作</td>
    </tr>
    <c:forEach items="user" var="user">
    <tr>
        <td>#{user.id}</td>
        <td>#{user.userName}</td>
        <td>#{user.password}</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
