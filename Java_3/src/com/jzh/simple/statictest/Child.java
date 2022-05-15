package com.jzh.simple.statictest;

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
        Common.ID = 200;
        DataOutputStream dos = new DataOutputStream(System.out);
        dos.writeUTF(String.valueOf(Common.ID));
        dos.writeUTF("");
        dos.close();
    }
}

