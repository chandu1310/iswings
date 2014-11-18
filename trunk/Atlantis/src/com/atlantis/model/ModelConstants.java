package com.atlantis.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public interface ModelConstants {
	public static final int TM_VIEW = 1;
	public static final int BS_VIEW = 2;
	public static final int AS_VIEW = 3;
	public static final long TIMEOUT = 300000;
	public static final String LogSuffix= ".log";
	public static final String ErrSuffix= ".err";
	public static final String OutSuffix= ".out";
	public static final Icon OFFLINE_ICON = new ImageIcon("//icons//offline-globe.png");
	public static final Icon ONLINE_ICON = new ImageIcon("//icons//online-globe.png");
	
	//Server status constants
	public enum ServerStatus{
		SERVER_DOWN,
		SERVER_UP,
		SERVER_STARTING,
		SERVER_FAILED
	}	

	public static final String APPSERVERDF= "yyMMMddHH";
	public static final String BASKERSERVERDF="yyyymmddkk";
	public static final String TRADEMONITORDF="yyyymmddkk";
}
