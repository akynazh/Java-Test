package com.web.java.jdbc.SimpleTest;

import java.sql.*;
import java.util.Scanner;

// 使用SQL注入
public class JdbcTest2 {
    public static void main(String[] args) {
        System.out.println("输入asc升序，输入desc降序");
        Scanner scan = new Scanner(System.in);
        String keywords = scan.next();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT ename FROM emp ORDER BY ename " + keywords;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jzh?useSSL=true", "root", "658766");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    conn.close();
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
}