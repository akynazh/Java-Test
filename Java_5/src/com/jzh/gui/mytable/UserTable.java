package com.jzh.gui.mytable;

import javax.swing.*;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/18 21:37
 */
public class UserTable extends JFrame {
    public static void main(String[] args) {
        new UserTable();
    }
    public UserTable() {
        add(new UserInfo());
        setTitle("User Form");
        setBounds(300, 300, 500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
