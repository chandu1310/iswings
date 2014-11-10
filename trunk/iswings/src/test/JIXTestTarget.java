package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

import jix.components.IButton;
import jix.components.IComponent;
import jix.components.IFrame;

public class JIXTestTarget {

	public JIXTestTarget() {
		IFrame frame = new IFrame("JIXTESTFRAME", "JIX Test Frame");
		frame.getContentPane().setLayout(new FlowLayout());
		
		IButton btn = new IButton("TESTBUTTON", "Test Me!");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hi! Time is: "+Calendar.getInstance().getTime());
			}
		});
		frame.add((IComponent)btn);
		
		frame.setDefaultCloseOperation(IFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JIXTestTarget();
	}
}
