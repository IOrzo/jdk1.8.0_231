package an.sixtofly.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xie yuan bing
 * @date 2021-06-02 17:25
 */
public class ServerSocketHandlerTest implements Runnable {

    private SelectionKey key;


    public ServerSocketHandlerTest(SelectionKey selectionKeys) {
        this.key = selectionKeys;
    }

    @Override
    public void run() {

        try {
            if (key.isAcceptable()) {
                System.out.println("key.isAcceptable()");
            } else if (key.isConnectable()) {
                System.out.println("key.isConnectable()");
            } else if (key.isReadable()) {
                System.out.println("key.isReadable()");
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(48);
                socketChannel.read(buffer);
                buffer.flip();
                System.out.println("result:" + new String(buffer.array()));
                socketChannel.register(key.selector(), SelectionKey.OP_WRITE);
            } else if (key.isWritable()) {
                System.out.println("key.isWritable()");
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(40);
                buffer.put("server receiver".getBytes("utf-8"));
                buffer.flip();
                socketChannel.write(buffer);
                key.cancel();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
