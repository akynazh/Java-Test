package com.jzh.java.ser;

import java.io.File;

// javac -encoding UTF-8 *.java
public class RenameTest {
    /*
    * 关于相对路径与绝对路径：
    * 1. 服务器端相对地址 http://192.168.0.1/webapp  输出的表示末尾不会有 /
    * jsp, servlet中 request.getRequestDispatcher("/user/index.jsp")
    * 前面需要添加 /  可见这是字符串联合起来表示的路径 -> http://192.168.0.1/webapp  /user/index.jsp
    *
    * 2. 客户端相对地址 http://192.168.0.1
    * html中 action="/webapp/user/index.jsp" -> http://192.168.0.1/webapp/user/index.jsp
    *
    *3. Module中
    *   Test相对地址    D:/@java/Test/Java_6
    *   Main相对地址    D:/@java/Test
    *
    *4. "./"代表当前目录
    "   ../"代表上级目录
    "   ../../"代表上级目录的上级目录
    * */
    public static void main(String[] args) throws Exception {
        String path1 = System.getProperty("user.dir"); // user.dir指定了当前的路径
        System.out.println(path1); // D:\@java\Test
        // D:\@java\Test  -> D:/@java/Test 末尾没有 /

        String path2 = "/Java_6/src/com/file2/java/jzh.txt";
        File file = new File(path2);
        System.out.println(file.exists()); // false
        // 为什么？ 因为这里默认加上了 / ， 即 D:/@java/Test -> D:/@java/Test/
        // 得到错误路径-> D:/@java/Test//Java_6/src/com/file2/java/jzh.txt
        // 这和web中的操作不一样

        // 这里最后的/不能丢，因为是字符串联合来进行表示的路径！
//        String path3 = "F:/akyna/romantic/good/jzh/";
//        String newName = "_" + "jzh";
//        String typeName = "." + "mkv";
//        File file = new File(path3);
//        File[] files = file.listFiles();
//        int i = 0;
//        for (File f : files) {
//            i++;
//            f.renameTo(new File(path3 + String.valueOf(i) + newName + typeName));
//        }
    }
}
