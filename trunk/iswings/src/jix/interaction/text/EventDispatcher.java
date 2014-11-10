package jix.interaction.text;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import jix.core.JIXMessage;
import jix.core.JIXRMITarget;
import jix.core.RMIStatusInterface;

public class EventDispatcher {

	private static final EventDispatcher obj = new EventDispatcher();
	
	private EventDispatcher(){
		
	}
	
	public static EventDispatcher getInstance(){
		return obj;
	}
	
	public void processCommand(Object obj){
		String command = (String)obj;
		if(command!=null && !"".equals(command)){
			String[] parts = command.split("~");
			String windowID = parts[0];		
			//WINDOWID~ID##EVENT##PARAMS
			String[] subparts = parts[1].split("##");
			JIXMessage message = new JIXMessage(subparts[0], Integer.parseInt(subparts[1]), subparts[2]);			
			System.out.println("Processing command: "+command+" - "+Thread.currentThread().getName());
			invokeRMIMethod(windowID, message);
		}
	}
	
	private void invokeRMIMethod(String windowID, JIXMessage message){
		try{
			Registry registry = LocateRegistry.getRegistry(null);
			JIXRMITarget stub = (JIXRMITarget) registry
					.lookup(windowID);
			if (stub != null) {
				stub.invoke(message);
			}
		}
		catch (Exception er) {			
			//Status is not available need to put it in the registry.
//			er.printStackTrace();
		}
	}
}
