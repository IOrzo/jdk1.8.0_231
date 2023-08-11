package com.sixtofly.nio.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author xie yuan bing
 * @date 2022-01-27 10:18
 */
public class UdpClient {

    public static void main(String[] args) {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8001);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        byte[] replyBytes = "客户端发送数据".getBytes();
        InetAddress address = null;
        try {
            address = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DatagramPacket replyData = new DatagramPacket(replyBytes, replyBytes.length, address, 8080);
        try {
            socket.send(replyData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket.receive(replyData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("收到数据：" + new String(replyData.getData()));
        socket.close();
    }
}
