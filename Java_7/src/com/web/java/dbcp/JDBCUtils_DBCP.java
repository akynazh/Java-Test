package com.web.java.dbcp;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类，使用DBCP连接池
 * @Author Jzh
 */
public class JDBCUtils_DBCP {
    private static final Properties pro = new Properties();
    private static DataSource ds;

    // 加载dbcp配置文件
    static {
        try {
//            pro.load(ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties"));
            pro.load(ClassLoader.getSystemResourceAsStream("dbcp.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取数据源对象
        try {
            ds = BasicDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JDBCUtils_DBCP(){}

    /**
     * 从连接池中获取一个连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
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
