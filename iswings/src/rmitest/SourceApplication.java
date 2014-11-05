package rmitest;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SourceApplication {
	private SourceApplication() {

	}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			LocateRegistry.createRegistry(1099);
		}catch(Exception er){}
		try{
			Registry registry = LocateRegistry.getRegistry(host);
			DesktopApplicationInterface stub = (DesktopApplicationInterface) registry.lookup("CHANDU01");
			String response = stub.sayHello();
			System.out.println("response: " + response);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
