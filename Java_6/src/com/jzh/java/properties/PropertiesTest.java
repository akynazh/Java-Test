package com.jzh.java.properties;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void test1() {
        Properties pro = new Properties();
        OutputStream os = null;
        try {
            os = new FileOutputStream("cache.properties");
            pro.setProperty("redis.server.address", "127.0.0.1");
            pro.setProperty("redis.server.port", "6379");
            pro.setProperty("redis.server.password", "123456");
            pro.setProperty("redis.server.timeout", "2000");
            pro.store(os, "缓存文件配置测试");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test2() {
        Properties pro = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream("cache.properties");
            pro.load(is);
            for (String key : pro.stringPropertyNames()) {
                System.out.println(key + "=" + pro.getProperty(key));
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
