package rmitest;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SourceApplication {
	private SourceApplication() {

	}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try{
			Registry registry = LocateRegistry.getRegistry(host);
			DesktopApplicationInterface stub = (DesktopApplicationInterface) registry.lookup("CHANDU02");
			if(stub!=null){
				String response = stub.sayHello();
				System.out.println("response: " + response);
			}
		}
		catch(java.rmi.ConnectException connExec){
			System.out.println("Target UI is unavailable right now.");
		}
		catch (Exception e) {
			System.out.println("Exception occured.");
			e.printStackTrace();
		}
	}
}
