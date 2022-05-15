package com.jzh.simple.statictest;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

public class Father {
    public static void main(String[] args) throws IOException {
        Runtime run = Runtime.getRuntime();
        // 获取java执行命令所在的位置
        String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        // 获取类加载的时候的加载的class文件的路径,返回结果是一个string,多个路径之间用";"分割.
        String cp = "\"" + System.getProperty("java.class.path");
        // 获取当前程序的class文件所在的位置
        cp += File.pathSeparator + ClassLoader.getSystemResource("").getPath() + "\"";
        // java -cp 命令   (这是运行class文件的命令,会将class文件载入jvm)
        String cmd = java + " -cp " + cp + " com.jzh.simpletest.statictest.Child";
        // 开启一个子进程
        Process child_process = run.exec(cmd);

        Common.ID = 100;
        DataInputStream dis = new DataInputStream(child_process.getInputStream());
        while (true) {
            String s = dis.readUTF();
            if (s.equals("")) break;
            System.out.println(s);
        }
        System.out.println(Common.ID);
        dis.close();
    }
}
