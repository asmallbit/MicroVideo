<%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登陆页面</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.js"></script>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" align="center" style="margin-top: 30px">
            <h3>用户登陆</h3>
        </div>
    </div>
    <div class="row" style="margin-top: 30px">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form class="form-horizontal" action="/userLogin" method="post">
                <div class="form-group">
                    <label for="account" class="col-sm-2 control-label">账号:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3"></div>
                    <div class="col-md-6" style="text-align: center">
                        <input class="btn btn-success" type="submit" value="提交"/>
                        <a href="signup.jsp"><input class="btn btn-info" style="margin-left: 20px" type="button"
                                                    value="注册"/></a>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>

