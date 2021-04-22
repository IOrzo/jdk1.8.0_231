package an.sixtofly.algorithms;

/**
 * 快速排序
 * 1. 选定pivot中心轴
 * 2. 将大于pivot的数字放在pivot的右边
 * 3. 将小于pivot的数字放在pivot的左边
 * 4. 分别对左右子序列重复前三步操作
 *
 * 平均时间复杂度：O(NlogN)
 * 最佳时间复杂度：O(NlogN)
 * 最差时间复杂度：O(N^2)
 * 空间复杂度：根据实现方式的不同而不同
 *
 * @author xie yuan bing
 * @date 2021-04-16 09:33
 */
public class QuickSortTest {


    public static void main(String[] args) {
        int[] data = AlgorithmsTest.random();
//        first(data, 0, data.length - 1);
//        second(data);
        thirdQuickSort(data, 0, data.length - 1);
        AlgorithmsTest.print(data);
    }


    public void quickSort(int[] data) {

    }

    /**
     * 第一次尝试编写代码
     * 每次选取第一位数字作为pivot, 从最右边的下标数开始比较
     *
     */
    public static void first(int[] data, int left, int right) {
        if (left > right) {
            return;
        }
        int start = left;
        int end = right;
        // 默认是右指针移动
        boolean pointer = true;
        int pivot = data[left];
        while (left < right) {
            if (pointer) {
                if (data[right] < pivot) {
                    data[left] = data[right];
                    left++;
                    pointer = false;
                } else {
                    right--;
                }
            } else {
                if (data[left] > pivot) {
                    data[right] = data[left];
                    right--;
                    pointer = true;
                } else {
                    left++;
                }
            }
        }
        data[left] = pivot;
        // 左分
        first(data, start, left - 1);
        // 右分
        first(data, left + 1, end);
    }


    public static void second(int data[]) {
        secondQuickSort(data, 0, data.length - 1);
    }

    /**
     * https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
     * Quick Sort排序实现
     */
    public static void secondQuickSort(int data[], int start, int end) {

        if (start < end) {
            // 左下标指针
            int li = start;
            // 右下标指针
            int ri = end;
            // 每次以左边第一个元素作为中心轴
            int pivot = data[li++];
            // 当右指针移动, 并且数字比中心轴小时, 与左指针数组进行交换
            boolean exchange = false;

            while (li <= ri) {
                // 右指针移动
                if (exchange) {
                    // 数字小于中心轴, 数据需要进行交换, 数据交换后, 指针都移动
                    if (data[ri] < pivot) {
                        int temp = data[li];
                        data[li++] = data[ri];
                        data[ri--] = temp;
                        // 换左指针移动
                        exchange = false;
                    } else {
                        ri--;
                    }
                } else {
                    // 数字大于中心轴, 数据需要进行交换, 换右指针移动
                    if (data[li] > pivot) {
                        exchange = true;
                    } else {
                        li++;
                    }
                }
            }

            if (data[ri] < pivot) {
                data[start] = data[ri];
                data[ri] = pivot;
            }

            secondQuickSort(data, start, ri - 1);
            secondQuickSort(data, ri + 1, end);
        }
    }

    /**
     * 去掉左右指针方向
     */
    public static void thirdQuickSort(int[] data, int start, int end) {
        if (start < end) {
            int li = start;
            int ri = end;
            int pivot = data[li];

            while (li < ri) {
                // 先从ri--方向遍历
                while (li < ri) {
                    if (data[ri] < pivot) {
                        data[li++] = data[ri];
                        break;
                    } else {
                        ri--;
                    }
                }

                // 从li++方向遍历
                while (li < ri) {
                    if (data[li] > pivot) {
                        data[ri--] = data[li];
                        break;
                    } else {
                        li++;
                    }
                }
            }

            data[li] = pivot;

            thirdQuickSort(data, start, li - 1);
            thirdQuickSort(data, li + 1, end);
        }
    }
}
