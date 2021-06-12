package an.sixtofly.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xie yuan bing
 * @date 2021-05-30 17:16
 */
public class HashMapTest {


    public static void main(String[] args) {
        // threshold 是 HashMap 下次需要扩容的临界值（阈yù），
        // 若如 table 数组的大小大于阈值，则进行扩容，若链表的数量大于8并且数组的大小小于64，需要对链表进行树化
        Map<String, String> map = new HashMap<>(3);
        map.put("1", "hello world");
        map.put("2", "hello world");
        map.put("3", "hello world");
        map.put("4", "hello world");
        map.put("5", "hello world");
        map.put("6", "hello world");
        map.put("7", "hello world");
    }
}
