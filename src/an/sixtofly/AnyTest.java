package an.sixtofly;

/**
 * @author xie yuan bing
 * @date 2021-04-13 16:44
 */
public class AnyTest {

    public static void main(String[] args) {
        int a = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(a++);
        }
        int b = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(++b);
        }
    }
}
