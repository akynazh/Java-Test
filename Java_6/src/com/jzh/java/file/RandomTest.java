package com.jzh.java.file;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/9 16:44
 */
public class RandomTest {
    @Test
    public void test1() throws IOException {
        File file = new File("input.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(raf.length());
        raf.writeUTF("江志航");
    }

    @Test
    public void test2() throws IOException {
        File file = new File("input.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(1024 * 1024);
        raf.writeUTF("hello");
    }
}
