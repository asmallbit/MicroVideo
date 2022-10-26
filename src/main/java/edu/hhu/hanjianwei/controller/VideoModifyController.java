package edu.hhu.hanjianwei.controller;

import edu.hhu.hanjianwei.entity.Video;
import edu.hhu.hanjianwei.service.VideoService;
import edu.hhu.hanjianwei.service.impl.VideoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 12:42 PM
 */
@WebServlet("/videoModify")
public class VideoModifyController extends HttpServlet {
    final private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取用户填写的信息, 封装成Video对象
        final int id = Integer.parseInt(req.getParameter("id"));
        // TODO: 实现视频和封面的修改
//        final Video video = new Video(Integer.parseInt(req.getParameter("id")),
//                req.getParameter("name"), req.getParameter("author"),
//                req.getParameter("type"),
//                LocalDateTime.parse(req.getParameter("createTime"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//                Integer.parseInt("timeLength"), req.getParameter("video"),
//                req.getParameter("cover"), req.getParameter("description")
//        );

        LocalDateTime createTime = null;
        try {
            // 用户未修改时间, 时间会是yyyy-MM-dd'T'HH:mm:ss格式
            createTime = LocalDateTime.parse(req.getParameter("createTime"), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                // 用户修改了时间, 时间会是yyyy-MM-dd HH:mm:ss
                createTime = LocalDateTime.parse(req.getParameter("createTime"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        final Video video = new Video(Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"), req.getParameter("author"),
                req.getParameter("type"),
                createTime,
                Integer.parseInt(req.getParameter("timeLength")), req.getParameter("description")
        );

        // 2. 调用VideoService修改方法, 将数据封信到数据库中
        videoService.modifyVideo(video);

        // 3. 将页面跳转到视频列表页面
        resp.sendRedirect("/videoList");
    }
}
