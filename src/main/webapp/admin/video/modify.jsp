<%@ page import="edu.hhu.hanjianwei.entity.Video" %><%--
  Created by IntelliJ IDEA.
  User: jwhan
  Date: 10/26/2022
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台视频修改页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-12" align="center" style="margin-top: 30px">
            <h3>修改视频</h3>
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
            <form class="form-horizontal" action="${pageContext.request.contextPath}/videoModify"
                  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${requestScope.video.name}">
                        <input type="hidden" name="id" value="${requestScope.video.id}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">作者:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="author" name="author"
                               value="${requestScope.video.author}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="type" class="col-sm-2 control-label">视频类型:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="type" name="type">
                            <option value="War"
                                    <%=((Video) request.getAttribute("video")).getType().equals("War") ? "selected=\"selected\":''" : ""%>>
                                War
                            </option>
                            <option value="Adventure" <%=((Video) request.getAttribute("video")).getType().equals("Adventure") ? "selected=\"selected\":''" : ""%>>
                                Adventure
                            </option>
                            <option value="Action" <%=((Video) request.getAttribute("video")).getType().equals("Action") ? "selected=\"selected\":''" : ""%>>
                                Action
                            </option>
                            <option value="Comedy" <%=((Video) request.getAttribute("video")).getType().equals("Adventure") ? "selected=\"selected\":''" : ""%>>
                                Comedy
                            </option>
                            <option value="Drama"
                                    <%=((Video) request.getAttribute("video")).getType().equals("Drama") ? "selected=\"selected\":''" : ""%>>
                                Drama
                            </option>
                            <option value="Horror" <%=((Video) request.getAttribute("video")).getType().equals("Horror") ? "selected=\"selected\":''" : ""%>>
                                Horror
                            </option>
                            <option value="Romance" <%=((Video) request.getAttribute("video")).getType().equals("Romance") ? "selected=\"selected\":''" : ""%>>
                                Romance
                            </option>
                            <option value="Fantasy" <%=((Video) request.getAttribute("video")).getType().equals("Fantasy") ? "selected=\"selected\":''" : ""%>>
                                Fantasy
                            </option>
                            <option value="Historical" <%=((Video) request.getAttribute("video")).getType().equals("Historical") ? "selected=\"selected\":''" : ""%>>
                                Historical
                            </option>
                            <option value="Others" <%=((Video) request.getAttribute("video")).getType().equals("Others") ? "selected=\"selected\":''" : ""%>>
                                Others
                            </option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="createTime" class="col-sm-2 control-label">创建时间:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="createTime" name="createTime"
                               onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                               value="${requestScope.video.createTime.toString()}"
                               readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label for="timeLength" class="col-sm-2 control-label">时长:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="timeLength" name="timeLength"
                               value="${requestScope.video.timeLength}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="videoSource" class="col-sm-2 control-label">视频:</label>
                    <div class="col-md-6">
                        <video id="videoSource" poster="/cover_source${requestScope.video.coverPath}" width="320"
                               height="240" controls>
                            <source src="/video_source${requestScope.video.videoPath}" type="video/mp4">
                        </video>
                    </div>
                    <%--
                    TODO: 鉴于视频和封面修改逻辑比较复杂, 这里暂时不引用视频和封面的修改
                    <div class="col-sm-4">
                        <input type="file" class="form-control" id="video" name="videoPath" value="修改修改视频">
                    </div>
                    --%>
                </div>
                <%--
                <div class="form-group">
                    <label for="coverImage" class="col-sm-2 control-label">更新封面:</label>
                    <div class="col-sm-4">
                        <div class="col-sm-10">
                            <img id="coverImage"
                                 src="${pageContext.request.contextPath}/cover_source/${requestScope.video.coverPath}"
                                 alt="暂时无法显示"
                                 width="150" height="150"/>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <input type="file" class="form-control" id="cover" name="coverPath" value="修改封面">
                    </div>
                    <div class="col-md-3"></div>
                </div>
                --%>
                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">视频描述:</label>
                    <div class="col-sm-10">
                        <textarea id="description" name="description" style="resize: none;" class="form-control"
                                  rows="5">${requestScope.video.description}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4"></div>
                    <div class="col-md-4" style="text-align: center">
                        <input class="btn btn-success" type="submit" value="修改"/>
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
