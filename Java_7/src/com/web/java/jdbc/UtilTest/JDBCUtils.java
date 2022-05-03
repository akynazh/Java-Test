package com.web.java.jdbc.UtilTest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * author: jzh
 * JDBC工具类， 简化JDBC编程
 */
public class JDBCUtils {
    private static final ResourceBundle rsb;
    /**
     * 工具类中的构造方法都是私有的
     * 因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用
     */
    private JDBCUtils() {}

    // 静态代码块在类加载时执行，且只执行一次
    static {
        rsb = ResourceBundle.getBundle("jdbc");
        try {
            Class.forName(rsb.getString("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return 返回Connection对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(rsb.getString("url"), rsb.getString("username"), rsb.getString("password"));
    }

    /**
     * 关闭资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
