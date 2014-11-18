package com.atlantis.model;

import com.atlantis.AtlantisContext;

public class BS_Daemon extends Thread {
	@Override
	public void run() {
		BasketServerInfoBean infoBean = AtlantisContext.BS_INFO;
	}
}