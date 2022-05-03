<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 2021/8/7
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File</title>
</head>
<body>
    <form action="http://localhost:8080/Java_8/upload" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username" /> <br/>
        头像：<input type="file" name="photo" /> <br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
