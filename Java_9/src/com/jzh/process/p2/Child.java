package com.jzh.process.p2;

import java.io.*;
import java.util.Scanner;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/6 12:40
 */

public class Child {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 子进程向父进程输出数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = 0;
        while (i < 100) {
            i++;
            bw.write(System.currentTimeMillis() + "\n");
            bw.flush();
        }
    }
}

