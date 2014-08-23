package rmitest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DesktopApplicationInterface extends Remote {
    String sayHello() throws RemoteException;
}