package com.sap.calulator.requests;

public class CalculateBestHanaStorageRequest {
	
	private String vmName;
	private long memory;
	private String armRegionName;
	
	public String getVmName() {
		return vmName;
	}
	public void setVMName(String vmName) {
		this.vmName = vmName;
	}
	public long getMemory() {
		return memory;
	}
	public void setMemory(long memory) {
		this.memory = memory;
	}
	@Override
	public String toString() {
		return "CalculateBestHanaStorageRequest [vmName=" + vmName + ", memory=" + memory + "]";
	}
	public String getArmRegionName() {
		return armRegionName;
	}
	public void setArmRegionName(String armRegionName) {
		this.armRegionName = armRegionName;
	}
	
	

}
