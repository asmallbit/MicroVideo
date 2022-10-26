package edu.hhu.hanjianwei.controller;

import edu.hhu.hanjianwei.entity.Video;
import edu.hhu.hanjianwei.service.VideoService;
import edu.hhu.hanjianwei.service.impl.VideoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 10:34 AM
 */
@WebServlet("/videoRemove")
public class VideoRemoveController extends HttpServlet {
    private final VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        //TODO: 删除磁盘中的数据 视频与封面
        final Video video = videoService.queryById(id);
        File videoFile = new File(req.getServletContext().getRealPath("/video_source") + video.getVideoPath());
        File coverFile = new File(req.getServletContext().getRealPath("/cover_source") + video.getCoverPath());
        final boolean videoDelete = videoFile.delete();
        final boolean coverDelete = coverFile.delete();
        if (!videoDelete) {
            System.out.println(video.getName() + " 视频文件删除失败!");
        }
        if (!coverDelete) {
            System.out.println(video.getName() + " 封面文件删除失败!");
        }

        // 删除数据库中的数据
        videoService.removeVideo(id);
        resp.sendRedirect("/videoList");
    }
}
