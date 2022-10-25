package edu.hhu.hanjianwei.dao.impl;

import edu.hhu.hanjianwei.dao.VideoDao;
import edu.hhu.hanjianwei.entity.Video;
import edu.hhu.hanjianwei.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/25/2022 - 11:24 AM
 */
public class VideoDaoImpl implements VideoDao {
    QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDruidDataSource());

    @Override
    public List<Video> selectAll() {
        String sql = "SELECT id, name, author, type, create_time as createTime, time_length as timeLength, "
                + "video_path as videoPath, cover_path as coverPath, description "
                + "from t_video ";
        List<Video> videoList = null;
        try {
            videoList = queryRunner.query(sql, new BeanListHandler<>(Video.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videoList;
    }

    @Override
    public int insertVideo(Video video) {
        String sql = "INSERT INTO t_video (name, author, type, create_time, time_length, video_path, cover_path, description) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] paramArray = new Object[]{
                video.getName(), video.getAuthor(), video.getType(),
                video.getCreateTime(), video.getTimeLength(), video.getVideoPath(),
                video.getCoverPath(), video.getDescription()
        };
        try {
            return queryRunner.update(sql, paramArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
