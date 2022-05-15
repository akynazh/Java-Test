package com.jzh.simple.classloader;

import org.junit.Test;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/3 10:51
 */
public class ClassLoaderTest {
    @Test
    public void test1() {

        // Jzh.class 即 this.getClass()

        System.out.println(this.getClass().getClassLoader());
        // jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
        System.out.println(this.getClass());
        // class com.jzh.simple.classloader.ClassLoaderTest
        System.out.println(ClassLoaderTest.class.getClassLoader());
        // jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
        System.out.println(ClassLoaderTest.class);
        // class com.jzh.simple.classloader.ClassLoaderTest

        // 在该类所在文件路径下的一个文件
        System.out.println(ClassLoaderTest.class.getResource("test.properties"));
        // file:/D:/technology/Java/Test/out/production/Java_3/com/jzh/simple/classloader/test.properties
    }
}