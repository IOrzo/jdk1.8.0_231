package com.sixtofly.util;

import com.sixtofly.entity.Student;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xie yuan bing
 * @date 2021-06-12 14:29
 */
public class HashCodeTest {

    public static void main(String[] args) {
        // 默认 hash 是系统生成的， 有几种生成方式。 java8 是根据线程状态加随机数异或计算而成， java8 之前是随机数。
        // 有一种是返回内存地址。
        // 参考 -> [JAVA本地方法 HASHCODE是怎样生成的？HASHCODE与地址有关系吗？](https://www.freesion.com/article/4168776881/)
        Student student = new Student();
        student.setNo("123");
        student.setName("hashcode");

        System.out.println(student.hashCode());
        student.setNo("234");
        System.out.println(student.hashCode());

        // 测试 hashCode 变了会影响 HashMap 不
        Set<HashCodeTest> set = new HashSet<>();
        HashCodeTest test = new HashCodeTest();
        System.out.println(test.hashCode());
        System.out.println(set.add(test));
        test.hashCode = "456";
        System.out.println(test.hashCode());
        System.out.println(set.add(test));
        // hashCode 改变会影响散列表存储位置
        for (HashCodeTest hashCodeTest : set) {
            System.out.println(hashCodeTest.hashCode);
        }
        System.out.println(set.add(test));

    }

    public String hashCode = "345";


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCodeTest that = (HashCodeTest) o;

        return hashCode.equals(that.hashCode);
    }

    @Override
    public int hashCode() {
        return hashCode.hashCode();
    }
}
