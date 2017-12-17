<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/12/17
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload——多个文件</title>
</head>
<body>
<h1 align = "center">多个文件上传</h1>
<%--enctype="multipart/form-data" ： 表示将文件以二进制流传输，否则报错--%>
<form action = "${website}multiUpload" enctype="multipart/form-data" method = "post">
    选择文件:<input type="file" name = "file1">
    <br>
    选择文件:<input type="file" name = "file2">
    <input type="submit" value = "提交">
</form>
</body>
</html>
