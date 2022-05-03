package com.web.java.jdbc.UtilTest;

import com.web.java.jdbc.UtilTest.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            /*
            * MYSQL默认关闭批处理，可通过一个参数让其开启，在配置文件中url后面
            * 添加?rewriteBatchedStatements=true即可
            * */
            for (int i = 1; i <= 100000; i++) {
                ps.setObject(1, "name_" + i);
                ps.addBatch();
                if (i % 1000 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            conn.commit();
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, ps, conn);
        }
    }
}
