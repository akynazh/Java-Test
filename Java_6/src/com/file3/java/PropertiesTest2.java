package com.file3.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest2 {
    public static void main(String[] args) {
        Properties pro = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream("Java_6/src/cache.properties");
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
