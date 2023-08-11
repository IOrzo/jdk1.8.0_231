package com.sixtofly;

public class Solution {

    public int jumpFloorII(int target) {

        int sum = 0;
        for (int i = 1; i < target; i++) {
            int f = f(i);
//            System.out.println("f" + i + ":" + f);
            sum = sum + f;
        }
        return sum;
    }

    public int f(int n) {
        if (n == 0) {
            return 0;
        }
        int s = 0;
        for (int i = 1; i < n; i++) {
            s += f(i - 1) + 1;
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.jumpFloorII(4));
        System.out.println(solution.f(2));
    }
}