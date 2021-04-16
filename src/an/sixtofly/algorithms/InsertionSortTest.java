package an.sixtofly.algorithms;

import an.sixtofly.algorithms.AlgorithmsTest;

/**
 * 插入排序, 与前面已排序数做比较
 * 所有元素后移, 若当前数大于前面数, 则插入
 *
 * @author xie yuan bing
 * @date 2021-04-14 17:21
 */
public class InsertionSortTest {

    public static void main(String[] args) {
        int[] data = AlgorithmsTest.random();
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            for (int m = i; m > 0; m--) {
                if (temp < data[m - 1]) {
                    data[m] = data[m - 1];
                    data[m - 1] = temp;
                } else {
                    data[m] = temp;
                    break;
                }
            }
        }
        AlgorithmsTest.print(data);
    }
}
