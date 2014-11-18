package com.atlantis.model;

import com.atlantis.AtlantisContext;

public class TM_Daemon extends Thread {
	@Override
	public void run() {
		TradeMonitorInfoBean infoBean = AtlantisContext.TM_INFO;
	}
}