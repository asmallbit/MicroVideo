package edu.hhu.hanjianwei.dao.impl;

import edu.hhu.hanjianwei.dao.AdminDao;
import edu.hhu.hanjianwei.entity.Admin;
import edu.hhu.hanjianwei.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/24/2022 - 2:51 PM
 */
public class AdminDaoImpl implements AdminDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDruidDataSource());

    @Override
    public Admin selectByAccountAndPassword(String account, String password) {
        String sql = "SELECT id, name, account, password " +
                "FROM t_admin " +
                "WHERE account = ? AND password = ?";
        Admin admin = null;
        try {
            // test the propertity
            admin = queryRunner.query(sql, new BeanHandler<>(Admin.class), account, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
