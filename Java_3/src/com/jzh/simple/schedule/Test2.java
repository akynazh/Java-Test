package com.jzh.simple.schedule;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/6 15:55
 */
public class Test2 {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor st = new ScheduledThreadPoolExecutor(10);
        st.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }
}
