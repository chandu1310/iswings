package jix.components;

import java.awt.Component;

import javax.swing.JButton;

import jix.core.CommandShell;

public class IButton extends JButton implements IComponent {
	private static final long serialVersionUID = -3061113413610535825L;
	private final String ID;
	
	public IButton(String ID, String text) {
		super(text);
		CommandShell.getInstance();
		this.ID = ID;
	}
	
	@Override
	public Component getComponent() {
		return this;
	}
	
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}
}
