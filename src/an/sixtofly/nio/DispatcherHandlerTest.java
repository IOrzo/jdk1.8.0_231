package an.sixtofly.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 事件分发器
 * @author xie yuan bing
 * @date 2021-06-03 11:20
 */
public class DispatcherHandlerTest implements Runnable {

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
            int readyChannels  = 0;
            try {
                readyChannels = selector.selectNow();
                if (readyChannels == 0) continue;
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    ServerSocketHandlerTest handler = new ServerSocketHandlerTest(key);
                    executorService.execute(handler);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
