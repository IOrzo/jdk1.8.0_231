package an.sixtofly.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author xie yuan bing
 * @date 2021-06-24 17:52
 */
public class RmiClientTest {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5973);
            Calculator calculator = (Calculator) registry.lookup("calculator");
            System.out.println("rmi client -> result: " + calculator.add(1, 1));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
