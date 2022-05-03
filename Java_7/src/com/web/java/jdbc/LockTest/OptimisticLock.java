package com.web.java.jdbc.LockTest;

import com.web.java.jdbc.UtilTest.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OptimisticLock {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "SELECT ename FROM emp WHERE job = ? FOR UPDATE";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "MANAGER");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("ename"));
            }
            Thread.sleep(8000); // FOR UPDATE: 在事务未commit之前, TryToChange会被阻塞
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
    }
}
