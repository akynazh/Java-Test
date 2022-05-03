package cn.jzh.java.loadfile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;
        InputStream is =null;
        BufferedOutputStream bos = null;
        try {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            String filePath = "Java_4/src/cn/jzh/java/loadfile/serverfile/des.jpg";
            bos = new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
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
