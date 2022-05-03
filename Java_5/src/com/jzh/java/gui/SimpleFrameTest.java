package com.jzh.java.gui;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("simple frame");
            frame.setSize(500, 400);
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame{
    public SimpleFrame()
    {
        setSize(200 , 300);
    }

}

