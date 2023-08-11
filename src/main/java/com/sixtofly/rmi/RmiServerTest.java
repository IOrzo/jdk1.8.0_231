package com.sixtofly.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author xie yuan bing
 * @date 2021-06-24 17:49
 */
public class RmiServerTest {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5973);
            Calculator calculator = new CalculatorImpl();
            registry.bind("calculator", calculator);
            System.out.println("Rmi Server ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
