package com.sixtofly.algorithms;

/**
 * 归并排序
 * 平均时间复杂度：O(nlogn)
 * 最佳时间复杂度：O(nlogn)
 * 最差时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 *
 * @author xie yuan bing
 * @date 2021-04-16 17:03
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] data = AlgorithmsTest.random();
        first(data);
        AlgorithmsTest.print(data);
    }


    public static void mergeSort(int[] data) {
    }

    public static void first(int[] data) {
        int[] temp = new int[data.length];
        first(data, 0, data.length - 1, temp);
    }


    /**
     * 第一次编码
     */
    public static void first(int[] data, int left, int right, int[] temp) {



        // 拆分
        if (left < right) {

            int mid = (left + right) >> 1;


            // 分左边
            first(data, left, mid, temp);

            // 分右边
            first(data, mid + 1, right, temp);

            // 合并
            int li = left;
            int ri = mid + 1;
            int current = left;
            while (li <= mid && ri <= right) {
                if (data[li] < data[ri]) {
                    temp[current++] = data[li++];
                } else {
                    temp[current++] = data[ri++];
                }
            }

            // 剩余左边元素
            while (li <= mid) {
                temp[current++] = data[li++];
            }

            // 剩余右边元素
            while (ri <= right) {
                temp[current++] = data[ri++];
            }

            System.arraycopy(temp, left, data, left, right - left + 1);
        }





    }

    public static void split(int left, int right) {

    }




}
