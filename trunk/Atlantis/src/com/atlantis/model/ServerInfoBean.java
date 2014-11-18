package com.atlantis.model;


public class ServerInfoBean implements ModelConstants {
	private ServerStatus status = ServerStatus.SERVER_DOWN;
	
	public ServerStatus getStatus() {
		return status;
	}
	public void setStatus(ServerStatus status) {
		this.status = status;
	}	
}
