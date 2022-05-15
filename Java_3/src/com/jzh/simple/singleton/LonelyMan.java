package com.jzh.simple.singleton;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/13 23:02
 */
public class LonelyMan {
    private LonelyMan() {}
    private static final LonelyMan INSTANCE = new LonelyMan();
    public static LonelyMan getInstance() {
        return INSTANCE;
    }
    public void think() {
        System.out.println("think");
    }
}
