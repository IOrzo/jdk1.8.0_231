package an.sixtofly.juc;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author xie yuan bing
 * @date 2021-09-24 17:15
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {
        testCalculate();
    }


    public static void testCalculate() {
        int num = 1000000;
        int result = 0;
        Date start = new Date();
        for (int i = 1; i <= num; i++) {
            result += i;
        }
        Date end = new Date();
        System.out.println("耗时:" + (end.getTime() - start.getTime()));
        System.out.println("计算:" + num + "--结果:" + result);

        start = new Date();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new CalculateTask(1, num));
        try {
            result = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        end = new Date();
        System.out.println("耗时:" + (end.getTime() - start.getTime()));
        System.out.println("计算:" + num + "--结果:" + result);
        pool.shutdown();
    }
}
