package com.example.Java_8.form.service.impl;

import com.example.Java_8.form.bean.User;
import com.example.Java_8.form.dao.UserDao;
import com.example.Java_8.form.dao.impl.UserDaoImpl;
import com.example.Java_8.form.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
