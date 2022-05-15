package com.jzh.java.gui.colorchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/6 15:17
 */
class AFrame extends JFrame {
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
    private class ColorAction implements ActionListener {
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