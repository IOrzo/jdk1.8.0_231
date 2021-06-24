package an.sixtofly.spi;

/**
 * @author xie yuan bing
 * @date 2021-06-24 17:10
 */
public class Iphone implements MobilePhone {
    @Override
    public void call(String msg) {
        System.out.println("使用 Iphone 打电话:" + msg);
    }
}
