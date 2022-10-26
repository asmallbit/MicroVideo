package edu.hhu.hanjianwei.controller;

import edu.hhu.hanjianwei.entity.User;
import edu.hhu.hanjianwei.service.UserService;
import edu.hhu.hanjianwei.service.impl.UserServiceImpl;
import edu.hhu.hanjianwei.util.Utility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 9:11 PM
 */
@WebServlet("/userModify")
public class UserModify extends HttpServlet {
    final private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id1 = req.getParameter("id");    // 在用户列表点击修改定向而来
        String id2 = req.getParameter("realAccount"); // 从修改信息界面重定向而来
        String account = id1 == null ? id2 : id1;
//        req.getParameterNames();
        if (account.equals(id1)) {
            // 即用户从点击修改button定向而来
            User user = userService.queryUser(account);
            req.setAttribute("userToModify", user);
            req.getRequestDispatcher("/admin/user/userModify.jsp").forward(req, resp);
        } else {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthday"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ("".equals(req.getParameter("password")) || req.getParameter("password") == null) {
                String string = "密码不能为空";
                req.setAttribute("error", string);
                req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
                return;
            }
            if (!Utility.isUserDataLegal(req, resp, date, false)) {
                return;
            }
            // 数据合法, 继续操作
            User user = new User(req.getParameter("nickName"), req.getParameter("account"),
                    req.getParameter("password"), Boolean.parseBoolean(req.getParameter("gender")),
                    date, req.getParameter("phone"), req.getParameter("email"),
                    req.getParameter("description"), req.getParameter("realAccount"));
            userService.modifyUser(user);
            List<User> users = userService.queryAllUsers();
            req.getSession().setAttribute("users", users);
            resp.sendRedirect("/admin/user/userList.jsp");
        }
    }
}
