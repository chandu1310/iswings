package rmitest;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

public class DestinationDesktopApplication implements DesktopApplicationInterface {
	private String appID = "";

	public DestinationDesktopApplication(String appID) {
		this.appID = appID;
	}

	public String getAppID(){
		return this.appID;
	}
	
	@Override
	public String sayHello() throws RemoteException {
		return "Hi! This is "+appID+". Time now is: "+Calendar.getInstance().getTime().toString();
	}

	public static void main(String args[]) {

		try {
			DestinationDesktopApplication obj = new DestinationDesktopApplication("CHANDU01");
			DesktopApplicationInterface stub = (DesktopApplicationInterface) UnicastRemoteObject
					.exportObject(obj, 0);

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			Remote rObj = registry.lookup(obj.getAppID());
			if(obj==null)
				registry.bind(obj.getAppID(), stub); // Bind as the application identifier.
			else{
				registry.unbind(obj.getAppID());
				registry.bind(obj.getAppID(), stub); // Bind as the application identifier.
			}
			System.out.println("Desktop application "+obj.getAppID()+" is ready to take commands.");
		} catch (Exception e) {
			System.out.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
