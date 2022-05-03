package cn.jzh.java.udp;

import java.io.IOException;
import java.net.*;

public class UDP_B{
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8888);
            byte[] data = "Hello, A".getBytes();
            String IP = "192.168.197.1";
            int desPort = 9999;
            DatagramPacket datagramPacket =
                    new DatagramPacket(data, data.length, InetAddress.getByName(IP), desPort);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }

        DatagramSocket datagramSocket1 = null;
        try {
            datagramSocket1 = new DatagramSocket(6666);
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket1.receive(datagramPacket);
            int len = datagramPacket.getLength();
            byte[] data = datagramPacket.getData();
            String s = new String(data, 0, len);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket1 != null) {
                datagramSocket1.close();
            }
        }

    }
}
