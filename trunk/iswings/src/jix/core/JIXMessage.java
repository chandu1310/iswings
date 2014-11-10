package jix.core;

import java.io.Serializable;

public class JIXMessage implements Serializable {
	private String ID;
	private int eventType;
	private String params;
	
	public JIXMessage(String ID, int eventType, String params) {
		this.ID = ID;
		this.eventType = eventType;
		this.params = params;
	}

	public String getID() {
		return ID;
	}

	public int getEventType() {
		return eventType;
	}

	public String getParams() {
		return params;
	}
	
}
