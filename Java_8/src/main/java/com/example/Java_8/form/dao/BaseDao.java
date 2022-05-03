package com.example.Java_8.form.dao;

import com.example.Java_8.form.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

public class BaseDao {
    private final QueryRunner runner = new QueryRunner();
    public int update(String sql, Object...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return  runner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, null, conn);
        }
        return -1;
    }
    public <T> T query(Class<T> type, String sql, Object...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, null, conn);
        }
        return null;
    }
}
