package com.web.java.jdbc.SimpleTest;

import java.sql.*;

/*
DROP TABLE IF EXISTS t_account;
CREATE TABLE t_account (
    num int,
    balance double(7, 2),
    primary key(num)
);
INSERT INTO t_account(num, balance) VALUES(1, 100);
INSERT INTO t_account(num, balance) VALUES(2, 0);
SELECT * FROM t_account;
 */
public class JdbcTest4 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count;
        String url = "jdbc:mysql://localhost:3306/jzh";
        String username = "root";
        String pwd = "658766";
        String sql = "UPDATE t_account SET balance = ? WHERE num = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, pwd);
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, 50);
            ps.setInt(2, 1);
            count = ps.executeUpdate();

            ps.setDouble(1, 50);
            ps.setInt(2, 2);
            count += ps.executeUpdate();

            if (count == 2) {
                conn.commit();
            }
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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
