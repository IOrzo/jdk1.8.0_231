package an.sixtofly.algorithms;

/**
 * 冒泡排序, 比较两个相邻数据, 大的在后面
 * 平均时间复杂度：O(N^2)
 * 最佳时间复杂度：O(N)
 * 最差时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author xie yuan bing
 * @date 2021-04-14 16:56
 */
public class BubbleSortTest {


    public static void main(String[] args) {
        int[] data = AlgorithmsTest.random();
        BubbleSortTest test = new BubbleSortTest();
//        test.bubbleSort(data);
//        AlgorithmsTest.print(data);
//        test.optimization(data);
//        AlgorithmsTest.print(data);
        int[] optimizationAgain = new int[]{4,3,2,1,5,6,9,8,7};
        test.optimizationAgain(optimizationAgain);
        AlgorithmsTest.print(optimizationAgain);
    }

    public void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int m = 0; m < data.length - 1 - i; m++) {
                // 如果第一个数大于第二个数, 就交换位置, 保证大的数在后面
                if (data[m] > data[m + 1]) {
                    int temp = data[m + 1];
                    data[m + 1] = data[m];
                    data[m] = temp;
                }
            }
        }
    }

    /**
     * 如果后面数已经是排好序的, 就不再进行遍历
     */
    public void optimization(int[] data) {
        boolean flag = true;
        for (int i = 0; i < data.length && flag; i++) {
            System.out.println("i:" + i);
            flag = false;
            for (int m = 0; m < data.length - 1 - i; m++) {
                // 如果第一个数大于第二个数, 就交换位置, 保证大的数在后面
                if (data[m] > data[m + 1]) {
                    int temp = data[m + 1];
                    data[m + 1] = data[m];
                    data[m] = temp;
                    flag = true;
                }
            }
        }
    }

    /**
     * 减少内循环次数, 如果后续数已经排好序, 就不再进行排序
     * [4,3,2,1,5,6,7,8,9]
     */
    public void optimizationAgain(int[] data) {
        boolean flag = true;
        int length = data.length - 1;
        int len = 0;
        for (int i = 0; i < data.length && flag; i++) {
            System.out.println("i:" + i);
            flag = false;
            for (int m = 0; m < length; m++) {
                // 如果第一个数大于第二个数, 就交换位置, 保证大的数在后面
                if (data[m] > data[m + 1]) {
                    int temp = data[m + 1];
                    data[m + 1] = data[m];
                    data[m] = temp;
                    flag = true;
                    len = m;
                }
            }
            length = len;
        }
    }
}
