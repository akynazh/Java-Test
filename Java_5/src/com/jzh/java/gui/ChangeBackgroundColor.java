package com.jzh.java.gui;

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

class AFrame extends JFrame{
    public AFrame(){
        add(new DrawComponent());
        pack();
        setSize(600, 400);
        var yellowButton = new JButton("Yellow");//构造一个名为"Yellow"的按钮
        var greenButton = new JButton("Green");
        buttonPanel = new JPanel();
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);
        add(buttonPanel);
        var yellowAction = new ColorAction(Color.YELLOW);
        var greenAction = new ColorAction(Color.GREEN);
        yellowButton.addActionListener(yellowAction);
        greenButton.addActionListener(greenAction);
    }

    private JPanel buttonPanel;//中间容器

    //内部类
    private class ColorAction implements ActionListener{
        private Color backgroundColor;
        public ColorAction(Color c){
            backgroundColor = c;
        }
        public void actionPerformed(ActionEvent event){
            buttonPanel.setBackground(backgroundColor);
        }
    }
}

class DrawComponent extends JComponent{
    public void paintComponent(Graphics g){
        var rect = new Rectangle2D.Double(100, 100, 200, 150);
        var g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.fill(rect);
        g.setColor(Color.blue);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString("hello frame", 100, 100);
    }
    public Dimension getPreferredSize(){
        return new Dimension(800, 400);
    }
}

