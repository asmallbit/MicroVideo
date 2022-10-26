<%@ page import="edu.hhu.hanjianwei.entity.User" %>
<%@ page import="edu.hhu.hanjianwei.entity.Video" %>
<%@ page import="edu.hhu.hanjianwei.service.VideoService" %>
<%@ page import="edu.hhu.hanjianwei.service.impl.VideoServiceImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>视频列表页面</title>
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
            <h3>视频列表</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10">
        </div>
        <div class="col-md-2">
            欢迎您, ${sessionScope.user.account}
        </div>
    </div>
    <%
        // 获取movie列表
        VideoService videoService = new VideoServiceImpl();
        List<Video> videoList = videoService.queryAll();
    %>
    <div class="row" style="margin-top: 20px">
        <div class="col-md-1">
            <%-- TODO: 观影记录--%>
            <%-- <a href="${pageContext.request.contextPath}/userList">用户管理</a>--%>
            <%--            <br><br>--%>
            <%--            <a href="${pageContext.request.contextPath}/videoList">视频管理</a>--%>
        </div>
        <div class="col-md-10">
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
                <c:forEach var="video" items="<%=videoList%>" varStatus="status">
                    <tr>
                            <%--<td>${status.count}</td>--%>
                            <%--此处显示的id并非真正的数据库中的主键id, 这么做的原因只是为了避免数据库中删除造成id混乱不按次序--%>
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
                            <a class="btn btn-info btn-xs"
                               href="${pageContext.request.contextPath}/watchVideo?id=${video.id}">播放</a>
                            <a class="btn btn-warning btn-xs"
                               href="${pageContext.request.contextPath}/videoDetail?id=${video.id}">明细</a>
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