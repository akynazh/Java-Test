package com.jzh.simple.builder;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/11 23:39
 */
public class BuilderTest {
    public static void main(String[] args) {
        Student student = new Student.Builder("江志航", "20009100359").major("CS").age(20).build();
        System.out.println(student);
    }
}
