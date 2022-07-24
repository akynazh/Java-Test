package com.jzh.gui.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/18 21:18
 */
public class BorderWindow extends JFrame {
    public static void main(String[] args) {
        new BorderWindow();
    }
    public BorderWindow() {
        setTitle("Border Layout");
        setLayout(new BorderLayout());
        JButton button1=new JButton ("上");
        JButton button2=new JButton("左");
        JButton button3=new JButton("中");
        JButton button4=new JButton("右");
        JButton button5=new JButton("下");
        add(button1,BorderLayout.NORTH);
        add(button2,BorderLayout.WEST);
        add(button3,BorderLayout.CENTER);
        add(button4,BorderLayout.EAST);
        add(button5,BorderLayout.SOUTH);

        setBounds(300,200,600,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
