package com.web.java.jdbc.CommonTest;

import com.web.java.jdbc.UtilTest.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * common update
 * author: Jzh
 */
public class CommonUpdate {
    @Test
    public void test() {
        String sql = "UPDATE t_dept SET loc = ? WHERE deptno = ?";
        update(sql, "湖北", 10);
        System.out.println("ok");
    }
    public void update(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, ps, conn);
        }
    }
}
