package com.sixtofly.juc;

import java.util.concurrent.RecursiveTask;

/**
 * @author xie yuan bing
 * @date 2021-09-24 17:09
 */
public class CalculateTask extends RecursiveTask<Integer> {

    public static final int THRESHOLD = 49;

    private int start;

    private int end;

    public CalculateTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // 计算
        if (end - start <= THRESHOLD) {
            int result = 0;
            for (int i = start; i <= end; i++) {
                result += i;
            }
            return result;
        } else {
            // 拆分
            int middle = (start + end) / 2;
            CalculateTask firstTask = new CalculateTask(start, middle);
            CalculateTask secondTask = new CalculateTask(middle + 1, end);
            invokeAll(firstTask, secondTask);
            return firstTask.join() + secondTask.join();
        }
    }
}
