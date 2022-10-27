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
import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/27/2022 - 9:21 AM
 */
@WebServlet("/userRemove")
public class UserRemoveController extends HttpServlet {
    final private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("id");
        // 删除用户
        userService.removeUserByAccount(account);
        // 获取删除后的所有用户并更新视图
        List<User> users = userService.queryAllUsers();
        req.getSession().setAttribute("users", users);
        resp.sendRedirect("/admin/user/userList.jsp");
    }
}
