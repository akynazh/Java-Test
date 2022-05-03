package com.file1.java;

import org.junit.Test;

import java.io.*;

public class BufferTest {
    @Test
    public void test1() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("input.txt"));
            bw = new BufferedWriter(new FileWriter(new File("output.txt")));
            String data;
            while((data = br.readLine()) != null){
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File f1 = new File("zh.jpg");
            File f2 = new File("zh1.jpg");
            fis = new FileInputStream(f1);
            fos = new FileOutputStream(f2);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int len;
            byte[] buffer = new byte[5];
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
                bos.flush();
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
