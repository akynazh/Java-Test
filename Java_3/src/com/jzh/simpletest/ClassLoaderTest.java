package com.jzh.simpletest;

import org.junit.Test;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/3 10:51
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("使用IDEA，更好地学习Java");
    }
    @Test
    public void test1() {

        // Jzh.class 即 this.getClass()

        System.out.println(this.getClass().getClassLoader());
        // jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
        System.out.println(this.getClass());
        // class com.jzh.java.Jzh
        System.out.println(ClassLoaderTest.class.getClassLoader());
        // jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
        System.out.println(ClassLoaderTest.class);
        // class com.jzh.java.Jzh

        // 有该类实例时可以使用
        System.out.println(ClassLoaderTest.class.getClassLoader().getResource("test1.properties"));
        // file:/D:/@java/Test/out/production/Test/test1.properties
        System.out.println(ClassLoaderTest.class.getClassLoader().getResource("com/jzh/java/test2.properties"));
        // file:/D:/@java/Test/out/production/Test/com/jzh/java/test2.properties

        // 这样写还可以在静态代码块中使用 但web工程不能使用getSystemResource
        System.out.println(ClassLoader.getSystemClassLoader().getResource("test1.properties"));
        // file:/D:/@java/Test/out/production/Test/test1.properties
        System.out.println(ClassLoader.getSystemResource("test1.properties"));
        // file:/D:/@java/Test/out/production/Test/test1.properties

        //在该类所在文件路径下
        System.out.println(ClassLoaderTest.class.getResource("test1.properties"));
        // null
        System.out.println(ClassLoaderTest.class.getResource("test2.properties"));
        // file:/D:/@java/Test/out/production/Test/com/jzh/java/test2.properties
    }
}