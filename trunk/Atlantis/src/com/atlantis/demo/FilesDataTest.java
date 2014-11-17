package com.atlantis.demo;

import java.io.File;

import com.atlantis.model.Config;

public class FilesDataTest {
	public static void main(String[] args) {
		System.out.println(Config.PORTWARE_HOME);
		System.out.println(Config.TRADEMONITOR_LOG_DIR);
		System.out.println(Config.APPSERVER_LOG_DIR);
		System.out.println(Config.BASKETSERVER_LOG_DIR);
		invokeBatchFile(Config.PORTWARE_HOME+"//bin//runtm.bat", Config.PORTWARE_HOME+"//bin");
	}

	public synchronized static final boolean invokeBatchFile(String batchFileLocation, String workingDirectory) {
		try {
			Process p = Runtime.getRuntime().exec(
					"cmd /c start "+batchFileLocation
					, null
					, new File(workingDirectory));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
