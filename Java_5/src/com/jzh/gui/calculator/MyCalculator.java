package com.jzh.gui.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/6 15:16
 */
class MyCalculator extends JFrame {
    public static void main(String[] args) {
        new MyCalculator();
    }
    TextField t1, t2, t3;
    public MyCalculator() {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Plus Calculator");
        setBounds(400, 400, 600, 100);
        setVisible(true);

        t1 = new TextField(5);
        t2 = new TextField(5);
        t3 = new TextField(10);
        Label plusLabel = new Label("+");
        Button equalButton = new Button("=");
        myMonitor mr = new myMonitor();
        equalButton.addActionListener(mr);

        add(t1);
        add(plusLabel);
        add(t2);
        add(equalButton);
        add(t3);
    }
    class myMonitor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i1 = Integer.parseInt(t1.getText());
            int i2 = Integer.parseInt(t2.getText());
            int result = i1 + i2;
            t3.setText("" + result);
        }
    }
}
