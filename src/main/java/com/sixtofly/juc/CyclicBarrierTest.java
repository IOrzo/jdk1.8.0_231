package com.sixtofly.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author xie yuan bing
 * @date 2021-09-24 15:34
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        float[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Solver solver = new Solver(matrix);
    }


    static class Solver {
        final int N;
        final float[][] data;
        final CyclicBarrier barrier;

        class Worker implements Runnable {
            int myRow;

            Worker(int row) {
                myRow = row;
            }

            public void run() {
                while (!done()) {
                    processRow(myRow);

                    try {
                        barrier.await();
                    } catch (InterruptedException ex) {
                        return;
                    } catch (BrokenBarrierException ex) {
                        return;
                    }
                }
            }

            private boolean done() {
                return Thread.currentThread().isInterrupted();
            }

            private void processRow(int myRow) {
                String name = Thread.currentThread().getName();
                for (float d : data[myRow]) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + ":" + d);
                }
            }
        }

        public Solver(float[][] matrix) {
            data = matrix;
            N = matrix.length;
            Runnable barrierAction =
                    new Runnable() {
                        public void run() {
                            mergeRows();
                        }
                    };
            barrier = new CyclicBarrier(N, barrierAction);

            List<Thread> threads = new ArrayList<Thread>(N);
            for (int i = 0; i < N; i++) {
                Thread thread = new Thread(new Worker(i));
                threads.add(thread);
                thread.start();
            }

            // wait until done
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("-----------------");
        }

        private void mergeRows() {
            String name = Thread.currentThread().getName();
            System.out.println(name + ":收尾，合并数据");
        }

        private void sleep(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
