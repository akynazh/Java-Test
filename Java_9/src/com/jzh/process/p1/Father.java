package com.jzh.process.p1;

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
        String cmd = java + " -cp " + cp + " com.jzh.process.p1.Child";
        // 开启一个子进程
        Process child_process = run.exec(cmd);

        // 往子进程写数据
        DataOutputStream dataOutputStream = new DataOutputStream(child_process.getOutputStream());
        dataOutputStream.writeUTF("hello child");
        dataOutputStream.writeUTF("how are you");
        dataOutputStream.writeUTF("");
        dataOutputStream.close();//注意这个close方法,写完之后记得关闭

        // 父进程获取子进程控制台数据
        DataInputStream dataInputStream= new DataInputStream(child_process.getInputStream());
        while (true) {
            String line = dataInputStream.readUTF();
            if (line.equals("")) break;
            System.out.println(line);
        }
        dataInputStream.close();
    }
}
