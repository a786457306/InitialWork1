<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/12/15
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload——单个文件</title>
</head>
<body>
<h1 align = "center">文件上传</h1>
<%--enctype="multipart/form-data" ： 表示将文件以二进制流传输，否则报错--%>
<form action = "${website}upload" enctype="multipart/form-data" method = "post">
    选择文件:<input type="file" name = "file">
    <input type="submit" value = "提交">
</form>
</body>
</html>
