package jix.core;

import jix.interaction.ICommand;
import jix.interaction.ICommandFactory;
import jix.interaction.ICommandProcessor;

public class VoiceCommandFactory implements ICommandFactory {
	@Override
	public ICommandProcessor getCommandProcessor() {
		return VoiceCommandProcessor.getInstance();
	}

	@Override
	public ICommand getCommand(Object rawData) {
		// TODO Auto-generated method stub
		return null;
	}

}
