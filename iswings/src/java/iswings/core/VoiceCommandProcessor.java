package java.iswings.core;

import java.interaction.ICommand;
import java.interaction.ICommandProcessor;

public class VoiceCommandProcessor implements ICommandProcessor {
	private static final ICommandProcessor classInstance = new VoiceCommandProcessor();
	
	private VoiceCommandProcessor(){	
	}
	
	public static ICommandProcessor getInstance(){
		return classInstance;
	}
	
	@Override
	public void processCommand(ICommand command) {
		
	}
}
