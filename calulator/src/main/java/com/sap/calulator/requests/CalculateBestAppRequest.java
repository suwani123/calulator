package com.sap.calulator.requests;

public class CalculateBestAppRequest {
	private long vcpu;
	private long memory;
	private String armRegionName;
	private String priceType;
	private String reservationTerm;
	private double usage;
	
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
		return "CalculateBestVMRequest [vcpu=" + vcpu + ", memory=" + memory + ", priceType=\" + priceType + \"]";
	}
	public String getArmRegionName() {
		return armRegionName;
	}
	public void setArmRegionName(String armRegionName) {
		this.armRegionName = armRegionName;
	}
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public String getReservationTerm() {
		return reservationTerm;
	}
	public void setReservationTerm(String reservationTerm) {
		this.reservationTerm = reservationTerm;
	}
	public double getUsage() {
		return usage;
	}
	public void setUsage(double usage) {
		this.usage = usage;
	}

}
