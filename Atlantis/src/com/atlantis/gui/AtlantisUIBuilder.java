package com.atlantis.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.atlantis.core.GUIBuilder;

public class AtlantisUIBuilder implements GUIBuilder, UIConstants {
	GUIMediator mediator = GUIMediator.getInstance();
	
	@Override
	public void buildUI(Container co) {		
		JLabel 
		startAllLbl = new JLabel(new ImageIcon(START_ALL)),
		stopAllLbl = new JLabel(new ImageIcon(STOP_ALL)),
		restartAllLbl = new JLabel(new ImageIcon(RESTART_ALL)),
		tradeMonitorStatusLbl = new JLabel(new ImageIcon(MODULE_UP)),
		appServerStatusLbl = new JLabel(new ImageIcon(MODULE_STARTING)),
		basketServerStatusLbl = new JLabel(new ImageIcon(MODULE_DOWN));
		mediator.registerStartAllLbl(startAllLbl);
		mediator.registerStopAllLbl(stopAllLbl);
		mediator.registerRestartAllLbl(restartAllLbl);
		mediator.registerTradeMonitorStatusLbl(tradeMonitorStatusLbl);
		mediator.registerAppServerStatusLbl(appServerStatusLbl);
		mediator.registerBasketServerStatusLbl(basketServerStatusLbl);
	
		JCheckBox 
		includeTM = new JCheckBox()
		,includeAS = new JCheckBox()
		,includeBS = new JCheckBox();
		mediator.registerIncludeTM(includeTM);
		mediator.registerIncludeAS(includeAS);
		mediator.registerIncludeBS(includeBS);
	
		co.setLayout(new BoxLayout(co, BoxLayout.LINE_AXIS));
		co.add(Box.createRigidArea(new Dimension(10, 0)));
		co.add(startAllLbl);
		co.add(Box.createRigidArea(new Dimension(15, 0)));
		co.add(stopAllLbl);
		co.add(Box.createRigidArea(new Dimension(15, 0)));
		co.add(restartAllLbl);		
		
		co.add(Box.createRigidArea(new Dimension(20, 0)));
		JPanel ckbox_p1 = new JPanel();
			ckbox_p1.setBackground(Color.WHITE);
			ckbox_p1.setMaximumSize(new Dimension(40,60));
			includeTM.setSelected(true);
			includeTM.setBackground(Color.WHITE);
			ckbox_p1.add(includeTM);
		co.add(ckbox_p1);
		tradeMonitorStatusLbl.setVerticalAlignment(JLabel.TOP);
        tradeMonitorStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		co.add(tradeMonitorStatusLbl);
		
		co.add(Box.createRigidArea(new Dimension(20, 0)));
		JPanel ckbox_p2 = new JPanel();
			ckbox_p2.setBackground(Color.WHITE);
			ckbox_p2.setMaximumSize(new Dimension(40,60));
			includeAS.setSelected(true);
			includeAS.setBackground(Color.WHITE);
			ckbox_p2.add(includeAS);
		co.add(ckbox_p2);
		appServerStatusLbl.setVerticalAlignment(JLabel.TOP);
		appServerStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		co.add(appServerStatusLbl);
		
		co.add(Box.createRigidArea(new Dimension(20, 0)));
		JPanel ckbox_p3 = new JPanel();
			ckbox_p3.setBackground(Color.WHITE);
			ckbox_p3.setMaximumSize(new Dimension(40,60));
			includeBS.setSelected(true);
			includeBS.setBackground(Color.WHITE);
			ckbox_p3.add(includeBS);
		co.add(ckbox_p3);		
		basketServerStatusLbl.setVerticalAlignment(JLabel.TOP);
		basketServerStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		co.add(basketServerStatusLbl);
		
		
	}
	
	public static String transformStringToHtml(String strToTransform) {
	    String ans = "<html>";
	    String br = "<br>";
	    String[] lettersArr = strToTransform.split("");
	    for (String letter : lettersArr) {
	        ans += letter + br;
	    }
	    ans += "</html>";
	    return ans;
	}
}
