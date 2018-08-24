package com.dome.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取主机IP
 */
public class GetIP {
    public static void main(String[] args) {
        try {
            InetAddress address=InetAddress.getByName("ww.baidu.com");
            System.out.println(address.getCanonicalHostName());
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
            InetAddress localhost=InetAddress.getLocalHost();
            System.out.println(localhost.getCanonicalHostName());
            System.out.println(localhost.getHostAddress());
            System.out.println(localhost.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
