package com.atlantis.model;

public class TradeMonitorInfoBean extends ServerInfoBean {
	private static TradeMonitorInfoBean classInstance = new TradeMonitorInfoBean();
	private TradeMonitorInfoBean() {
	}
	public static TradeMonitorInfoBean getInstance(){
		return classInstance;
	}
}
