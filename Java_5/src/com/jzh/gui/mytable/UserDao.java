package com.jzh.gui.mytable;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/18 23:14
 */
public class UserDao {
    public static List<User> getUsers() throws SQLException {
        Connection conn = DruidUtil.getConnection();
        String sql = "select * from t_user";
        BeanListHandler<User> handler = new BeanListHandler<>(User.class);
        QueryRunner runner = new QueryRunner();
        List<User> users = runner.query(conn, sql, handler);
        DruidUtil.close(conn);
        return users;
    }
}
