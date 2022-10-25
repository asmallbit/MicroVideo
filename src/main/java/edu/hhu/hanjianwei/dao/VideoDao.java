package edu.hhu.hanjianwei.dao;

import edu.hhu.hanjianwei.entity.Video;

import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/25/2022 - 11:23 AM
 */
public interface VideoDao {
    List<Video> selectAll();
    int insertVideo(Video video);
}
