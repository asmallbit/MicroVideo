package edu.hhu.hanjianwei.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 7:23 PM
 */
public class Utility {
    public static boolean isPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(16[5,6])|(17[0-8])|(18[0-9])|(19[1、5、8、9]))\\d{8}$";
        if (phoneNumber.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoneNumber);
            return m.matches();
        }
    }

    /**
     * check whether the user data is legal
     *
     * @param req          the HttpServletRequest object that contains the request the client made of the servlet
     * @param resp         the HttpServletResponse object that contains the response the servlet returns to the client
     * @param date         date of birth
     * @param isNeedRetype if the retype is needed
     * @return return true if the user data is legal, return false if not
     * @throws ServletException
     * @throws IOException
     */
    public static boolean isUserDataLegal(HttpServletRequest req, HttpServletResponse resp,
                                          Date date, boolean isNeedRetype)
            throws ServletException, IOException {
        // 验证电子邮箱
        if (!Patterns.EMAIL_ADDRESS.matcher(req.getParameter("email")).matches()) {
            // 不是电子邮箱
            String string = "请输入正确的电子邮箱";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            return false;
        }
        if (date == null) {
            String string = "请选择出生日期";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            return false;
        }
        // 检验两次输入的密码是否相同
        String password = req.getParameter("password");
        if (isNeedRetype) {
            String retypePassword = req.getParameter("passwordAgain");
            if (password == null || retypePassword == null || "".equals(password.trim()) ||
                    !password.trim().equals(retypePassword.trim())) {
                // 密码不匹配
                String string = "抱歉请检查输入的密码是否为空或者两次输入的密码是否相同";
                req.setAttribute("error", string);
                req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
                return false;
            }
        } else {
            if (password == null || "".equals(password.trim())) {
                String string = "抱歉设置的密码不能为空";
                req.setAttribute("error", string);
                req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            }
        }
        // 密码过长, 最长为32位
        if (password.trim().length() > 32) {
            String string = "抱歉, 密码长度上限为32位, 请重新设置密码";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
        }
        // 判断手机号码是否合法
        if (!Utility.isPhoneNumber(req.getParameter("phone"))) {
            String string = "抱歉, 您输入的手机号码不合法, 请重新检查您的输入";
            req.setAttribute("error", string);
            req.getRequestDispatcher("/user/error.jsp").forward(req, resp);
            return false;
        }
        return true;
    }
}
