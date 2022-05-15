package com.jzh.simple.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/6 15:50
 */
public class Test1 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "hello task");
            }
        }, 0, 1000);
    }
}
