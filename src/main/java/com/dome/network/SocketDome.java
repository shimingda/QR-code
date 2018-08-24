package com.dome.network;

import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;

public class SocketDome {
    public static void main(String[] args) {
        try {
            InetAddress addr;
            Socket sock = new Socket("192.168.1.222", 8080);
            addr = sock.getInetAddress();
            Channel ch=sock.getChannel();
            ByteBuffer dst=null ;
            ((SocketChannel) ch).read(dst);
            System.out.println("连接到 " + addr);
            sock.close();
        } catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
}
