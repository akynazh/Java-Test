package com.web.java.jdbc.CommonTest;

import com.web.java.beans.Dept;
import com.web.java.beans.User;
import com.web.java.jdbc.UtilTest.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class CommonClass {
    @Test
    public void test() {
        String sql = "SELECT DEPTNO deptno, DNAME dname, LOC loc FROM dept WHERE DEPTNO = ?";
        // 列名   类中变量名
        Dept dept = query(Dept.class, sql, 10);
        System.out.println(dept);
        sql = "SELECT username, password FROM t_user WHERE username = ?";
        User user = query(User.class, sql, "akynazh");
        System.out.println(user);
    }
    // 返回多个对象 public <T> List<T> query(...)
    public <T> T query(Class<T> clazz, String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 设置查询条件
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            // 执行查询
            rs = ps.executeQuery();

            // 获取结果集列数
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            if (rs.next()) {
                System.out.println("ok");
                // 生成出查询对象
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < count; i++) {
                    // 获取所查询对象某一变量的值
                    Object obj = rs.getObject(i+1);
                    // 得到查询对象类变量的名称，变量名需要一致，列名不需要和类中变量一致，但前提是有别名且别名对应一致
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    System.out.println(columnLabel);
                    // 通过反射得到对应类中的变量
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, obj);
                }
                return t;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
        return null;
    }
}