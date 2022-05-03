package com.example.Java_8.ajax;

import com.example.Java_8.BaseServlet;
import com.example.Java_8.Person;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {
    public void ajax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Person person = new Person(18, "团子");
        Gson gson = new Gson();
        String jsonString = gson.toJson(person);
        resp.getWriter().write(jsonString);
    }
    public void ajax1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Person person = new Person(18, "雪乃");
        Gson gson = new Gson();
        String jsonString = gson.toJson(person);
        resp.getWriter().write(jsonString);
    }
}
