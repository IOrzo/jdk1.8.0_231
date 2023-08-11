package com.sixtofly.algorithms;

import java.security.SecureRandom;

public abstract class AlgorithmsTest {


    public static int[] random() {
        SecureRandom random = new SecureRandom();
        int[] data = new int[15];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
        }
        print(data);
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
