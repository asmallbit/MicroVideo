package edu.hhu.hanjianwei.controller;

import edu.hhu.hanjianwei.entity.Video;
import edu.hhu.hanjianwei.service.VideoService;
import edu.hhu.hanjianwei.service.impl.VideoServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/25/2022 - 4:27 PM
 */

@WebServlet("/videoAdd")
public class VideoAddController extends HttpServlet {
    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> itemList = null;
        Video video = new Video();
        // 创建存储视频和封面的目录
        File videoFolder = new File(req.getServletContext().getRealPath("/video_source"));
        if (!videoFolder.exists()) {
            videoFolder.mkdirs();
        }
        File coverFolder = new File(req.getServletContext().getRealPath("/cover_source"));
        if (!coverFolder.exists()) {
            coverFolder.mkdirs();
        }

        // 1. 获取用户填写或者选择的信息, 将信息封装成Video对象
        try {
            itemList = upload.parseRequest(req);
            for (FileItem fileItem : itemList) {
                // 如果是普通文本
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("name")) {
                        video.setName(value);
                    } else if (name.equals("author")) {
                        video.setAuthor(value);
                    } else if (name.equals("type")) {
                        video.setType(value);
                    } else if (name.equals("createTime")) {
                        video.setCreateTime(LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    } else if (name.equals("timeLength")) {
                        video.setTimeLength(Integer.parseInt(value));
                    } else if ("description".equals(name)) {
                        video.setDescription(value);
                    }
                }
                // 如果不是普通文本(就是文件上传域)
                else {
                    String fileName = fileItem.getName(); // xxx.mp4
                    // 获取文件的后缀名
                    String fileSuffix = fileName.substring(fileName.lastIndexOf(".")); // .mp4
                    fileName = UUID.randomUUID().toString();
                    if (".mp4".equalsIgnoreCase(fileSuffix) || ".avi".equalsIgnoreCase(fileSuffix)) {
                        String uploadFileName = req.getServletContext().getRealPath("/video_source/") + fileName + fileSuffix;
                        // 将视频路径设置给video对象
                        video.setVideoPath("/" + fileName + fileSuffix);
                        // 使用IO流将数据上传到服务器指定位置
                        InputStream is = fileItem.getInputStream();
                        OutputStream os = new FileOutputStream(uploadFileName);
                        byte[] bytes = new byte[1024 * 4];
                        int length = 0;
                        while ((length = is.read(bytes)) != -1) {
                            os.write(bytes, 0, length);
                        }
                        is.close();
                        os.close();
                    } else {
                        //TODO: 图片 else if instead of else
                        String uploadFileName = req.getServletContext().getRealPath("/cover_source/") + fileName + fileSuffix;
                        // 将视频路径设置给video对象
                        video.setCoverPath("/" + fileName + fileSuffix);
                        // 使用IO流将数据上传到服务器指定位置
                        InputStream is = fileItem.getInputStream();
                        OutputStream os = new FileOutputStream(uploadFileName);
                        byte[] bytes = new byte[1024 * 4];
                        int length = 0;
                        while ((length = is.read(bytes)) != -1) {
                            os.write(bytes, 0, length);
                        }
                        is.close();
                        os.close();
                    }


                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        System.out.println("Video => " + video);
        // 2. 调用服务方法添加到数据库中
        videoService.addVideo(video);
        // 3. 将页面跳转到视频列表页面
        resp.sendRedirect("/videoList");
    }
}
