package an.sixtofly.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xie yuan bing
 * @date 2021-11-26 09:18
 */
public class DynamicProxyFactory implements InvocationHandler {

    private Object target;

    public DynamicProxyFactory(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理：方法执行前");
        Object retVal = method.invoke(target, args);
        System.out.println("代理：方法执行后");
        return retVal;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        DynamicProxyFactory factory = new DynamicProxyFactory(new Person());
        Object person = factory.getProxy();
        BuyService buy = (BuyService) person;
        buy.buy();
        PayService pay = (PayService) person;
        pay.pay();
        createProxyClassFile(person);
    }

    private static void createProxyClassFile(Object proxy) {
        String name = proxy.getClass().getName();
        byte[] bytes = ProxyGenerator.generateProxyClass(name, new Class[]{proxy.getClass()});
        try (FileOutputStream out = new FileOutputStream(name + ".class")) {
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
