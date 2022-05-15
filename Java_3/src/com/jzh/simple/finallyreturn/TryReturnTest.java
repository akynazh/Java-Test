package com.jzh.simple.finallyreturn;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/3 17:17
 */
public class TryReturnTest {
    public int test1(int x) {
        try {
            x += 1;
            return ++x;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            x += 5;
            System.out.println("finally");
        }
        return x;
    }
    public int test2(int x) {
        try {
            x += 1;
            return ++x;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            x += 5;
            System.out.println("finally");
            return x;
        }
    }

    public static void main(String[] args) {
        TryReturnTest test = new TryReturnTest();
        System.out.println(test.test1(0)); // finally 2
        System.out.println(test.test2(0)); // finally 7
    }
}
