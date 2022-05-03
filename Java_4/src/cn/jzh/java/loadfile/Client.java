package cn.jzh.java.loadfile;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            String filePath = "Java_4/src/cn/jzh/java/loadfile/clientfile/1.jpg";
            byte[] bytes = new byte[1024 * 1024];
            bis = new BufferedInputStream(new FileInputStream(filePath));
            bos = new BufferedOutputStream(socket.getOutputStream());
            while (bis.read(bytes) != -1) {
                bos.write(bytes);
                bos.flush();
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
