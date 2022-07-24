package com.jzh.gui.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/18 21:31
 */
public class CardWindow extends JFrame {
    public static void main(String[] args) {
        new CardWindow();
    }
    public CardWindow() {
        setTitle("Card Layout");    //创建Frame窗口
        JPanel p1 = new JPanel();    //面板1
        JPanel p2 = new JPanel();    //面板2
        JPanel cards = new JPanel(new CardLayout());    //卡片式布局的面板
        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(new JButton("找回密码按钮"));
        p2.add(new JTextField("用户名文本框", 20));
        p2.add(new JTextField("密码文本框", 20));
        p2.add(new JTextField("验证码文本框", 20));
        cards.add(p1, "card1");    //向卡片式布局面板中添加面板1
        cards.add(p2, "card2");    //向卡片式布局面板中添加面板2
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card2");    //调用show()方法显示面板2
        add(cards);
        setBounds(300, 200, 400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
