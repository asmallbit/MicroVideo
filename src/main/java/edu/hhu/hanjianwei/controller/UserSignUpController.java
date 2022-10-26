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

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 5:03 PM
 */
@WebServlet("/userSignUp")
public class UserSignUpController extends HttpServlet {
    private UserService userService = new UserServiceImpl();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthday"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 账户被注册
        if (userService.queryUser(req.getParameter("account")) != null) {
            String string = "抱歉, 此账号已被注册, 请重新选择账户";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            return;
        }
        if (!Utility.isUserDataLegal(req, resp, date, true)) {
            return;
        }
        User user = new User(req.getParameter("nickName"), req.getParameter("account"),
                req.getParameter("password"), Boolean.parseBoolean(req.getParameter("gender")),
                date, req.getParameter("phone"), req.getParameter("email"),
                req.getParameter("description"));
        userService.addUser(user);
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/user/video/list.jsp");
    }
}
