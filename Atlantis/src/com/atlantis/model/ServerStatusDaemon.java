package com.atlantis.model;

import javax.swing.JOptionPane;

import com.atlantis.AtlantisContext;
import com.atlantis.model.ModelConstants.ServerStatus;

public class ServerStatusDaemon extends Thread {
	private static ServerStatusDaemon classInstance = new ServerStatusDaemon();
	private Thread as_thread = new AS_Daemon();
	private Thread tm_thread = new TM_Daemon();
	private Thread bs_thread = new BS_Daemon();
	
	private ServerStatusDaemon(){
	}
	
	public ServerStatusDaemon getInstance(){
		return classInstance;
	}
	
	public void startAll(){
		as_thread.start();
		tm_thread.start();
	}
	
	@Override
	public void run() {
		as_thread.start();
		tm_thread.start();
		sleepForSometime(5000);  // Let the daemons start! 
		while(AtlantisContext.AS_INFO.getStatus()==ServerStatus.SERVER_STARTING 
				&& AtlantisContext.AS_INFO.getStatus()==ServerStatus.SERVER_STARTING)
			sleepForSometime(5000);
		
		if(AtlantisContext.AS_INFO.getStatus()==ServerStatus.SERVER_UP    
				&& AtlantisContext.AS_INFO.getStatus()==ServerStatus.SERVER_UP){
			bs_thread.start();
			try{
			bs_thread.wait();
			as_thread.wait();
			tm_thread.wait();
			}catch(Exception er){
				JOptionPane.showMessageDialog(null, er.getMessage()); 
			}
		}
		else
			return;
	}
	
	private void sleepForSometime(int ms){
		try{
		Thread.sleep(ms);
		}catch(Exception er){
			er.printStackTrace();
		}		
	}
}
