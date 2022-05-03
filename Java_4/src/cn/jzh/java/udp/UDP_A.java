package cn.jzh.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP_A {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(9999);
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            int len = datagramPacket.getLength();
            byte[] data = datagramPacket.getData();
            String s = new String(data, 0, len);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }

        DatagramSocket datagramSocket1 = null;
        try {
            datagramSocket1 = new DatagramSocket(7777);
            byte[] data = "Hello, B".getBytes();
            String IP = "192.168.197.1";
            int desPort = 6666;
            DatagramPacket datagramPacket =
                    new DatagramPacket(data, data.length, InetAddress.getByName(IP), desPort);
            datagramSocket1.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket1 != null) {
                datagramSocket1.close();
            }
        }
    }
}
