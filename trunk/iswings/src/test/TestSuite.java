package test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TestSuite extends SwingTestSuite{
	
	public TestSuite() {
		super();
		testCase1();
	}

	public void testCase1(){
		Container co = frame.getContentPane();
		co.removeAll();
		co.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton button = new JButton("Testing button");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		co.add(new JLabel("Happy"));
		co.add(button);		
		frame.setSize(800,600);
		frame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		new TestSuite();
	}
}
