package an.sixtofly.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试程序退出时，会不会等待线程中守护线程或用户线程执行结束
 * @author xie yuan bing
 * @date 2021-06-24 09:53
 */
public class DaemonThreadTest {

    ExecutorService executorService = Executors.newSingleThreadExecutor(new NamedThreadFactory("daemon-", false));


//    ExecutorService executorService = Executors.newSingleThreadExecutor(new NamedThreadFactory("daemon-", true));


    public static void main(String[] args) {

        // 按照目前方法测试，是不是守护线程，程序退出都没有等待子线程执行任务结束 => 是因为之前测试方式时线程休眠了，处于等待状态，任务线程不是活跃的，就终止了
        // 使线程不休眠，一直执行任务的测试方法。那么会等待用户线程的执行完后才会结束程序
        testThreadPool();

        // 同理， 守护线程会立即结束
//        testSimpleThread();


        boolean loop = true;
//        while (loop) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }


//        System.exit(0);
    }


    public static void testSimpleThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("执行任务开始");
                int n = 0;
                for (int i = 0; i < 4000; i++) {
                    n++;
                }
                System.out.println("n:" + n);
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("执行任务结束");
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public static void testThreadPool() {
        DaemonThreadTest test = new DaemonThreadTest();
        // 不能死循环，消息队列会把内存耗尽
        for (int i = 0; i < 100; i++) {
            // 死循环模拟 OOM
            // -Xmx5m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=F:\dump
//        for (;;) {
            int finalI = i;
            test.executorService.execute(() -> {
                System.out.println("执行任务开始");
                int k = 0;
                for (int n = 0; n < 100; n++) {
                    k++;
                }
                System.out.println(k);
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("执行任务结束");
                System.out.println("i:" + finalI);
            });
        }
    }



}
