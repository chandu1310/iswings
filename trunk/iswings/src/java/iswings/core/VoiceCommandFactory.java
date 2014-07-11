package java.iswings.core;

import java.interaction.ICommand;
import java.interaction.ICommandFactory;
import java.interaction.ICommandProcessor;

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
