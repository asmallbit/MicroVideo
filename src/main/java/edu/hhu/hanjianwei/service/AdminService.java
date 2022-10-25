package edu.hhu.hanjianwei.service;

import edu.hhu.hanjianwei.entity.Admin;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/24/2022 - 3:53 PM
 */
public interface AdminService {
    Admin login(String account, String password);
}
