package com.web.java.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ename FROM emp WHERE ename LIKE ?";
        try {
            conn = JDBCUtils_DRUID.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "_A%");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_DRUID.close(rs, ps, conn);
        }
    }
}