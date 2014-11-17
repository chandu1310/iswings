package com.atlantis.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.atlantis.core.GUIBuilder;
import com.atlantis.core.SmartImageLabel;

public class AtlantisUIBuilder implements GUIBuilder, UIConstants {
	
	public static BufferedImage resize(BufferedImage image, int width, int height) {
	    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, width, height, null);
	    g2d.dispose();
	    return bi;
	}
	
	private JLabel 
	startAllLbl = new JLabel(new ImageIcon(STARTING_ALL)),
	stopAllLbl = new JLabel(new ImageIcon(STOP_ALL)),
	restartAllLbl = new JLabel(new ImageIcon(RESTART_ALL)),
	tradeMonitorStatusLbl = new JLabel(new ImageIcon(MODULE_STARTING)),
	appServerStatusLbl = new JLabel(new ImageIcon(MODULE_STARTING)),
	basketServerStatusLbl = new JLabel(new ImageIcon(MODULE_STARTING));
	
	@Override
	public void buildUI(Container co) {
		
		co.setLayout(new BoxLayout(co, BoxLayout.LINE_AXIS));
		
		co.add(Box.createRigidArea(new Dimension(15, 0)));
		co.add(startAllLbl);
		co.add(Box.createRigidArea(new Dimension(15, 0)));
		co.add(stopAllLbl);
		co.add(Box.createRigidArea(new Dimension(15, 0)));
		co.add(restartAllLbl);		
		
		co.add(Box.createRigidArea(new Dimension(35, 0)));        
		tradeMonitorStatusLbl.setVerticalAlignment(JLabel.TOP);
        tradeMonitorStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		co.add(tradeMonitorStatusLbl);
		
		co.add(Box.createRigidArea(new Dimension(50, 0)));		
		appServerStatusLbl.setVerticalAlignment(JLabel.TOP);
		appServerStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		co.add(appServerStatusLbl);
		
		co.add(Box.createRigidArea(new Dimension(50, 0)));		
		basketServerStatusLbl.setVerticalAlignment(JLabel.TOP);
		basketServerStatusLbl.setHorizontalAlignment(JLabel.CENTER);
		co.add(basketServerStatusLbl);
	}
}
