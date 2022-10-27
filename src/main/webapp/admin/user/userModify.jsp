<%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" align="center" style="margin-top: 30px">
            <h3>用户${requestScope.userToModify.account}详细信息</h3>
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
        <%--添加form标签只是为了让上下元素之间有适当的间距--%>

        <div class="col-md-10">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/userModify"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="account" class="col-sm-2 control-label">账号:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="account" name="account"
                               value="${requestScope.userToModify.account}">
                        <input type="hidden" id="realAccount" name="realAccount"
                               value="${requestScope.userToModify.account}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickName" class="col-sm-2 control-label">昵称:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickName" name="nickName"
                               value="${requestScope.userToModify.nickName}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="password" name="password"
                               value="${requestScope.userToModify.password}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="gender" name="gender">
                            <option value="true" ${requestScope.userToModify.gender?"selected":""}>=下拉选择=
                            </option>
                            <option value="true" ${requestScope.userToModify.gender?"selected":""}>男
                            </option>
                            <option value="false" ${requestScope.userToModify.gender?"":"selected"}>女
                            </option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthday" class="col-sm-2 control-label">出生日期:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="birthday" name="birthday"
                               value="${requestScope.userToModify.birthday}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">手机号码:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="phone"
                               value="${requestScope.userToModify.phone}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮箱:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email"
                               value="${requestScope.userToModify.email}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">自我介绍:</label>
                    <div class="col-sm-10">
                        <textarea id="description" name="description" style="resize: none;" class="form-control"
                                  rows="5">${requestScope.userToModify.description}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4"></div>
                    <div class="col-md-4" style="text-align: center">
                        <input class="btn btn-success" type="submit" value="修改"/>
                        <input class="btn btn-info" style="margin-left: 20px" type="reset" value="重置"/>
                        <input class="btn btn-primary" type="button" value="返回"
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
