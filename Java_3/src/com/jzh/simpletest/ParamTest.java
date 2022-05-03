package com.jzh.simpletest;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/2 11:06
 */
public class ParamTest {
    public static void change1(String str, int num) {
        str = "world"; // 这里就相当与新new了一个对象
        num = 100;
    }
    public static void change2(User user) {
        user.age = 1;
        user.name = "mary";
    }
    public static void change3(User user) {
        user = new User(1, "mary");
    }
    public static void main(String[] args) {
        String str = "hello";
        int num = 1;
        System.out.println(str + " " + num); // hello 1
        change1(str, num);
        System.out.println(str + " " + num); // hello 1

        System.out.println("------------------");

        User user = new User(123, "peter");
        System.out.println(user.name + " " + user.age); // peter 123
        change2(user);
        System.out.println(user.name + " " + user.age); // mary 1

        System.out.println("------------------");

        user = new User(123, "peter");
        System.out.println(user.name + " " + user.age); // peter 123
        change3(user);
        System.out.println(user.name + " " + user.age); // peter 123
    }
}
class User {
    public int age;
    public String name;
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
