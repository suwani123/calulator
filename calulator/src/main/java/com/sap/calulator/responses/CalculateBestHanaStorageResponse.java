package com.sap.calulator.responses;

public class CalculateBestHanaStorageResponse {
	
	private String vmName;
	private long memory;
	private String hanaDataSku;
	private long hanaDataCount;
	private double hanaDataPrice;
	private String hanaLogSku;
	private long hanaLogCount;
	private double hanaLogPrice;
	private String hanaSharedSku;
	private long hanaSharedCount;
	private double hanaSharedPrice;
	private String hanaRootSku;
	private long hanaRootCount;
	private double hanaRootPrice;
	private String hanaSapSku;
	private long hanaSapCount;
	private double hanaSapPrice;
	
	@Override
	public String toString() {
		return "CalculateBestHanaStorageResponse [vmName=" + vmName + ", memory=" + memory + ", hanaDataSku="
				+ hanaDataSku + ", hanaDataCount=" + hanaDataCount + ", hanaDataPrice=" + hanaDataPrice
				+ ", hanaLogSku=" + hanaLogSku + ", hanaLogCount=" + hanaLogCount + ", hanaLogPrice=" + hanaLogPrice
				+ ", hanaSharedSku=" + hanaSharedSku + ", hanaSharedCount=" + hanaSharedCount + ", hanaSharedPrice="
				+ hanaSharedPrice + ", hanaRootSku=" + hanaRootSku + ", hanaRootCount=" + hanaRootCount
				+ ", hanaRootPrice=" + hanaRootPrice + ", hanaSapSku=" + hanaSapSku + ", hanaSapCount=" + hanaSapCount
				+ ", hanaSapPrice=" + hanaSapPrice + "]";
	}
	
	public String toRecord() {
		return ","+ hanaDataSku + "," + hanaDataCount + "," + hanaLogSku +","
				+hanaLogCount+ "," + hanaSharedSku+"," +hanaSharedCount +"," + hanaRootSku +"," + hanaRootCount+","
				+hanaSapSku + "," + hanaSapCount;
	}
	
	public double toValue() {
		return 0.0+ (hanaDataCount*hanaDataPrice)+(hanaLogCount*hanaLogPrice)+(hanaSharedCount*hanaSharedPrice)+
				(hanaRootCount*hanaRootPrice)+(hanaSapCount*hanaSapPrice);
	}
	public String getVmName() {
		return vmName;
	}
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}
	public long getMemory() {
		return memory;
	}
	public void setMemory(long memory) {
		this.memory = memory;
	}
	public String getHanaDataSku() {
		return hanaDataSku;
	}
	public void setHanaDataSku(String hanaDataSku) {
		this.hanaDataSku = hanaDataSku;
	}
	public long getHanaDataCount() {
		return hanaDataCount;
	}
	public void setHanaDataCount(long hanaDataCount) {
		this.hanaDataCount = hanaDataCount;
	}
	public double getHanaDataPrice() {
		return hanaDataPrice;
	}
	public void setHanaDataPrice(double hanaDataPrice) {
		this.hanaDataPrice = hanaDataPrice;
	}
	public String getHanaLogSku() {
		return hanaLogSku;
	}
	public void setHanaLogSku(String hanaLogSku) {
		this.hanaLogSku = hanaLogSku;
	}
	public long getHanaLogCount() {
		return hanaLogCount;
	}
	public void setHanaLogCount(long hanaLogCount) {
		this.hanaLogCount = hanaLogCount;
	}
	public double getHanaLogPrice() {
		return hanaLogPrice;
	}
	public void setHanaLogPrice(double hanaLogPrice) {
		this.hanaLogPrice = hanaLogPrice;
	}
	public String getHanaSharedSku() {
		return hanaSharedSku;
	}
	public void setHanaSharedSku(String hanaSharedSku) {
		this.hanaSharedSku = hanaSharedSku;
	}
	public long getHanaSharedCount() {
		return hanaSharedCount;
	}
	public void setHanaSharedCount(long hanaSharedCount) {
		this.hanaSharedCount = hanaSharedCount;
	}
	public double getHanaSharedPrice() {
		return hanaSharedPrice;
	}
	public void setHanaSharedPrice(double hanaSharedPrice) {
		this.hanaSharedPrice = hanaSharedPrice;
	}
	public String getHanaRootSku() {
		return hanaRootSku;
	}
	public void setHanaRootSku(String hanaRootSku) {
		this.hanaRootSku = hanaRootSku;
	}
	public long getHanaRootCount() {
		return hanaRootCount;
	}
	public void setHanaRootCount(long hanaRootCount) {
		this.hanaRootCount = hanaRootCount;
	}
	public double getHanaRootPrice() {
		return hanaRootPrice;
	}
	public void setHanaRootPrice(double hanaRootPrice) {
		this.hanaRootPrice = hanaRootPrice;
	}
	public String getHanaSapSku() {
		return hanaSapSku;
	}
	public void setHanaSapSku(String hanaSapSku) {
		this.hanaSapSku = hanaSapSku;
	}
	public long getHanaSapCount() {
		return hanaSapCount;
	}
	public void setHanaSapCount(long hanaSapCount) {
		this.hanaSapCount = hanaSapCount;
	}
	public double getHanaSapPrice() {
		return hanaSapPrice;
	}
	public void setHanaSapPrice(double hanaSapPrice) {
		this.hanaSapPrice = hanaSapPrice;
	}

}
