package com.file2.java;

import java.io.*;

public class DataTest {
    public static void main(String[] args) throws IOException {
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
