package com.web.java.jdbc.UtilTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ename FROM emp WHERE ename LIKE ?";
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "_A%");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
    }
}
