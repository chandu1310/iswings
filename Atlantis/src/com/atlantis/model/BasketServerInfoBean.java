package com.atlantis.model;

public class BasketServerInfoBean extends ServerInfoBean {
	private static BasketServerInfoBean classInstance = new BasketServerInfoBean();
	private BasketServerInfoBean() {
	}
	public static BasketServerInfoBean getInstance(){
		return classInstance;
	}

}
