package com.sixtofly.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author xie yuan bing
 * @date 2021-06-02 17:30
 */
public class SocketChannelTest {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(9527));

        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put("hello socketChannel".getBytes("utf-8"));
        buffer.flip();
        socketChannel.write(buffer);

        buffer.clear();


        int read = socketChannel.read(buffer);
        buffer.flip();
        System.out.println(new String(buffer.array(), 0, read));

        socketChannel.close();
    }
}
