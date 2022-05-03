package com.web.java.jdbc.LockTest;

import com.web.java.jdbc.UtilTest.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TryToChange {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "UPDATE emp SET sal = sal * 1.1 WHERE job = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "MANAGER");
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, ps, conn);
        }
    }
}
