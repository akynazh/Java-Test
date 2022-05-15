package com.jzh.process.p2;

import java.io.*;

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
        String cmd = java + " -cp " + cp + " com.jzh.process.p2.Child";
        // 开启一个子进程
        Process child_process = run.exec(cmd);

        // 父进程获取子进程控制台数据
        BufferedReader br = new BufferedReader(new InputStreamReader(child_process.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
