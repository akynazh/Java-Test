package com.example.Java_8.form.dao.impl;

import com.example.Java_8.form.bean.User;
import com.example.Java_8.form.dao.BaseDao;
import com.example.Java_8.form.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
    BaseDao baseDao = new BaseDao();
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select username, password, description from t_user where username = ?";
        return baseDao.query(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select username, password, description from t_user where username = ? and password = ?";
        return baseDao.query(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, password, description) values(?, ?, ?)";
        return baseDao.update(sql, user.getUsername(), user.getPassword(), user.getDescription());
    }
}
