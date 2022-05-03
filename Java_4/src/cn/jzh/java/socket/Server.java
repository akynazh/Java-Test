package cn.jzh.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {
        InputStream inputStream = null;
        ServerSocket serverSocket = null;//可同时监听多个请求，每个请求开启一个线程，用一个socket进行对应操作
        OutputStream outputStream = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("等待客户端连接......");
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            System.out.print("成功接收数据：");
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len));
            }
            String message = "hello client";
            outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            socket.shutdownOutput();
            System.out.println("\n成功发送数据：" + message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
