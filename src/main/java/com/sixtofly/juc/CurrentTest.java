package com.sixtofly.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author xie yuan bing
 * @date 2021-06-07 17:52
 */
public class CurrentTest {

    private static final FIFOMutex mutex = new FIFOMutex();

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("子线程执行获取锁");
            mutex.lock();
            System.out.println("子线程获取锁成功,执行....");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mutex.unlock();
        }).start();


        new Thread(() -> {
            System.out.println("第二个子线程获取锁");
            mutex.lock();
            System.out.println("第二个子线程获取锁成功, 执行....");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mutex.unlock();
        }).start();


        System.out.println("主线程结束");

    }
}
