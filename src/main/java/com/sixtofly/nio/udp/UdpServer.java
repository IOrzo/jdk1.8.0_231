package com.sixtofly.nio.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author xie yuan bing
 * @date 2022-01-27 10:11
 */
public class UdpServer {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8080);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        try {
            // 会一直阻塞，直到获取到数据
            socket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("收到数据：" + new String(bytes));

        byte[] replyBytes = "服务端回复".getBytes();
        DatagramPacket replyData = new DatagramPacket(replyBytes, replyBytes.length, packet.getSocketAddress());
        try {
            socket.send(replyData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
