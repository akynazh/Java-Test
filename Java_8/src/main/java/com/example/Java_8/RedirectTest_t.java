package com.example.Java_8;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectTest_t extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        // 获取url中?username="..."
        System.out.println("成功将用户" + username + "从RedirectTest重定向到RedirectTest_t");
        Object key = req.getAttribute("key");
        System.out.println("从RedirectTest获得key" + key);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
