<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div class="login">
    <div class="header">
        <h1>
            <a href="/login.do">登录</a>
            <a href="/register.do">注册</a>
        </h1>
        <button></button>
    </div>
    <form action="registerUser.do" method="post">
        <div class="name">
            <input type="text" id="name" name="username" placeholder="注册用户名">
            <p></p>
        </div>
        <div class="pwd">
            <input type="password" id="pwd" name="password" placeholder="密码">
            <p></p>
        </div>
        <div class="btn-red">
            <input type="submit" value="注册" id="reg-btn">
        </div>
    </form>
</div>
</body>
</html>