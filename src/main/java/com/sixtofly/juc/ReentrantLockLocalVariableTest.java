package com.sixtofly.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 本地变量方法测试
 * 在多并发编程下，需求源码里使用：
 * final ReentrantLock lock = this.lock;
 * 把成员变量赋值给本地变量再使用，如
 * @see java.util.concurrent.ArrayBlockingQueue#put(Object)
 *
 * 有一种说法是：
 * 原因一、为了加快访问速度；
 * 将全局变量赋值给方法的一个局部变量，访问的时候直接在线程栈里面取，比访问成员变量速度要快，读取栈里面的变量只需要一条指令，读取成员变量则需要两条指令；
 *
 * 原因二、为了安全；
 * 如果只是为了访问速度快，那么直接使用一个普通的局部变量即可，不需要加final，加了final原因就是为了多线程下的线程安全。
 * final的作用，一经初始化就无法被更改，并且保证对象访问的内存重排序，保证对象的可见性
 *
 * 另一种是来自作者的说法：
 * http://ifeve.com/fields-and-local/
 *
 * 通过查看字节码，确实两者的字节码是有区别的。
 * 字节码在方法注释上表示出来
 *
 * @author xie yuan bing
 * @date 2022-01-21 16:33
 */
public class ReentrantLockLocalVariableTest {

    final ReentrantLock lock;

    ReentrantLockLocalVariableTest() {
        lock = new ReentrantLock();
    }

    /**
     * 直接使用
     *  0 aload_0
     *  1 getfield #4 <an/sixtofly/juc/ReentrantLockLocalVariableTest.lock : Ljava/util/concurrent/locks/ReentrantLock;>
     *  4 invokevirtual #5 <java/util/concurrent/locks/ReentrantLock.lock : ()V>
     *  7 aload_0
     *  8 getfield #4 <an/sixtofly/juc/ReentrantLockLocalVariableTest.lock : Ljava/util/concurrent/locks/ReentrantLock;>
     * 11 invokevirtual #6 <java/util/concurrent/locks/ReentrantLock.unlock : ()V>
     * 14 return
     */
    public void direct() {
        lock.lock();
        lock.unlock();
    }

    /**
     * 间接使用
     *  0 aload_0
     *  1 getfield #4 <an/sixtofly/juc/ReentrantLockLocalVariableTest.lock : Ljava/util/concurrent/locks/ReentrantLock;>
     *  4 astore_1
     *  5 aload_1
     *  6 invokevirtual #5 <java/util/concurrent/locks/ReentrantLock.lock : ()V>
     *  9 aload_1
     * 10 invokevirtual #6 <java/util/concurrent/locks/ReentrantLock.unlock : ()V>
     * 13 return
     */
    public void indirect() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        lock.unlock();
    }
}
