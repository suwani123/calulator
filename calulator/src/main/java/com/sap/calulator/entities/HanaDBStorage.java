package com.sap.calulator.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hana_db_storage")
public class HanaDBStorage {
	
	@Id
	private String vmName;
	private long memory;
	private String hanaDataSku;
	private long hanaDataCount;
	private String hanaLogSku;
	private long hanaLogCount;
	private String hanaSharedSku;
	private long hanaSharedCount;
	private String hanaRootSku;
	private long hanaRootCount;
	private String hanaSapSku;
	private long hanaSapCount;
	
	
	
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
	
	@Override
	public String toString() {
		return "HanaDBStorage [vmName=" + vmName + ", memory=" + memory + ", hanaDataSku=" + hanaDataSku
				+ ", hanaDataCount=" + hanaDataCount + ", hanaLogSku=" + hanaLogSku + ", hanaLogCount=" + hanaLogCount
				+ ", hanaSharedSku=" + hanaSharedSku + ", hanaSharedCount=" + hanaSharedCount + ", hanaRootSku="
				+ hanaRootSku + ", hanaRootCount=" + hanaRootCount + ", hanaSapSku=" + hanaSapSku + ", hanaSapCount="
				+ hanaSapCount + "]";
	}

}
