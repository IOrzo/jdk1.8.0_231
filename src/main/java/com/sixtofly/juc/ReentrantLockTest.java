package com.sixtofly.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xie yuan bing
 * @date 2021-09-09 17:38
 */
public class ReentrantLockTest {

    public static  final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {



        new Thread(() -> {
            lock.lock();
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.lock();



    }

}
