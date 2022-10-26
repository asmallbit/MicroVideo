package edu.hhu.hanjianwei.controller;

import edu.hhu.hanjianwei.entity.User;
import edu.hhu.hanjianwei.service.UserService;
import edu.hhu.hanjianwei.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 3:31 PM
 */
@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        User user = userService.queryUser(account);
        if (user == null) {
            // 不存在此用户
            resp.sendRedirect("/user/login_fail.jsp");
        } else {
            if (password != null && password.trim().equals(user.getPassword())) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/user/video/list.jsp");
            } else {
                // 密码输入错误
                resp.sendRedirect("/user/login_fail.jsp");
            }
        }
    }
}
