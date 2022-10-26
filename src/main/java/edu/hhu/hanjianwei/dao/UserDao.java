package edu.hhu.hanjianwei.dao;

import edu.hhu.hanjianwei.entity.User;

import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 3:32 PM
 */
public interface UserDao {
    User queryByAccount(String account);

    int insertUser(User user);

    List<User> selectAllUsers();
}
