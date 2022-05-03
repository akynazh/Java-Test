package com.web.java.jdbc.SimpleTest;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JdbcTest1 {
    public static void main(String[] args) {
        Map<String, String> userLoginInfo = initUI();
        System.out.println("你的用户名：" + userLoginInfo.get("loginName"));
        System.out.println("你的密码：" + userLoginInfo.get("loginPwd"));
        boolean loginSuccess = login(userLoginInfo);
        System.out.println(loginSuccess ? "success" : "fail");
    }

    private static boolean login(Map<String, String> userLoginInfo) {
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        boolean loginSuccess = false;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/jzh";
        String user = "root";
        String pwd = "658766";
        String sql = "SELECT * FROM t_user WHERE username = ? and password = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            ps = conn.prepareStatement(sql);
            ps.setString(1, loginName);
            ps.setString(2, loginPwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                loginSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return loginSuccess;
    }

    private static Map<String, String> initUI() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String loginName = in.nextLine();
        System.out.println("请输入密码：");
        String loginPwd = in.nextLine();
        Map<String, String> m = new HashMap<>();
        m.put("loginPwd", loginPwd);
        m.put("loginName", loginName);
        return m;
    }
}
