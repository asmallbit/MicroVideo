package edu.hhu.hanjianwei.dao.impl;

import edu.hhu.hanjianwei.dao.UserDao;
import edu.hhu.hanjianwei.entity.User;
import edu.hhu.hanjianwei.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

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
}
