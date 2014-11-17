package com.atlantis;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.atlantis.core.GUIBuilder;
import com.atlantis.core.OpenFrame;
import com.atlantis.gui.AtlantisUIBuilder;

public class Main {
	private OpenFrame frame = new OpenFrame("PW Launcher");
	
	public Main() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container co = frame.getContentPane();
		
		GUIBuilder builder = new AtlantisUIBuilder();
		builder.buildUI(co);
		
		co.setBackground(Color.WHITE);
		co.setForeground(Color.BLACK);

		frame.setSize(550,60);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main app = new Main();
	}
}
