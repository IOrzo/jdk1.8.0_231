package an.sixtofly;

import java.lang.reflect.Field;

/**
 * 面试题：a==1 && a==2 && a==3 是 true 还是 false？
 * https://mp.weixin.qq.com/s/NV-W3zVZ9xhMNWRcgGmOcQ
 * @author xie yuan bing
 * @date 2021-06-24 14:24
 */
public class IntegerEqualsTest {

    /**
     * 面试题：a==1 && a==2 && a==3 是 true 还是 false？
     * 可以使这个成立么？
     * @param args
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);
        // array[129] is 1
        array[130] = array[129];
        // Set 2 to be 1
        array[131] = array[129];
        // Set 3 to be 1
        Integer a = 1;
        if (a == (Integer) 1 && a == (Integer) 2 && a == (Integer) 3) {
            System.out.println("Success");
        }
    }
}
