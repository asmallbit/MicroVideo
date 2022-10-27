<%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/25/2022
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台视频添加页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" align="center" style="margin-top: 30px">
            <h3>添加视频</h3>
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
        <div class="col-md-2">
            <a href="${pageContext.request.contextPath}/userList">用户管理</a>
            <br><br>
            <a href="${pageContext.request.contextPath}/videoList">视频管理</a>
        </div>
        <div class="col-md-10">
            <form class="form-horizontal" action="/videoAdd" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入视频名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">作者:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="author" name="author" placeholder="请输入作者">
                    </div>
                </div>
                <div class="form-group">
                    <label for="type" class="col-sm-2 control-label">视频类型:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="type" name="type">
                            <option value="Others">=Please choose=</option>
                            <option value="War">War</option>
                            <option value="Adventure">Adventure</option>
                            <option value="Action">Action</option>
                            <option value="Comedy">Comedy</option>
                            <option value="Drama">Drama</option>
                            <option value="Horror">Horror</option>
                            <option value="Romance">Romance</option>
                            <option value="Fantasy">Fantasy</option>
                            <option value="Historical">Historical</option>
                            <option value="Others">Others</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="createTime" class="col-sm-2 control-label">创建时间:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="createTime" name="createTime"
                               onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请输入创建时间:"
                               readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="timeLength" class="col-sm-2 control-label">时长:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="timeLength" name="timeLength"
                               placeholder="请输入影片时长:">
                    </div>
                </div>
                <div class="form-group">
                    <label for="video" class="col-sm-2 control-label">视频:</label>
                    <div class="col-sm-10">
                        <input type="file" class="form-control" id="video" name="videoPath">
                    </div>
                </div>
                <div class="form-group">
                    <label for="cover" class="col-sm-2 control-label">封面:</label>
                    <div class="col-sm-10">
                        <input type="file" class="form-control" id="cover" name="coverPath">
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">描述:</label>
                    <div class="col-sm-10">
                        <textarea id="description" name="description" style="resize: none;" class="form-control"
                                  rows="5" placeholder="随便留下点什么吧..."></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4"></div>
                    <div class="col-md-4" style="text-align: center">
                        <input class="btn btn-success" type="submit" value="添加"/>
                        <input class="btn btn-info" style="margin-left: 20px" type="reset" value="重置"/>
                        <input class="btn btn-primary" style="margin-left: 10px" type="button" value="返回"
                               onclick="history.back()"/>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>