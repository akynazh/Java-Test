package com.file1.java;

import org.junit.Test;

import java.io.*;

public class FileTest {

    @Test//test下文件相对于module
    public void test1(){
        //alt + ctrl + t 进行快捷抛异常
        FileReader fp1 = null;
        try {
            File f1 = new File("myfirstfile.txt");
            System.out.println(f1);
            System.out.println(f1.exists());
            if(!f1.exists())    f1.createNewFile();
            //if(f1.exists()) f1.delete();
            fp1 = new FileReader("myfirstfile.txt");
            int data;
            while((data = fp1.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fp1 != null) {
                try {
                    fp1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        FileReader fp1 = null;
        try {
            fp1 = new FileReader("myfirstfile.txt");
            char[] str = new char[1000];
            int len;
//            while((len = fp1.read(str)) != -1){
//                for(char ch : str){
//                    System.out.print(ch);
//                }
//            }
            while((len = fp1.read(str)) != -1){
                String st = new String(str, 0, len);
                System.out.print(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fp1 != null){
                try {
                    fp1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3(){
        FileWriter fw = null;
        try {
            fw = new FileWriter("myfirstfile.txt", true);
            fw.write("\n666 666");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() throws IOException {
        FileInputStream f1 = new FileInputStream("input.txt");
        FileOutputStream f2 = new FileOutputStream("zh1.txt");
        InputStreamReader isr = new InputStreamReader(f1);
        OutputStreamWriter osw = new OutputStreamWriter(f2);
        char[] ch = new char[100];
        int len;
        while((len = isr.read(ch)) != -1){
            osw.write(ch);
        }
        isr.close();
        osw.close();
    }

    @Test
    public void test5() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File f1 = new File("zh.jpg");
            File f2 = new File("zh1.jpg");
            fis = new FileInputStream(f1);
            fos = new FileOutputStream(f2);

            int len;
            byte[] buffer = new byte[5];
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
