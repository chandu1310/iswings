package jix.core;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
 * Initialization:
 * - Bind a status object on rmiregistry to avoid re-initialization of JIX Engine across VMs
 */
public class JIXEngine {
	/*
	 * Check if status object is already bounded in registry else try to bind
	 * one.
	 */
	public boolean initializeRMIRegistry() {
		Registry registry = null;
		try {
			registry = LocateRegistry.createRegistry(1099);
		} catch (Exception er) {
			//Registry creation failed. Registry would have been already created and status is registered. Go ahead and check.
//			er.printStackTrace();
		}
		
		try{
			registry = LocateRegistry.getRegistry(null);
			RMIStatusInterface stub = (RMIStatusInterface) registry
					.lookup("JIX_RMI_STATUS");
			if (stub != null) {
				if (stub.getStatus() == 1)
					return true; // RMI is already initialized successfully.
			}
		}
		catch (Exception er) {			
			//Status is not available need to put it in the registry.
//			er.printStackTrace();
		}

		try {
			RMIStatus obj = new RMIStatus(1);
			RMIStatusInterface stub = (RMIStatusInterface) UnicastRemoteObject
					.exportObject(obj, 0);
			Naming.rebind("JIX_RMI_STATUS", stub);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// Something is not correct and we failed to initialize!
			// May be next time!
		}
		return false;
	}

	public void initJIXEngine() throws JIXException {
		if (!initializeRMIRegistry()) {
			throw new JIXException("Unable to initialize RMI registry for JIX.");
		}
	}

	public static void main(String[] args) throws IOException {
		final Object monitor = new Object();

		new Thread(new Runnable() {
			public void run() {
				try {
					JIXEngine engine = new JIXEngine();
					engine.initJIXEngine();
					synchronized (monitor) {
						monitor.wait();
					}
				} catch (JIXException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("RMI Registry Thread finished.");
			}
		}, "RMI Registry Thread").start();
		System.out.println("Press enter to exit...");
		System.in.read();
		synchronized (monitor) {
			monitor.notify();
		}
	}
}
