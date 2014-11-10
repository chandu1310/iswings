package jix.core;


public class RMIStatus implements RMIStatusInterface {
	private int status;
	public RMIStatus(int status) {
		this.status = status;
	}
	
	@Override
	public Integer getStatus() {
		return this.status;
	}
}