package com.jzh.java.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/6 13:22
 */
public class WindowTest {
    public static void main(String[] args) throws InterruptedException {
        JFrame test = new JFrame("test");
        test.setSize(200, 400);
        test.setVisible(true);
        test.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        int i = 0;
        while (test.isVisible()) {
            System.out.print(i);
            i++;
            Thread.sleep(1000);
        }
        System.exit(0);
    }
}
