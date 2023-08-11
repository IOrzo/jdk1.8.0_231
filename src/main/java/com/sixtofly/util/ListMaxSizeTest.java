package com.sixtofly.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author xie yuan bing
 * @date 2021-10-22 11:23
 */
public class ListMaxSizeTest {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        testArrayListMaxSize();
//        testReflectionArrayListMaxSize();

        // 测试链表最大大小
        testReflectionLinkedListMaxSize();

    }

    /**
     * 64位中 对象头包括: Mark Word 占 8 字节,  Class Pointer 占 8 字节
     * 开启压缩指针后: Mark Word 占 8 字节,  Class Pointer 占 4 字节
     * 对于数组对象，需要额外 4 字节表示长度，每个下标引用占 4 字节
     */
    public static void testArrayListMaxSize() {
        int size = Integer.MAX_VALUE - 2;
        /**
         * 分配 Integer.MAX_VALUE java.lang.OutOfMemoryError: Requested array size exceeds VM limit
         * 超过了数组大小限制
         * 最大可分配 Integer.MAX_VALUE - 2 大小数组
         */
        ArrayList<Object> list = new ArrayList<>(size);
        Object data = new Object();
        for (int i = 0; i < size - 1; i++) {
            list.add(data);
        }
        list.add(data);
    }

    /**
     * 反射测试大小到达最大值
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void testReflectionArrayListMaxSize() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Object> list = new ArrayList<>(40);
        Object data = new Object();
        list.add(data);
        Field field = list.getClass().getDeclaredField("size");
        field.setAccessible(true);
        field.set(list, Integer.MAX_VALUE);
        list.add(data);
    }

    public static void testReflectionLinkedListMaxSize() throws NoSuchFieldException, IllegalAccessException {
        LinkedList<Object> list = new LinkedList<>();
        Object data = new Object();
        list.add(data);
        Field field = list.getClass().getDeclaredField("size");
        field.setAccessible(true);
        field.set(list, Integer.MAX_VALUE);
        list.add(data);
        list.add(data);
        // 测试遍历
        for (Object o : list) {
            System.out.println("iterator" + o);
        }
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(1));
    }
}
