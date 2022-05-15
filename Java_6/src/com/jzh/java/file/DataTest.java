package com.jzh.java.file;

import org.junit.Test;

import java.io.*;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/3 17:59
 */
public class DataTest {
    @Test
    public void test1() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("jzh.txt"));
        dos.writeUTF("江志航");
        dos.flush();//刷新，即可写入
        dos.writeChar('d');

        DataInputStream dis = new DataInputStream(new FileInputStream("jzh.txt"));
        String name = dis.readUTF();
        char ch = dis.readChar();
        System.out.println(name);
        System.out.println(ch);
    }
}
