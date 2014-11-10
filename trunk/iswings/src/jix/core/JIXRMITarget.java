package jix.core;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JIXRMITarget extends Remote{
	String invoke(JIXMessage message) throws RemoteException;
}
