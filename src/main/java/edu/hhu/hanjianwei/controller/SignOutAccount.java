package edu.hhu.hanjianwei.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/27/2022 - 9:40 AM
 */
@WebServlet("/signOut")
public class SignOutAccount extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 注销功能
        boolean isUser = true;
        try {
            isUser = Boolean.parseBoolean(req.getParameter("isUser"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isUser) {
            req.getSession().setAttribute("user", null);
            resp.sendRedirect("/user/login.jsp");
        } else {
            req.getSession().setAttribute("admin", null);
            resp.sendRedirect("/admin/login.jsp");
        }
    }
}
