package an.sixtofly.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 单线程多路复用模型，用来方便查看内核调用
 *
 * 资料 [Linux epoll模型详解及源码分析](https://blog.csdn.net/zhaobryant/article/details/80557262?ivk_sa=1024320u)
 * @author xie yuan bing
 * @date 2021-07-12 16:49
 */
public class SimpleServerSocketChannelTest {

    /**
     * 三个客户端，轮流输出，对应系统调用在 snio.3365 文件中 (有删减)
     * key.isReadable()
     * result:2
     * key.isReadable()
     * result:1
     * key.isWritable()
     * key.isWritable()
     * key.isReadable()
     * result:3
     * key.isWritable()
     * key.isReadable()
     * result:4
     * key.isWritable()
     * key.isWritable()
     * key.isWritable()
     * key.isWritable()
     * key.isReadable()
     * result:5
     *
     * key.isReadable()
     * result:
     *
     * key.isReadable()
     * result:6
     *
     * key.isWritable()
     * key.isWritable()
     * key.isWritable()
     * key.isReadable()
     * result:8
     *
     * key.isReadable()
     * result:7
     *
     * key.isWritable()
     * key.isWritable()
     * key.isWritable()
     * key.isReadable()
     * result:9
     *
     * key.isWritable()
     * key.isWritable()
     * key.isWritable()
     * key.isWritable()
     * key.isReadable()
     * result:quit
     *
     * key.isWritable()
     * key.isWritable()
     * key.isWritable()
     * key.isWritable()
     *
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9110));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }

            int readyChannels = 0;
            try {
                readyChannels = selector.selectNow();
                if (readyChannels != 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        handle(key);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private static void handle(SelectionKey key) {
        try {
            if (key.isAcceptable()) {
                System.out.println("key.isAcceptable()");
            } else if (key.isConnectable()) {
                System.out.println("key.isConnectable()");
            } else if (key.isReadable()) {
                System.out.println("key.isReadable()");
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(50);
                socketChannel.read(buffer);
                buffer.flip();
                System.out.println("result:" + new String(buffer.array()));
                socketChannel.register(key.selector(), SelectionKey.OP_WRITE, buffer);
            } else if (key.isWritable()) {
                System.out.println("key.isWritable()");
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer buffer = (ByteBuffer) key.attachment();
                if (buffer != null) {buffer.flip();
                    String result = new String(Arrays.copyOf(buffer.array(), buffer.limit() + 1));
                    buffer.clear();
                    String temp  = "server receiver:" + result + "\r\n";
                    buffer.put(temp.getBytes("utf-8"));
                    buffer.flip();
                    socketChannel.write(buffer);
                    socketChannel.register(key.selector(), SelectionKey.OP_READ);

                }
//                        key.cancel();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
