package com.example.Java_8.form.service;

import com.example.Java_8.form.bean.User;
import com.example.Java_8.form.dao.UserDao;
import com.example.Java_8.form.dao.impl.UserDaoImpl;

public interface UserService {
    UserDao userDao = new UserDaoImpl();
    public void register(User user);
    public boolean existsUsername(String username);
    public User login(User user);
}
