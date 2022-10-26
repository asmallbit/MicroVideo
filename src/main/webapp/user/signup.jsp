<%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户注册页面</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <script src="/js/jquery-3.6.0.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" align="center" style="margin-top: 30px">
            <h3>用户注册</h3>
        </div>
    </div>
    <div class="row" style="margin-top: 30px">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form class="form-horizontal" action="/userSignUp" method="post">
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
                    <label for="passwordAgain" class="col-sm-2 control-label">再次输入密码:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="passwordAgain" name="passwordAgain"
                               placeholder="请再次输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickName" class="col-sm-2 control-label">昵称:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入昵称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="gender" name="gender">
                            <option value="true">=下拉选择=</option>
                            <option value="true">Man</option>
                            <option value="false">Woman</option>
                            <option value="true">Trans Man</option>
                            <option value="false">Trans Woman</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthday" class="col-sm-2 control-label">出生日期:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="birthday" name="birthday"
                               onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" placeholder="请输入出生日期:"
                               readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">手机号码:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="phone" name="phone" placeholder="请输入手机号码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮箱:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱">
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">自我介绍:</label>
                    <div class="col-sm-10">
                        <textarea id="description" name="description" style="resize: none;" class="form-control"
                                  rows="5" placeholder="随便写点什么吧..."></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3"></div>
                    <div class="col-md-6" style="text-align: center">
                        <input class="btn btn-success" type="submit" value="提交"/>
                        <input class="btn btn-info" style="margin-left: 20px" type="reset" value="重置"/>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
</body>
</html>
