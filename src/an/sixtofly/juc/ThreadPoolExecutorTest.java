package an.sixtofly.juc;

import java.util.concurrent.*;

/**
 * @author xie yuan bing
 * @date 2021-04-15 16:11
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        ThreadPoolExecutorTest.testExecTask();
    }


    /**
     * 只有队列满了, 才会创建新的线程执行任务
     */
    public static void testExecTask() {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 1, TimeUnit.MINUTES, queue, new NamedThreadFactory("number-", true));
        for (int i = 0; i < 15; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("queue size:" + queue.size());
    }
}
