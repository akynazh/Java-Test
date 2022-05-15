package com.jzh.simple.singleton;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/13 23:07
 */
public class SingleTonTest {
    public static void main(String[] args) {
        LonelyMan lonelyMan = LonelyMan.getInstance();
        lonelyMan.think();

        AnotherLonelyMan.INSTANCE.think();
    }
}


