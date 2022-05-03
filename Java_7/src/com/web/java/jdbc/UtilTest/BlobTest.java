package com.web.java.jdbc.UtilTest;

import com.web.java.jdbc.UtilTest.JDBCUtils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BlobTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_star(no, name, pic) VALUES(?, ?, ?)";
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            FileInputStream fis = new FileInputStream(new File("Java_7/pics/2.jpg"));
            ps.setObject(1, 2);
            ps.setObject(2, "Tony");
            ps.setBlob(3, fis);
            ps.executeUpdate();
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, ps, conn);
        }
    }
}
