package com.web.java.jdbc;

import com.web.java.jdbc.UtilTest.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

// interface CustomerDAO
// class CustomerDAOImpl extends BaseDAO implement CustomerDAO
public abstract class BaseDAO {
    /**
     * 查
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T query(Connection conn, Class<T> clazz, String sql, Object ...args) {
        // 返回多个对象则： public <T> List<T> query(...)
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
            JDBCUtils.close(rs, ps, null);
        }
        return null;
    }

    /**
     * 改 删 增
     * @param sql
     * @param args
     */
    public void update(Connection conn, String sql, Object ...args) {
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
            JDBCUtils.close(null, ps, null);
        }
    }
}
