package jix.core;

import jix.interaction.ICommand;
import jix.interaction.ICommandProcessor;

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
