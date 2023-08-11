package com.sixtofly.juc;

import java.util.concurrent.*;

/**
 * @author xie yuan bing
 * @date 2021-06-24 15:33
 */
public class CallableTest {

    public static final ExecutorService executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS,
            new LinkedBlockingDeque(), new NamedThreadFactory("task-callable", false));

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Future<Integer> future = executor.submit(new CallableTask());


        System.out.println(future.get());


        System.out.println("主线程结束");
    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("执行任务");
            Thread.sleep(2000);
            return 2;
        }
    }

}
