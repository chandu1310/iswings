package com.atlantis.model;

public class AppServerInfoBean extends ServerInfoBean {
	private static AppServerInfoBean classInstance = new AppServerInfoBean();
	private AppServerInfoBean() {
	}
	public static AppServerInfoBean getInstance(){
		return classInstance;
	}

}
