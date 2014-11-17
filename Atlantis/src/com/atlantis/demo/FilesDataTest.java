package com.atlantis.demo;

import com.atlantis.core.AtlantisContext;
import com.atlantis.util.FileUtil;

public class FilesDataTest {
	public static void main(String[] args) {
		
		
	//	System.out.println(FileUtil.getAppServerLog());
				System.out.println(AtlantisContext.getInstance().isAppServerInvoked());
		FileUtil.startAppServer();
		System.out.println(AtlantisContext.getInstance().isAppServerInvoked());
		System.out.println(AtlantisContext.getInstance().getAppServerStatus());
		FileUtil.startAppServer();
		System.out.println(AtlantisContext.getInstance().getAppServerStatus());

	}
}
