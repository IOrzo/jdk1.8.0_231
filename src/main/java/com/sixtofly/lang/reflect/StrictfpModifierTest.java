package com.sixtofly.lang.reflect;

/**
 * strictfp 关键字测试，被改关键字修饰，方法或类中所有的 float和 double 表达式都严格遵守 FP-strict 的限制,
 * 符合 IEEE-754 规范
 * @author xie yuan bing
 * @date 2021-07-30 14:27
 */
public strictfp class StrictfpModifierTest {

    /**
     * 普遍方法
     * @param a
     * @param b
     * @return
     */
    public double genericMethod(double a, double b) {
        return  a + b;
    }

    /**
     * 精准浮点数方法
     * TODO 与普通方法执行结果一样。还不太明白
     */
    public strictfp void strictfpMethod() {

        System.out.println("-----测试精度准确方法----");
        for (int i = 1; i < 100; i++) {
            double a = i / 10.00;
            double b = i / 100.0;
            System.out.println(String.format("%s + %s: ", a, b) + (a + b));
        }
    }

    public static void main(String[] args) {
        StrictfpModifierTest test = new StrictfpModifierTest();
        System.out.println("-----测试精度不准确方法----");
        for (int i = 1; i < 100; i++) {
            double a = i / 10.00;
            double b = i / 100.0;

            System.out.println(String.format("%s + %s: ", a, b) + test.genericMethod(a, b));
        }

        test.strictfpMethod();


    }
}
