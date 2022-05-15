package com.jzh.java.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleTest {
    public static void main(String[] args) {
        Locale locale1 = Locale.CHINA;
        Locale locale2 = Locale.US;
        System.out.println(Locale.getDefault()); // zh_CN

        // src下
        ResourceBundle res;
        res = ResourceBundle.getBundle("my", locale1);
        System.out.println(res.getString("name"));

        res = ResourceBundle.getBundle("my", locale2);
        System.out.println(res.getString("name"));

        res = ResourceBundle.getBundle("my");
        System.out.println(res.getString("name"));
    }
}
