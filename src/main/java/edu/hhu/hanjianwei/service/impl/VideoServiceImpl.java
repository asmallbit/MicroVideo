package edu.hhu.hanjianwei.service.impl;

import edu.hhu.hanjianwei.dao.VideoDao;
import edu.hhu.hanjianwei.dao.impl.VideoDaoImpl;
import edu.hhu.hanjianwei.entity.Video;
import edu.hhu.hanjianwei.service.VideoService;

import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/25/2022 - 11:29 AM
 */
public class VideoServiceImpl implements VideoService {
    private VideoDao videoDao = new VideoDaoImpl();

    @Override
    public List<Video> queryAll() {
        return videoDao.selectAll();
    }

    @Override
    public int addVideo(Video video) {
        return videoDao.insertVideo(video);
    }

    @Override
    public int removeVideo(int id) {
        return videoDao.deleteById(id);
    }

    @Override
    public Video queryById(int id) {
        return videoDao.selectById(id);
    }

    @Override
    public int modifyVideo(Video video) {
        return videoDao.update(video);
    }
}
