package com.jzh.gui.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/18 21:16
 */
public class FlowWindow extends JFrame {
    public static void main(String[] args) {
        new FlowWindow();
    }
    public FlowWindow() {
        setTitle("Flow Layout");
        JPanel jPanel = new JPanel();
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        jPanel.add(btn1);
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);
        //向JPanel添加FlowLayout布局管理器，将组件间的横向和纵向间隙都设置为20像素
        jPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        jPanel.setBackground(Color.green);    //设置背景色

        add(jPanel);    //添加面板到容器
        setBounds(300, 200, 300, 150);    //设置容器的大小
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
