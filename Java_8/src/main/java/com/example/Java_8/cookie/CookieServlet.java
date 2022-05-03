package com.example.Java_8.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("jzh".equals(username) && "658766".equals(password)) {
            Cookie cookie1 = new Cookie("username", username);
            cookie1.setMaxAge(60 * 60 * 24);
            resp.addCookie(cookie1);
            Cookie cookie2 = new Cookie("password", password);
            cookie2.setMaxAge(60 * 60);
            resp.addCookie(cookie2);
            System.out.println("success");
        }
    }
}
