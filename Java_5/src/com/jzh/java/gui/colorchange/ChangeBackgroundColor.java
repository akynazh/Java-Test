package com.jzh.java.gui.colorchange;

import com.jzh.java.gui.colorchange.AFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class ChangeBackgroundColor {
    public static void main(String[] args) {
       EventQueue.invokeLater(()->{//事件分派线程
           var frame = new AFrame();
           frame.setTitle("NotHelloWorld");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//定义用户关闭这个窗体时的响应操作
           frame.setVisible(true);
       });
    }
}





