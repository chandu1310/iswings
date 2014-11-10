package jix.core;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIStatusInterface extends Remote {
	Integer getStatus() throws RemoteException;
}
