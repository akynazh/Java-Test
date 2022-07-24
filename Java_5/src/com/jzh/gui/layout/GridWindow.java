package com.jzh.gui.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/18 21:34
 */
public class GridWindow extends JFrame {
    public static void main(String[] args) {
        new GridWindow();
    }
    public GridWindow() {
        setTitle("GridLayou布局计算器");
        JPanel panel=new JPanel();    //创建面板
        //指定面板的布局为GridLayout，4行4列，间隙为5
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.add(new JButton("7"));    //添加按钮
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("/"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("*"));
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("-"));
        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        panel.add(new JButton("="));
        panel.add(new JButton("+"));
        add(panel);    //添加面板到容器
        setBounds(300,200,200,150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
