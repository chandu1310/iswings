package com.atlantis;

import java.awt.Color;
import java.awt.Container;

import com.atlantis.core.GUIBuilder;
import com.atlantis.core.OpenFrame;
import com.atlantis.gui.AtlantisUIBuilder;
import com.atlantis.gui.GUIMediator;
import com.atlantis.gui.UIConstants;

public class AppWindow {
	private static AppWindow classInstance = new AppWindow();
	private OpenFrame frame = new OpenFrame(UIConstants.APP_TITLE);
	
	private AppWindow() {
		GUIMediator.getInstance().registerFrame(frame);

		Container co = frame.getContentPane();
		
		GUIBuilder builder = new AtlantisUIBuilder();
		builder.buildUI(co);
		
		co.setBackground(Color.WHITE);
		co.setForeground(Color.BLACK);

		frame.setSize(550,60);
	}
	
	public static AppWindow getInstance(){
		return classInstance;
	}
	
	public void showApp(boolean flag){
		if(flag)
			frame.setVisible(true);
		else
			frame.setVisible(false);
	}
}
