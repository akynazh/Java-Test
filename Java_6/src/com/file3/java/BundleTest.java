package com.file3.java;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleTest {
    public static void main(String[] args) {
//        Locale locale1 = new Locale("zh", "CN");
//        Locale locale2 = new Locale("en", "US");
        Locale locale1 = Locale.CHINA;
        Locale locale2 = Locale.US;
        System.out.println(Locale.getDefault()); // zh_CN

        ResourceBundle res;
        res = ResourceBundle.getBundle("my", locale1);
        System.out.println(res.getString("name"));

        res = ResourceBundle.getBundle("my", locale2);
        System.out.println(res.getString("name"));

        res = ResourceBundle.getBundle("my");
        System.out.println(res.getString("name"));
    }
}
