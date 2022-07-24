package com.web.java.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT loc FROM t_dept WHERE loc LIKE ?";
        try {
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "上%");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("loc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(rs, ps, conn);
        }
    }
}