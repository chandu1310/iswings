package com.atlantis.demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.atlantis.core.OpenFrame;

public class ComponentsDemo {

	public static void main(String[] args) {
		OpenFrame frame = new OpenFrame("PW Launcher");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container co = frame.getContentPane();
		co.setBackground(Color.WHITE);
		co.setLayout(new FlowLayout(FlowLayout.RIGHT));

		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
