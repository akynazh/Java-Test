package com.jzh.process.p1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/6 12:40
 */

public class Child {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 子进程获取父进程的数据
        DataInputStream dataInputStream = new DataInputStream(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(System.out);
        while (true) {
            String line = dataInputStream.readUTF();
            if (line.equals("")) break;
            // 将数据输入到子进程的控制台
            dataOutputStream.writeUTF("read from father: '" + line + "'");
        }
        dataOutputStream.writeUTF("");
        dataInputStream.close();
        dataOutputStream.close();
    }
}

