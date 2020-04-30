<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Music</title>
    </head>

    <body>
        <header>
            <div class="container">
                <% if (null != request.getSession().getAttribute("user")) {%>
                    <nav>
                        <a href="${pageContext.request.contextPath}/userInfo.do">我的信息</a>
                    </nav>
                <%} else { %>
                    <nav>
                        <a href="/login.do">登录</a>
                        <a href="/register.do">注册</a>
                    </nav>
                <% } %>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>Music</h1>
                </div>
                <li><a href="/upload.do" >欢乐的歌曲</a></li>
                <li><a href="/upload.do">悲伤的歌曲</a></li>

            </div>
        </section>
        <section class="page">
            <div class="container">
                <% if (null != request.getSession().getAttribute("user")) {%>
                <%} else { %>
                    <div id="fatie">
                        请<a href="/login.do"><button>登录</button></a>以便使用更多的功能
                    </div>
                <% } %>

                <div id="pagefy">
                    <ul>
                        <form id="messageForm" action="${pageContext.request.contextPath}/music/list.do" method="post">
                            <input type="hidden" id="page" name="page" value="${page}">
                            <input type="hidden" id="last" name="last" value="${last}">
                            <li><a href="javascript:void(0)" onclick="">首页</a></li>
                            <li><a href="javascript:void(0)" onclick="">上一页</a></li>
                            <li><a href="javascript:void(0)">当前第${page}页</a></li>
                            <li><a href="javascript:void(0)" onclick="">下一页</a></li>
                            <li><a href="javascript:void(0)" onclick="">尾页</a></li>
                        </form>
                    </ul>
                </div>
            </div>
        </section>
    </body>
</html>