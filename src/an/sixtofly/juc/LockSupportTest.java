package an.sixtofly.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author xie yuan bing
 * @date 2021-06-07 17:57
 */
public class LockSupportTest {

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("子线程执行获取锁");
            LockSupport.park();
            System.out.println("子线程获取锁成功,执行....");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(Thread.currentThread());
        }).start();


        new Thread(() -> {
            System.out.println("第二个子线程获取锁");
            LockSupport.park();
            System.out.println("第二个子线程获取锁成功, 执行....");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(Thread.currentThread());
        }).start();


        System.out.println("主线程结束");


    }
}
