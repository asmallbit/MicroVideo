package edu.hhu.hanjianwei.controller;

import edu.hhu.hanjianwei.entity.User;
import edu.hhu.hanjianwei.service.UserService;
import edu.hhu.hanjianwei.service.impl.UserServiceImpl;
import edu.hhu.hanjianwei.util.Patterns;
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
        // 验证电子邮箱
        if (!Patterns.EMAIL_ADDRESS.matcher(req.getParameter("email")).matches()) {
            // 不是电子邮箱
            String string = "请输入正确的电子邮箱";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            return;
        }
        // 日期为空
        if (date == null) {
            String string = "请选择出生日期";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            return;
        }
        // 账户被注册
        if (userService.queryUser(req.getParameter("account")) != null) {
            String string = "抱歉, 此账号已被注册, 请重新选择账户";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            return;
        }
        // 检验两次输入的密码是否相同
        String password = req.getParameter("password");
        String retypePassword = req.getParameter("passwordAgain");
        if (password == null || retypePassword == null || "".equals(password.trim()) ||
                !password.trim().equals(retypePassword.trim())) {
            // 密码不匹配
            String string = "抱歉请检查输入的密码是否为空或者两次输入的密码是否相同";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            return;
        }
        // 判断手机号码是否合法
        if (!Utility.isPhoneNumber(req.getParameter("phone"))) {
            String string = "抱歉, 您输入的手机号码不合法, 请重新检查您的输入";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
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
