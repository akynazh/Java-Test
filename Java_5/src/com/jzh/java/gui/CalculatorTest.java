package com.jzh.java.gui;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

public class CalculatorTest {
    public static void main(String[] args) {
        new myCalculator().creatCalculator();
    }
}

class myCalculator extends JFrame {
    TextField t1, t2, t3;
    public void creatCalculator() {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Plus Calculator");
        setLocation(400, 400);
        setSize(200, 250);
        t1 = new TextField(5);
        t2 = new TextField(5);
        t3 = new TextField(10);
        Label plusLabel = new Label("+");
        Button equalButton = new Button("=");

        add(t1);
        add(plusLabel);
        add(t2);
        add(equalButton);
        add(t3);
        pack();
        setVisible(true);

        myMonitor mr = new myMonitor();
        equalButton.addActionListener(mr);
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

