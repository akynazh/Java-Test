package com.web.java.dbutil;

import com.web.java.beans.Dept;
import com.web.java.dbcp.JDBCUtils_DBCP;
import com.web.java.druid.JDBCUtils_DRUID;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class DbUtilTest {
    @Test
    public void queryTest() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils_DRUID.getConnection();
            String sql = "select DEPTNO deptno, DNAME dname, LOC loc from dept where DEPTNO = ?";
            String sql1 = "select DEPTNO deptno, DNAME dname, LOC loc from dept where DEPTNO > ?";

            BeanHandler<Dept> handler = new BeanHandler<>(Dept.class);
            BeanListHandler<Dept> handler1 = new BeanListHandler<>(Dept.class);
            ArrayHandler handler_a = new ArrayHandler();
            MapHandler handler_m = new MapHandler();

            Dept dept = runner.query(conn, sql, handler, 10);
            List<Dept> depts = runner.query(conn, sql1, handler1, 10);
            Object[] dept_a = runner.query(conn, sql, handler_a, 10);
            Map<String, Object> dept_m = runner.query(conn, sql, handler_m, 10);

            System.out.println(dept);
            System.out.println();
            // dept{deptno=10, dname=ACCOUNTING, loc=NEW YORK}

            System.out.println(dept_a[0] + " " + dept_a[1] + " " + dept_a[2]);
            System.out.println();
            // 10 ACCOUNTING NEW YORK

            System.out.println(dept_m);
            System.out.println();
            // {deptno=10, dname=ACCOUNTING, loc=NEW YORK}

            depts.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_DRUID.close(null, null, conn);
        }
    }
    @Test
    public void insertTest() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils_DBCP.getConnection();
            String sql = "insert into dept(deptno, dname, loc) value(?, ?, ?)";
            int count = runner.update(conn, sql, 160, "GAME", "BEIJING");
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_DBCP.close(null, null, conn);
        }
    }

    @Test
    public void maxTest() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils_DRUID.getConnection();
            String sql = "select max(sal) from emp";
            ScalarHandler handler = new ScalarHandler();
            double max_sal = (double) runner.query(conn, sql, handler);
            System.out.println(max_sal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_DRUID.close(null, null, conn);
        }
    }
}
