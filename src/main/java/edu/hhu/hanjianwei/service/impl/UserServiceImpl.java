package edu.hhu.hanjianwei.service.impl;

import edu.hhu.hanjianwei.dao.UserDao;
import edu.hhu.hanjianwei.dao.impl.UserDaoImpl;
import edu.hhu.hanjianwei.entity.User;
import edu.hhu.hanjianwei.service.UserService;

import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 3:36 PM
 */
public class UserServiceImpl implements UserService {
    final UserDao userDao = new UserDaoImpl();

    @Override
    public User queryUser(String account) {
        return userDao.queryByAccount(account);
    }

    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public List<User> queryAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int removeUserByAccount(String account) {
        return userDao.deleteByAccount(account);
    }
}
