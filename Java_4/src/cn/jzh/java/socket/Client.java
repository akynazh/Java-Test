package cn.jzh.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args){
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            outputStream = socket.getOutputStream();
            System.out.println("成功连接服务端！");
            String message = "hello server";
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            socket.shutdownOutput();
            System.out.println("成功发送数据： " + message);
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            System.out.print("成功接收数据： ");
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len));
            }
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
            if (outputStream != null) {
                try {
                    outputStream.close();
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
        }
    }
}
