<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>我的信息</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/music/list.do">
                        返回留言板
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${user.username}!</h1>
                <p>信息都在这里了</p>
            </div>
            <div class="page-header">
                <h3><small>个人信息</small></h3>
            </div>
            <form class="form-horizontal" action="/editUserPrompt.do" method="post">
                <input type="hidden" id="id" name="id" value="${user.id}">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">用户 ：</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name" value="${user.username}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">电话 ：</label>
                    <div class="col-sm-8">
                        <input name=""  class="form-control" rows="3" id="phone" value="${user.phone}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">修改</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
