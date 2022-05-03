package com.example.Java_8;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/house/room.html").forward(req, resp);
        // 实际上虽然跳转到了目标页面，但是本质路径如下，因此在跳转页面最好加上一个base标签
        // http://localhost:8080/ServletTest/forward  ->  http://localhost:8080/ServletTest/forward
    }
}
