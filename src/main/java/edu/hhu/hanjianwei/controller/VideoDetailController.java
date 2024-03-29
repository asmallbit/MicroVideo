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

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 10:33 AM
 */
@WebServlet("/videoDetail")
public class VideoDetailController extends HttpServlet {
    final private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        final Video video = videoService.queryById(id);
        if ("true".equals(req.getParameter("user"))) {
            req.setAttribute("video", video);
            req.getRequestDispatcher("/user/video/detail.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("video", video);
        req.getRequestDispatcher("/admin/video/detail.jsp").forward(req, resp);
    }
}
