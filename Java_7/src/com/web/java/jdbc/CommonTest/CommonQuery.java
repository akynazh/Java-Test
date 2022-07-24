package com.web.java.jdbc.CommonTest;

import com.web.java.beans.Dept;
import com.web.java.jdbc.UtilTest.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class CommonQuery {
    @Test
    public void test() {
        String sql = "SELECT deptno, dname, loc FROM t_dept WHERE deptno = ?";
                          // 列名   类中变量名
        Dept dept = query(sql, 10);
        System.out.println(dept);
    }
    public Dept query(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            rs = ps.executeQuery();

            // 由于不知道需要得到的一共有多少个数据，所以需要获取列数

            // 获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取结果集列数
            int count = rsmd.getColumnCount();
            if (rs.next()) {
                System.out.println("ok");
                Dept dept = new Dept();
                for (int i = 0; i < count; i++) {
                    Object obj = rs.getObject(i+1);
                    // 得到对象的名称， 对应类的变量名需要一致
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    System.out.println(columnLabel);
                    Field field = Dept.class.getDeclaredField(columnLabel);
                    // label 即获取别名，即类中变量名，若无别名，则默认列名
                    field.setAccessible(true);
                    field.set(dept, obj);
                }
                return dept;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
        return null;
    }

}
