package com.atlantis.model;

import com.atlantis.AtlantisContext;

public class AS_Daemon extends  Thread {
	@Override
	public void run() {
		AppServerInfoBean infoBean = AtlantisContext.AS_INFO;
	}
}