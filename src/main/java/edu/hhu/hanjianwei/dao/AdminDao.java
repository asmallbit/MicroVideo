package edu.hhu.hanjianwei.dao;

import edu.hhu.hanjianwei.entity.Admin;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/24/2022 - 2:49 PM
 */

public interface AdminDao {
    Admin selectByAccountAndPassword(String account, String password);
}
