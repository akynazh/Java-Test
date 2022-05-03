package com.web.java.jdbc.SimpleTest;

import java.sql.*;
import java.util.*;

public class JdbcTest3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String driver = "";
        String url = "";
        String username = "";
        String password = "";
        try {
            // Driver driver = new com.mysql.jdbc.Driver();
            // DriverManager.registerDriver(driver);
            ResourceBundle res = ResourceBundle.getBundle("jdbc"); // bundle默认位于src下
            driver = res.getString("driver");
            url = res.getString("url");
            username = res.getString("username");
            password = res.getString("password");

            System.out.println("hello");
            // Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connect to:" + conn);
            stmt = conn.createStatement();

            // int stmt.executeUpdate(insert/delete/update)
            // ResultSet executeQuery(select)
            String sql = "SELECT empno, ename, sal FROM emp";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("empno") + ", " +
                        rs.getString("ename") + ", " +
                        rs.getString("sal"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {

                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}