package com.atlantis.core;

public class AtlantisContext {
	private static AtlantisContext _context;

	private String appServerSTime;
	//private String appServerETime;
	private String tradeMonitorSTime;
	//private String tradeMonitorETime;
	private String basketServerSTime;
	//private String basketServerETime;
	private String appServerStatus;
	private String tradeMonitorStatus;
	private String basketServerStatus;
	private boolean isAppServerInvoked = false;
	private boolean isTradeMonitorInvoked = false;
	private boolean isBasketServerInvoked = false;

	
	public String getAppServerSTime() {
		return appServerSTime;
	}

	public void setAppServerSTime(String appServerSTime) {
		this.appServerSTime = appServerSTime;
	}

	public String getTradeMonitorSTime() {
		return tradeMonitorSTime;
	}

	public void setTradeMonitorSTime(String tradeMonitorSTime) {
		this.tradeMonitorSTime = tradeMonitorSTime;
	}

	public String getBasketServerSTime() {
		return basketServerSTime;
	}

	public void setBasketServerSTime(String basketServerSTime) {
		this.basketServerSTime = basketServerSTime;
	}

	public boolean isAppServerInvoked() {
		return isAppServerInvoked;
	}

	public void setAppServerInvoked(boolean isAppServerInvoked) {
		this.isAppServerInvoked = isAppServerInvoked;
	}

	public boolean isTradeMonitorInvoked() {
		return isTradeMonitorInvoked;
	}

	public void setTradeMonitorInvoked(boolean isTradeMonitorInvoked) {
		this.isTradeMonitorInvoked = isTradeMonitorInvoked;
	}

	public boolean isBasketServerInvoked() {
		return isBasketServerInvoked;
	}

	public void setBasketServerInvoked(boolean isBasketServerInvoked) {
		this.isBasketServerInvoked = isBasketServerInvoked;
	}

	public String getAppServerStatus() {
		return appServerStatus;
	}

	public void setAppServerStatus(String appServerStatus) {
		this.appServerStatus = appServerStatus;
	}

	public String getTradeMonitorStatus() {
		return tradeMonitorStatus;
	}

	public void setTradeMonitorStatus(String tradeMonitorStatus) {
		this.tradeMonitorStatus = tradeMonitorStatus;
	}

	public String getBasketServerStatus() {
		return basketServerStatus;
	}

	public void setBasketServerStatus(String basketServerStatus) {
		this.basketServerStatus = basketServerStatus;
	}

	public static AtlantisContext getInstance() {
		if (_context == null) {
			_context = new AtlantisContext();
		}
		return _context;
	}

}
