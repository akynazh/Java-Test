package com.example.Java_8.form.dao;

import com.example.Java_8.form.bean.User;

public interface UserDao {
    public User queryUserByUsername(String username);
    public User queryUserByUsernameAndPassword(String username, String password);
    public int saveUser(User user);
}
