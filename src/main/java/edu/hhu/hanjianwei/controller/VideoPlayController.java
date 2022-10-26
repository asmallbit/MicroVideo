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
 * @date 10/26/2022 - 6:43 PM
 */
@WebServlet("/watchVideo")
public class VideoPlayController extends HttpServlet {
    private final VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        final Video video = videoService.queryById(id);
        // 存储视频和封面地址
        String[] values = new String[]{
                "/video_source" + video.getVideoPath(),
                "/cover_source" + video.getCoverPath(),
                video.getName()
        };
        req.setAttribute("play", values);
        req.getRequestDispatcher("/user/video/play.jsp").forward(req, resp);
    }
}
