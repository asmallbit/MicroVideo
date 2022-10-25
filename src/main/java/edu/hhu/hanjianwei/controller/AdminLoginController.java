package edu.hhu.hanjianwei.controller;

import edu.hhu.hanjianwei.entity.Admin;
import edu.hhu.hanjianwei.service.AdminService;
import edu.hhu.hanjianwei.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/24/2022 - 2:43 PM
 */

@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取管理员的账号密码
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        // 2. 运行数据验证(根据账号和密码去数据库查找,是否有此人)
        Admin admin = adminService.login(account, password);
        // 3. 登陆成功或失败
        if (admin != null) {
            req.getSession().setAttribute("admin", admin);
            resp.sendRedirect("/admin/video/list.jsp");
        } else {
            resp.sendRedirect("/admin/login_fail.jsp");
        }
    }
}
