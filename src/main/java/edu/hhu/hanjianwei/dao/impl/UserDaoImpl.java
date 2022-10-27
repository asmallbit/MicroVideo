package edu.hhu.hanjianwei.dao.impl;

import edu.hhu.hanjianwei.dao.UserDao;
import edu.hhu.hanjianwei.entity.User;
import edu.hhu.hanjianwei.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 3:32 PM
 */
public class UserDaoImpl implements UserDao {
    final QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDruidDataSource());

    @Override
    public User queryByAccount(String account) {
        String sql = "SELECT account, nick_name as nickName, password, " +
                "gender, birthday, phone, email, description " +
                "FROM t_user WHERE account = ?";
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO t_user (account, nick_name, password, " +
                "gender, birthday, phone, email, description) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{user.getAccount(), user.getNickName(),
                user.getPassword(), user.isGender(), user.getBirthday(),
                user.getPhone(), user.getEmail(), user.getDescription()};
        try {
            return queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<User> selectAllUsers() {
        String sql = "SELECT account, nick_name as nickName, password, " +
                "gender, birthday, phone, email, description FROM t_user";
        List<User> users = null;
        try {
            users = queryRunner.query(sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int updateUser(User user) {
        String sql = "UPDATE t_user SET account = ?, nick_name = ?, password = ?, " +
                "gender = ?, birthday = ?, phone = ?, email = ?, description = ? " +
                "WHERE account = ?";
        Object[] params = {user.getAccount(), user.getNickName(), user.getPassword(),
                user.isGender(), user.getBirthday(), user.getPhone(), user.getEmail(),
                user.getDescription(), user.getRealAccount()};
        try {
            return queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteByAccount(String account) {
        String sql = "DELETE FROM t_user WHERE account = ?";
        try {
            return queryRunner.update(sql, account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
