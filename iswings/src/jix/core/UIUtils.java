package jix.core;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jix.components.IComponent;
import jix.components.IConstants;
import jix.components.IContainer;
import jix.components.IConstants.EventType;

public class UIUtils {

	public synchronized static void dispatchEvent(IComponent comp,
			IConstants.EventType event) {
		if (event == EventType.ACTION) {
			dispatchActionEvent(comp);
		} else if (event == EventType.MOUSE) {

		} else if (event == EventType.WINDOW) {
			if (comp instanceof IContainer) {

			}
		}
	}

	private synchronized static void dispatchActionEvent(IComponent comp) {
		ActionEvent event = null;
		Component co = comp.getComponent();
		ActionListener[] listeners = null;
		if (co instanceof JButton) {
			JButton btn = (JButton)co;
			event = new ActionEvent(btn, ActionEvent.ACTION_PERFORMED, btn.getActionCommand());
			listeners = ((JButton) co).getActionListeners();
		} else if (co instanceof JCheckBox) {
			listeners = ((JCheckBox) co).getActionListeners();
		} else if (co instanceof JFileChooser) {
			listeners = ((JFileChooser) co).getActionListeners();
		} else if (co instanceof JMenuItem) {
			listeners = ((JMenuItem) co).getActionListeners();
		} else if (co instanceof JPasswordField) {
			listeners = ((JPasswordField) co).getActionListeners();
		} else if (co instanceof JRadioButton) {
			listeners = ((JRadioButton) co).getActionListeners();
		} else if (co instanceof JTextField) {
			listeners = ((JTextField) co).getActionListeners();
		} else {
			event = null;
		}
		
		
		if (event == null || listeners == null || listeners.length == 0)
			return;

		final ActionEvent ae = event;
		
		for (final ActionListener l : listeners) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					l.actionPerformed(ae);
				}
			});
		}
	}
}
