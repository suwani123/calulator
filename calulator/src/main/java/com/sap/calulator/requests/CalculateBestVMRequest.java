package com.sap.calulator.requests;

public class CalculateBestVMRequest {

	private long vcpu;
	private long memory;
	public long getVcpu() {
		return vcpu;
	}
	public void setVcpu(long vcpu) {
		this.vcpu = vcpu;
	}
	
	public long getMemory() {
		return memory;
	}
	public void setMemory(long memory) {
		this.memory = memory;
	}
	@Override
	public String toString() {
		return "CalculateBestVMRequest [vcpu=" + vcpu + ", memory=" + memory + "]";
	}
	
}
