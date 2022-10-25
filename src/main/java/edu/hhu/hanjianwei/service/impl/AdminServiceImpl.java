package edu.hhu.hanjianwei.service.impl;

import edu.hhu.hanjianwei.dao.AdminDao;
import edu.hhu.hanjianwei.dao.impl.AdminDaoImpl;
import edu.hhu.hanjianwei.entity.Admin;
import edu.hhu.hanjianwei.service.AdminService;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/24/2022 - 3:54 PM
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();


    @Override
    public Admin login(String account, String password) {
        return adminDao.selectByAccountAndPassword(account, password);
    }
}
