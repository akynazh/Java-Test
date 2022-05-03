package cn.jzh.java.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host1 = InetAddress.getLocalHost();
        System.out.println(host1);

        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);
    }
}
