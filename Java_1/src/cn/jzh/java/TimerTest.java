package cn.jzh.java;

import java.awt.*;
import java.awt.event.*;//提供ActionListener接口
import java.time.*;
import javax.swing.*;

public class TimerTest {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(1000, listener);
        //Timer构造器，第一个参数是一个时间间隔，单位为毫秒，第二个参数为监听器对象
        timer.start();//开始计时
        JOptionPane.showMessageDialog(null, "Quit program?");
        //显示对话框，对话框位于parent主件的中央，如果parent为null，则对话框将显示在屏幕中央
        //keep program running until the user selects "OK"
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{
    //定时器调用actionPerformed方法
    public void actionPerformed(ActionEvent event){
        //ActionEvent参数提供事件的相关信息如时间
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
        //event.getWhen获得1970.1.1以来的毫秒数，传入静态方法Instant.ofEpochMilli可以得到更可读的表述
        Toolkit.getDefaultToolkit().beep();
        //默认工具箱
    }
}