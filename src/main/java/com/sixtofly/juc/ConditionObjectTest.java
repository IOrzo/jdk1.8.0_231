package com.sixtofly.juc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xie yuan bing
 * @date 2021-10-25 15:20
 */
public class ConditionObjectTest {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "user-main").start();

        new Thread(() -> {
            lock.lock();
            condition.signal();
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "user-1").start();

        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }, "user-2").start();



        try {
            int read = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
