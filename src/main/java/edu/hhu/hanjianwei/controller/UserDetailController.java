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
 * @date 10/26/2022 - 8:57 PM
 */
@WebServlet("/userDetail")
public class UserDetailController extends HttpServlet {
    final private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.queryUser(req.getParameter("id"));
        req.setAttribute("userDetail", user);
        req.getRequestDispatcher("/admin/user/userDetails.jsp").forward(req, resp);
    }
}
