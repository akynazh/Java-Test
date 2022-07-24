package com.jzh.gui.mytable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/19 0:04
 */
public class UserInfo extends JScrollPane {
    private final JTable table = new JTable();
    private final Object[][] user_info = new Object[1000][3];
    public UserInfo() {
        setViewportView(table);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("refresh");
                repaint();
            }
        },0, 10000);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        List<User> users = null;
        try {
            users = UserDao.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Objects.requireNonNull(users).size(); i++) {
            user_info[i][0] = users.get(i).getUser_id();
            user_info[i][1] = users.get(i).getUser_name();
            user_info[i][2] = users.get(i).getUser_email();
        }
        String[] table_head = {"user_id", "user_name", "user_email"};
        TableModel tableModel = new DefaultTableModel(user_info, table_head);
        table.setModel(tableModel);
    }
}
