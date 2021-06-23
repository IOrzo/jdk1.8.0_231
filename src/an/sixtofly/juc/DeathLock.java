package an.sixtofly.juc;

import java.io.IOException;

/**
 * 死锁测试
 * @author xie yuan bing
 * @date 2021-06-23 17:42
 */
public class DeathLock {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) throws IOException {
        Thread threadA = new Thread(() -> {
           synchronized (lockA) {
               System.out.println("A进行操作");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (lockB) {
                   System.out.println("需要B的资源");
               }
           }



        });


        Thread threadB = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("B进行操作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.println("需要A的资源");
                }
            }
        });

        threadA.start();
        threadB.start();

        System.in.read();

    }
}
