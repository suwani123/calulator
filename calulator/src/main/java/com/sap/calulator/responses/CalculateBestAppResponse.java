package com.sap.calulator.responses;

public class CalculateBestAppResponse {
	private String VMName;
	private long vcpu;
	private long memory;
	private long saps;
	private double price;
	public String getVMName() {
		return VMName;
	}
	public void setVMName(String vMName) {
		VMName = vMName;
	}
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
	public long getSaps() {
		return saps;
	}
	public void setSaps(long saps) {
		this.saps = saps;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CalculateBestVMResponse [VMName=" + VMName + ", vcpu=" + vcpu + ", memory=" + memory + ", saps=" + saps
				+ ", price=" + price + "]";
	}

}
