<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2 align="center">Hello World!</h2>
<p>欢迎登录，${sessionScope.user.userName}</p>
<a href="${website}admin/listUser">进入用户管理界面</a>
<a href="${website}file/fileUpload">上传单个文件</a>
<a href="${website}file/multiFileUpload">上传多个文件</a>
<%--<a href="${website}file/fileDownload">下载文件</a>--%>
<a href="${website}file/download">下载指定文件</a>

</body>
</html>
