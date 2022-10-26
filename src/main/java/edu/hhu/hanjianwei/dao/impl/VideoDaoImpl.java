package edu.hhu.hanjianwei.dao.impl;

import edu.hhu.hanjianwei.dao.VideoDao;
import edu.hhu.hanjianwei.entity.Video;
import edu.hhu.hanjianwei.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM t_video WHERE id = ?";
        try {
            return queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Video selectById(int id) {
        String sql = "SELECT id, name, author, type, create_time as createTime, time_length as timeLength, "
                + "video_path as videoPath, cover_path as coverPath, description "
                + "from t_video WHERE id = ?";
        Video video = null;
        try {
            video = queryRunner.query(sql, new BeanHandler<>(Video.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return video;
    }

    @Override
    public int update(Video video) {
        String sql = "UPDATE t_video SET name = ?, author = ?, type = ?, create_time = ?, " +
                "time_length = ?, description = ?" +
                "WHERE id = ?";
        Object[] paramArray = {video.getName(), video.getAuthor(), video.getType(),
                video.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                String.valueOf(video.getTimeLength()), video.getDescription(), video.getId()};
        try {
            return queryRunner.update(sql, paramArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
