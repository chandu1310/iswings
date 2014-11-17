package com.atlantis.model;

public class Config {
	public static final String PORTWARE_HOME;
	static {
		String pw_home = System.getenv("ATLANTIS_PW_HOME");
		if(pw_home!=null && !"".equals(pw_home))
			PORTWARE_HOME = pw_home;
		else
			PORTWARE_HOME = "C:\\Portware";		
	}

	public final static String BASKETSERVER_LOG_DIR = PORTWARE_HOME+"data\\logs\\server\\"; //20130702122303.log
	public final static String APPSERVER_LOG_DIR = PORTWARE_HOME+"data\\logs\\appserver\\"; //appserver20130702_1217.log
	public final static String TRADEMONITOR_LOG_DIR = PORTWARE_HOME+"data\\logs\\trademonitor\\"; //20130702121729.log"
}
