<%@ page import="edu.hhu.hanjianwei.service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
<%
    int i = 1;
%>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" align="center" style="margin-top: 30px">
            <h3>用户列表</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8">
        </div>
        <div class="col-md-4">
            欢迎您, ${sessionScope.admin.name}, 点击<a
                href="${pageContext.request.contextPath}/signOut?isUser=false">退出登录</a>
        </div>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-md-1">
            <a href="${pageContext.request.contextPath}/userList">用户管理</a>
            <br><br>
            <a href="${pageContext.request.contextPath}/videoList">视频管理</a>
        </div>
        <div class="col-md-10">
            <table class="table table-striped table-bordered table-hover">
                <tr>
                    <td>id</td>
                    <td>账号</td>
                    <td>昵称</td>
                    <td>性别</td>
                    <td>手机号码</td>
                    <td>电子邮箱</td>
                </tr>
                <c:forEach var="user" items="${sessionScope.users}" varStatus="status">
                    <tr>
                            <%--<td>${status.count}</td>--%>
                            <%--此处显示的id并非真正的数据库中的主键id, 这么做的原因只是为了避免数据库中删除造成id混乱不按次序--%>
                        <td><%=i%>
                        </td>
                        <%
                            i++;
                        %>
                        <td>${user.account}</td>
                        <td>${user.nickName}</td>
                        <td>${user.gender?"男":"女"}</td>
                        <td>${user.phone}</td>
                        <td>${user.email}</td>
                        <td>
                            <a class="btn btn-info btn-xs"
                               href="${pageContext.request.contextPath}/userDetail?id=${user.account}">明细</a>
                            <a class="btn btn-warning btn-xs"
                               href="${pageContext.request.contextPath}/userModify?id=${user.account}">修改</a>
                            <a class="btn btn-danger btn-xs"
                               href="${pageContext.request.contextPath}/userRemove?id=${user.account}"
                               onclick="return confirm('确定删除此用户吗?')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
</body>
</html>
