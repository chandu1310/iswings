package test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.iswings.components.IButton;

import javax.swing.JFrame;

public class Test1 {

	public Test1() {
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents(frame.getContentPane());
		frame.setSize(800, 600);
		frame.setVisible(true);		
	}
	
	private void initComponents(Container co){
		co.removeAll();
		co.setLayout(new FlowLayout());
		
		IButton btn = new IButton("Test","Submit");
		co.add(btn);
	}
	
	
	public static void main(String[] args) {
		new Test1();
	}
}
