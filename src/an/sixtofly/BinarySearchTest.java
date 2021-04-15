package an.sixtofly;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xie yuan bing
 * @date 2021-04-12 16:05
 */
public class BinarySearchTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] split = next.split(",");
        int[] data = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            data[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        System.out.println("输入查找的数:");

        while (scanner.hasNext()) {
            String val = scanner.next();
            System.out.println(binarySearch(data, Integer.parseInt(val)));
        }
    }


    public static int binarySearch(int[] data, int find) {
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (data[mid] < find) {
                start = mid + 1;
            } else if (data[mid] > find){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -(start + 1);
    }



}
