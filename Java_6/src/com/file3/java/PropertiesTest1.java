package com.file3.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesTest1 {
    public static void main(String[] args) {
        Properties pro = new Properties();
        OutputStream os = null;
        try {
            os = new FileOutputStream("Java_6/src/cache.properties");
            pro.setProperty("redis.server.address", "127.0.0.1");
            pro.setProperty("redis.server.port", "6379");
            pro.setProperty("redis.server.password", "");
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
}
