<%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频播放</title>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">

        <div class="col-md-10" align="center">
            <h3>影片名称: ${requestScope.play[2]}, 回到<a href="${pageContext.request.contextPath}/user/video/list.jsp">主页
            </a></h3>
        </div>

    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="form-group">
                <%--                <label for="videoSource" align="center" class="col-sm-2 control-label"></label>--%>
                <div class="col-md-8">
                    <video id="videoSource" poster="${requestScope.play[1]}" width="100%" height="90%"
                           controls>
                        <source src="${requestScope.play[0]}" type="video/mp4">
                    </video>
                </div>
                <%--
                TODO: 鉴于视频和封面修改逻辑比较复杂, 这里暂时不引用视频和封面的修改
                <div class="col-sm-4">
                    <input type="file" class="form-control" id="video" name="videoPath" value="修改修改视频">
                </div>
                --%>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
</body>
</html>
