package an.sixtofly.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xie yuan bing
 * @date 2021-05-30 17:16
 */
public class HashMapTest {


    public static void main(String[] args) {
//        testInit();
        testTreeifyBin();
//        testUntreeify();
    }

    /**
     * 测试初始化值
     */
    public static void testInit() {
        // threshold 是 HashMap 下次需要扩容的临界值（阈yù），
        // 若如 table 数组的大小大于阈值，则进行扩容，若链表的数量大于8并且数组的大小大于64，需要对链表进行树化
        Map<String, String> map = new HashMap<>(3);
        map.put("1", "hello world");
        map.put("2", "hello world");
        map.put("3", "hello world");
        map.put("4", "hello world");
        map.put("5", "hello world");
        map.put("6", "hello world");
        map.put("7", "hello world");
    }

    /**
     * 测试转为树结点
     * 若链表的数量大于8并且数组的大小大于64，需要对链表进行树化
     */
    public static void testTreeifyBin() {
        Map<Object, String> map = new HashMap<>(64);
        map.put(new HashKey(1), "hello world");
        map.put(new HashKey(1), "hello world");
        map.put(new HashKey(1), "hello world");
        map.put(new HashKey(1), "hello world");
        map.put(new HashKey(1), "hello world");
        map.put(new HashKey(1), "hello world");
        map.put(new HashKey(1), "hello world");
        map.put(new HashKey(1), "hello world");
        map.put(new HashKey(1), "hello world");
    }

    public static void testUntreeify() {
        Map<Object, String> map = new HashMap<>(64);
        List<HashKey> keys = insert(map, 9);
        for (Map.Entry<Object, String> entry : map.entrySet()) {
            System.out.println(entry);
        }
        for (int i = 0; i < keys.size(); i++) {
            HashKey key = keys.get(i);
            System.out.println("移除下标元素:" + i);
            System.out.println(map.remove(key));
        }
    }

    public static List<HashKey> insert(Map<Object, String> map, int num) {
        List<HashKey> list = new ArrayList<>(num);

        HashKey key = null;
        for (int i = 0; i < num; i++) {
            key = new HashKey(1);
            list.add(key);
            map.put(key, String.valueOf(i));
        }
        return list;
    }


    public static class HashKey {

        public int key;

        public HashKey(int key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
