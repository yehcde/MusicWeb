<%--
  Created by IntelliJ IDEA.
  User: yehaocheng
  Date: 2020/4/29
  Time: 1:28 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
</head>
<body>
<div align="center">
    <form action="upload.do" enctype="multipart/form-data" method="post">
        名称：<input name="name" /> <br>
        上传：<input name="img" type="file"/><br>
        <input type="submit" value="提交" /> &nbsp;&nbsp;
        <input type="reset" value="重置" />
    </form>
</div>
</body>
</html>
