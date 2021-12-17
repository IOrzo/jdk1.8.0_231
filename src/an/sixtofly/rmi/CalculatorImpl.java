package an.sixtofly.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author xie yuan bing
 * @date 2021-06-24 17:47
 */
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    protected CalculatorImpl() throws RemoteException {
        System.out.println("CalculatorImpl()");
    }

    @Override
    public long add(long a, long b) {
        return a + b;
    }
}
