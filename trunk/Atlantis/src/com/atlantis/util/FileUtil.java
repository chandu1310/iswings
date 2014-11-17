package com.atlantis.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

import com.atlantis.model.CONSTANTS;
import com.atlantis.model.Config;

public class FileUtil {
	public static String getAppServerLog() {
		String path = Config.APPSERVER_LOG_DIR;
		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "AS" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.LogSuffix);
	}

	public static String getAppServerErr() {
		String path = Config.APPSERVER_LOG_DIR;

		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "AS" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.ErrSuffix);
	}

	public static String getAppServerOut() {
		String path = Config.APPSERVER_LOG_DIR;

		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "AS" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.OutSuffix);
	}

	public static String getTradeMonitorLog() {
		String path = Config.TRADEMONITOR_LOG_DIR;

		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "TM" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.LogSuffix);
	}

	public static String getTradeMonitorErr() {
		String path = Config.TRADEMONITOR_LOG_DIR;

		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "TM" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.ErrSuffix);
	}

	public static String getTradeMonitorOut() {
		String path = Config.TRADEMONITOR_LOG_DIR;

		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "TM" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.OutSuffix);
	}

	public static String getBasketServerLog() {
		String path = Config.BASKETSERVER_LOG_DIR;

		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "BS" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.LogSuffix);
	}
	public static String getBasketServerErr() {
		String path = Config.BASKETSERVER_LOG_DIR;

		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "BS" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.ErrSuffix);
	}
	public static String getBasketServerOut() {
		String path = Config.BASKETSERVER_LOG_DIR;

		Calendar cal = Calendar.getInstance();
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fileNamePrefix = "BS" + df2.format(cal.getTime());
		return getFile(path, fileNamePrefix,CONSTANTS.OutSuffix);
	}

	private static String getFile(String path, String fileNamePrefix,String fileNameSuffix) {
		File logFileDir = new File(path);
		File[] logFiles = logFileDir
				.listFiles(new MyFileFilter(fileNamePrefix,fileNameSuffix));

		if (logFiles.length == 0) {
			return null;
		} else if (logFiles.length > 1) {
			Arrays.sort(logFiles, new Comparator<File>() {
				@Override
				public int compare(File o1, File o2) {
					if (o1.lastModified() > o2.lastModified())
						return -1;
					else
						return 1;
				}
			});
		}
		return logFiles[0].getAbsolutePath();
	}

	private static class MyFileFilter implements FileFilter {
		String filePrefix;
		String fileSuffix;
		public MyFileFilter(String p,String s) {
			this.filePrefix = p;
			this.fileSuffix = s;
		}

		@Override
		public boolean accept(File arg0) {
			// Return log file name for todays run.
			// Form the filename from timestamp and check for it.

			return (arg0.getName().startsWith(filePrefix) && arg0.getName()
					.endsWith(fileSuffix));
		}
	}
	public static boolean isAppServerUp(String path) throws FileNotFoundException{
		final Scanner scanner = new Scanner(new File(path));
		while (scanner.hasNextLine()) {
		   final String lineFromFile = scanner.nextLine();
		   if(lineFromFile.contains("JBoss AS 7.2.0.Final \"Janus\" started in ")) { 
		      return true;
		   }
		}
		return false;
		
	}
	public static boolean isTradeMonitorUp(String path) throws FileNotFoundException{
		final Scanner scanner = new Scanner(new File(path));
		while (scanner.hasNextLine()) {
		   final String lineFromFile = scanner.nextLine();
		   if(lineFromFile.contains("<main>-<NOTICE>-<TradeMonitor.onFullyRead>-<Startup complete.>")) { 
		      return true;
		   }
		}
		return false;
		
	}
	public static boolean isBasketServerUp(String path) throws FileNotFoundException{
		final Scanner scanner = new Scanner(new File(path));
		while (scanner.hasNextLine()) {
		   final String lineFromFile = scanner.nextLine();
		   if(lineFromFile.contains("<main>-<NOTICE>-<ServerStartupProcess.initStartApplication>-<Startup complete.>")) { 
		      return true;
		   }
		}
		return false;
		}
	public static void openFile(String path){
		 Desktop dt = Desktop.getDesktop();
		    try {
				dt.open(new File(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
