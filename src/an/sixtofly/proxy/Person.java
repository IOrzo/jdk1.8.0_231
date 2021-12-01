package an.sixtofly.proxy;

/**
 * @author xie yuan bing
 * @date 2021-11-26 09:16
 */
public class Person implements BuyService, PayService {

    @Override
    public Object buy() {
        System.out.println("buy");
        return null;
    }

    @Override
    public Object pay() {
        System.out.println("pay");
        return null;
    }
}
