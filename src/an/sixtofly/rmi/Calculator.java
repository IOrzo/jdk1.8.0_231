package an.sixtofly.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author xie yuan bing
 * @date 2021-06-24 17:46
 * @description
 */
public interface Calculator extends Remote {

    // 所有方法必须抛出 RemoteException
    long add(long a, long b) throws RemoteException;
}
