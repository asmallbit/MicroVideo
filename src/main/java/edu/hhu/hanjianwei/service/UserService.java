package edu.hhu.hanjianwei.service;

import edu.hhu.hanjianwei.entity.User;

import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 3:35 PM
 */
public interface UserService {
    User queryUser(String account);

    int addUser(User user);

    List<User> queryAllUsers();

    int modifyUser(User user);
}
