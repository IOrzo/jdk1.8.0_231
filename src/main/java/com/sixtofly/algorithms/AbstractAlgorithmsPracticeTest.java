package com.sixtofly.algorithms;

/**
 * @author xie yuan bing
 * @date 2021-06-22 14:02
 */
public abstract class AbstractAlgorithmsPracticeTest {


    public abstract void test(int data[]);


    public void run() {
        int[] data = AlgorithmsTest.random();
        test(data);
        AlgorithmsTest.print(data);
    }

}
