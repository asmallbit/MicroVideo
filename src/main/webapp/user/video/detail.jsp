<%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>视频明细页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" align="center" style="margin-top: 30px">
            <h3>视频明细</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10">
        </div>
        <div class="col-md-2">
            欢饮您, ${sessionScope.user.account}
        </div>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-md-1"></div>
        <%--添加form标签只是为了让上下元素之间有适当的间距--%>
        <div class="col-md-10">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" value="${requestScope.video.name}"
                               readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">作者:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="author" value="${requestScope.video.author}"
                               readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="type" class="col-sm-2 control-label">视频类型:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="type" value="${requestScope.video.type}"
                               readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="createTime" class="col-sm-2 control-label">创建时间:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="createTime"
                               value="${requestScope.video.createTime.toString()}"
                               readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="timeLength" class="col-sm-2 control-label">时长:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="timeLength"
                               value="${requestScope.video.timeLength}"
                               readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="video" class="col-sm-2 control-label">视频:</label>
                    <div class="col-sm-10">
                        <video id="video"
                               poster="${pageContext.request.contextPath}/cover_source/${requestScope.video.coverPath}"
                               width="320" height="240" controls>
                            <source src="/video_source${requestScope.video.videoPath}" type="video/mp4">
                        </video>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">描述:</label>
                    <div class="col-sm-10">
                        <textarea id="description" name="description" style="resize: none;" class="form-control"
                                  rows="5">${requestScope.video.description}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4"></div>
                    <div class="col-md-4" style="text-align: center">
                        <input class="btn btn-primary" type="button" value="返回"
                               onclick="history.back()"/>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </form>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
</body>
</html>
