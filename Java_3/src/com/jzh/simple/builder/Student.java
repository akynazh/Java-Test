package com.jzh.simple.builder;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/11 23:40
 */
public class Student {
    private final String name;
    private final String num;
    private final String major;
    private final int age;

    public static class Builder {
        // required
        private final String name;
        private final String num;
        // Optional
        private String major = "no";
        private int age = 0;

        public Builder (String name, String num) {
            this.name = name;
            this.num = num;
        }
        public Builder major(String major) {
            this.major = major;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }
    private Student(Builder builder) {
        name = builder.name;
        num = builder.num;
        major = builder.major;
        age = builder.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                '}';
    }
}
