package an.sixtofly.algorithms;

import java.util.Random;

public abstract class AlgorithmsTest {


    public static int[] random() {
        Random random = new Random(System.currentTimeMillis());
        int[] data = new int[15];
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
            System.out.print(data[i]);
            if (i != data.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        return data;
    }

    public static void print(int[] data) {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i != data.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
