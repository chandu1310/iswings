package java.iswings.components;

import java.iswings.core.CommandShell;

import javax.swing.JButton;

public class IButton extends JButton {
	private final String id;
	
	public IButton(String id, String text) {
		super(text);
		CommandShell.getInstance();
		this.id = id;
	}
	
	public final String getID(){
		return this.id;
	}
}
