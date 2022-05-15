package com.jzh.java.gui.timertest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/6 15:18
 */
public class TimerTest2 {
    public static int i;
    public static void main(String[] args) {
        i = 0;
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TimerTest2.i < 30)
                    System.out.println("hello");
                else
                    System.out.println("bye");
            }
        };
        new Timer(1000, actionListener).start();
        while (i < 50) {
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
