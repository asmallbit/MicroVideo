<%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆失败</title>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" align="center" style="margin-top: 30px">
            <h3>${requestScope.error}</h3>
            <input class="btn btn-info" type="button" onclick="history.back()"
                   value="返回上一页"/>
        </div>
    </div>
</div>
</body>
</html>
