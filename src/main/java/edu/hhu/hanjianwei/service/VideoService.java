package edu.hhu.hanjianwei.service;

import edu.hhu.hanjianwei.entity.Video;

import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/25/2022 - 11:28 AM
 */
public interface VideoService {
    List<Video> queryAll();

    int addVideo(Video video);
}
