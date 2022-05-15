package com.jzh.java.file;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class FileTest {
    @Test
    public void test5() {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                File f1 = new File("input.txt");
                FileWriter fw1 = new FileWriter(f1, true);
                int i = 0;
                while (i < 100) {
                    fw1.write("fw1_write \n");
                    i++;
                    Thread.sleep(500); // BIO, fw1几乎无法写
                }
                fw1.close();
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                File f2 = new File("input.txt");
                FileWriter fw2 = new FileWriter(f2, true);
                int i = 0;
                while (i < 100) {
                    fw2.write("fw2_write \n");
                    i++;
                }
                fw2.close();
            }
        }).start();
    }

    /**
     * @description: FileReader测试
     * @author Jiang Zhihang
     * @date 2022/5/3 17:56
     */
    @Test
    public void test1() {
        FileReader fp1 = null;
        try {
            File f1 = new File("input.txt");
            if (!f1.exists() && !f1.createNewFile()) {
                System.out.println("create fail");
                return;
            }
            fp1 = new FileReader("input.txt");
            char[] str = new char[1000];
            int len;
            while ((len = fp1.read(str)) != -1) {
                String st = new String(str, 0, len);
                System.out.print(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fp1 != null) {
                try {
                    fp1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @description: FileWriter测试
     * @author Jiang Zhihang
     * @date 2022/5/3 17:56
     */
    @Test
    public void test2() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("output.txt", true);
            fw.write("\n666 666");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @description: FileStream测试
     * @author Jiang Zhihang
     * @date 2022/5/3 17:57
     */
    @Test
    public void test3() throws IOException {
        FileInputStream f1 = new FileInputStream("input.txt");
        FileOutputStream f2 = new FileOutputStream("output.txt");
        InputStreamReader isr = new InputStreamReader(f1);
        OutputStreamWriter osw = new OutputStreamWriter(f2);
        char[] str = new char[100];
        int len;
        while ((len = isr.read(str)) != -1) {
            osw.write(new String(str, 0, len));
        }
        isr.close();
        osw.close();
    }

    @Test
    public void test4() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File f1 = new File("input.jpg");
            File f2 = new File("output.jpg");
            fis = new FileInputStream(f1);
            fos = new FileOutputStream(f2);

            int len;
            byte[] buffer = new byte[5];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
