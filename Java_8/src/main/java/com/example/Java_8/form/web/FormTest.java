package com.example.Java_8.form.web;

import com.example.Java_8.form.bean.User;
import com.example.Java_8.form.service.UserService;
import com.example.Java_8.form.service.impl.UserServiceImpl;
import com.example.Java_8.form.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        String description = "";
        UserService userService = new UserServiceImpl();
        User user = new User(username, password, null);
        System.out.println(user);

        if (type.equals("Register")) {
            description = req.getParameter("description");
            if (userService.existsUsername(username)) {
                req.getRequestDispatcher("/form/fail.html").forward(req, resp);
            } else {
                userService.register(new User(username, password, description));
                req.getRequestDispatcher("/form/success.html").forward(req, resp);
            }
        } else {
            if (userService.login(new User(username, password, null)) != null) {
                req.getRequestDispatcher("/form/success.html").forward(req, resp);
            } else {
                req.getRequestDispatcher("/form/fail.html").forward(req, resp);
            }
        }
    }
}
