<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>登录</title>

		<script type="text/javascript">


            function getCookie(cookie_name) {
                var allCookies = document.cookie;
                var cookie_pos = allCookies.indexOf(cookie_name);   //如果找到了索引，就代表cookie存在
                if (cookie_pos != -1) {
                    cookie_pos += cookie_name.length + 1;
                    var cookie_end = allCookies.indexOf(";", cookie_pos);
                    if (cookie_end == -1) {
                        cookie_end = allCookies.length;
                    }
                    return unescape(allCookies.substring(cookie_pos, cookie_end));
                }
                return null;
            }
		</script>
	</head>
	<body>
		<div class="login">
			<div class="header">
				<h1>
					<a href="${pageContext.request.contextPath}/login.do">登录</a>
					<a href="/register.do">注册</a>
				</h1>
				<button></button>
			</div>
			<form action="/main.do" method="post">
				<div class="name">
					<input type="text" id="name" name="username" placeholder="请输入登录用户名">
					<p></p>
				</div>
				<div class="pwd">
					<input type="password" id="pwd" name="password" placeholder="密码，区分大小写">
					<p></p>
				</div>
				<div class="btn-red">
					<input type="submit" value="登录" id="login-btn">
				</div>
			</form>
		</div>
	</body>
</html>