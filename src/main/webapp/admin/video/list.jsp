<%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/25/2022
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台视频列表页面</title>
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
            <h3>添加视频</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10">
        </div>
        <div class="col-md-2">
            ${sessionScope.admin.name}
        </div>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-md-2">
            <a href="${pageContext.request.contextPath}/userList">用户管理</a>
            <br><br>
            <a href="${pageContext.request.contextPath}/videoList">视频管理</a>
        </div>
        <div class="col-md-10">
            <a href="${pageContext.request.contextPath}/admin/video/add.jsp" class="btn btn-info"
               style="margin-bottom: 10px">添加视频</a>
            <table class="table table-striped table-bordered table-hover">
                <tr>
                    <td>序号</td>
                    <td>封面</td>
                    <td>名称</td>
                    <td>作者</td>
                    <td>类型</td>
                    <td>时长(分钟)</td>
                    <td>操作</td>
                </tr>
                <%--                <tr>--%>
                <%--                    <td>1</td>--%>
                <%--                    <td>blah blah blah</td>--%>
                <%--                    <td>blah</td>--%>
                <%--                    <td>5</td>--%>
                <%--                    <td>--%>
                <%--                        <a class="btn btn-info btn-xs" href="#">明细</a>--%>
                <%--                        <a class="btn btn-warning btn-xs" href="#">修改</a>--%>
                <%--                        <a class="btn btn-danger btn-xs" href="#">删除</a>--%>
                <%--                    </td>--%>
                <%--                </tr>--%>
                <c:forEach var="video" items="${requestScope.videoList}" varStatus="status">
                    <tr>
                            <%--<td>${status.count}</td>--%>
                        <td><%=i%>
                        </td>
                        <%
                            i++;
                        %>
                        <td>
                            <img src="${pageContext.request.contextPath}/cover_source/${video.coverPath}" alt="暂时无法显示"
                                 width="150" height="150"/>
                        </td>
                        <td>${video.name}</td>
                        <td>${video.author}</td>
                        <td>${video.type}</td>
                        <td>${video.timeLength}</td>
                        <td>
                            <a class="btn btn-info btn-xs" href="#">明细</a>
                            <a class="btn btn-warning btn-xs" href="#">修改</a>
                            <a class="btn btn-danger btn-xs" href="#">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>