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
<%--<p>欢迎您，#{user.userName}!</p>--%>
<h3 align="center">用户列表</h3>
<table align="center" border="2">
    <tr>
        <td align="center">用户编号</td>
        <td align="center">用户名</td>
        <td align="center">用户密码</td>
        <td align="center" colspan="2">操作</td>
    </tr>
    <c:forEach items="${userList}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.userName}</td>
        <td>${user.password}</td>
        <td>
            <a href="${website}updateUser?userId=${user.id}">修改</a>
        </td>
        <td>
            <a href="${website}delUser?userId=${user.id}">删除</a>
        </td>
    </tr>
    </c:forEach>
    <%--<p align="center">第${page}页，共${pages}页</p>--%>
</table>
</body>
</html>
