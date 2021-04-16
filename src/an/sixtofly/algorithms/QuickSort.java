package an.sixtofly.algorithms;

/**
 * 快速排序
 * 1. 选定pivot中心轴
 * 2. 将大于pivot的数字放在pivot的右边
 * 3. 将小于pivot的数字放在pivot的左边
 * 4. 分别对左右子序列重复前三步操作
 * @author xie yuan bing
 * @date 2021-04-16 09:33
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] data = AlgorithmsTest.random();
        first(data, 0, data.length - 1);
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
        if (right - left < 1) {
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
}
