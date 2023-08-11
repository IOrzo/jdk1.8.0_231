package com.sixtofly;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xie yuan bing
 * @date 2021-04-13 16:44
 */
public class AnyTest {

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws UnsupportedEncodingException {
//        String s = Integer.toString(65536);
//        System.out.println(Integer.toBinaryString(-5));
    }


    public void test() {
        Condition condition = lock.newCondition();
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
