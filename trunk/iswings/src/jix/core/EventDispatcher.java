package jix.core;

public class EventDispatcher {

	private static final EventDispatcher obj = new EventDispatcher();
	
	private EventDispatcher(){
		
	}
	
	public static EventDispatcher getInstance(){
		return obj;
	}
	
	public void processCommand(Object obj){
		String command = (String)obj;
		System.out.println("Processing command: "+command+" - "+Thread.currentThread().getName());		
	}	
}
