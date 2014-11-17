package com.atlantis.gui;

import java.awt.Image;

import javax.swing.ImageIcon;

public interface UIConstants {
	public static int ICON_WIDTH = 48, ICON_HEIGHT = 48;
	public static String APP_TITLE = "Atlantis - Portware Launcher";
	public static String BASE_DIR = "resources/images/skins/basic/";
	public static Image START_ALL = new ImageIcon(BASE_DIR+"10.png").getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
	public static Image STARTING_ALL = new ImageIcon(BASE_DIR+"11.gif").getImage();
	public static Image FAILED_TO_START_ALL = new ImageIcon(BASE_DIR+"12.png").getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
	public static Image STARTED_ALL = new ImageIcon(BASE_DIR+"13.png").getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
	public static Image STOP_ALL = new ImageIcon(BASE_DIR+"20.png").getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
	public static Image RESTART_ALL = new ImageIcon(BASE_DIR+"30.png").getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
	public static Image MODULE_DOWN = new ImageIcon(BASE_DIR+"40.png").getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
	public static Image MODULE_STARTING = new ImageIcon(BASE_DIR+"41.gif").getImage();
	public static Image MODULE_FAILED_TO_START = new ImageIcon(BASE_DIR+"42.gif").getImage();
	public static Image MODULE_UP = new ImageIcon(BASE_DIR+"43.png").getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);	
}
