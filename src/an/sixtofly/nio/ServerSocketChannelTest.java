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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xie yuan bing
 * @date 2021-06-02 17:11
 */
public class ServerSocketChannelTest {


    private static ExecutorService dispatcher = Executors.newSingleThreadExecutor();


    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9110));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        dispatcher.execute(new DispatcherHandlerTest(selector));

        while (true) {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 事件分发器
     *
     * @author xie yuan bing
     * @date 2021-06-03 11:20
     */
    public static class DispatcherHandlerTest implements Runnable {

        /**
         * 事件处理器
         */
        private static ExecutorService executorService = Executors.newSingleThreadExecutor();


        private Selector selector;

        public DispatcherHandlerTest(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            while (true) {
                int readyChannels = 0;
                try {
                    readyChannels = selector.selectNow();
                    if (readyChannels == 0) continue;
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        DispatcherHandlerTest.ServerSocketHandlerTest handler = new DispatcherHandlerTest.ServerSocketHandlerTest(key);
                        executorService.execute(handler);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        class ServerSocketHandlerTest implements Runnable {

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
                        ByteBuffer buffer = ByteBuffer.allocate(50);
                        socketChannel.read(buffer);
                        buffer.flip();
                        System.out.println("result:" + new String(buffer.array()));
                        socketChannel.register(key.selector(), SelectionKey.OP_WRITE, buffer);
                    } else if (key.isWritable()) {
                        System.out.println("key.isWritable()");
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        buffer.flip();
                        String result = new String(Arrays.copyOf(buffer.array(), buffer.limit() + 1));
                        buffer.clear();
                        String temp  = "server receiver:" + result;
                        buffer.put(temp.getBytes("utf-8"));
                        buffer.flip();
                        socketChannel.write(buffer);
                        socketChannel.register(key.selector(), SelectionKey.OP_READ);
//                        key.cancel();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
