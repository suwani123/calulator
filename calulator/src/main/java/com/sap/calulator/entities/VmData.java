package com.sap.calulator.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vm_data")
public class VmData {
	
	@Id
	private String vmName;
	private long vmNumber;
	private String sku;
	private String vmType;	
	private String armSkuName;
	private String vmfamily;
	private long vcpu;
	private long memory;
	private long tempDisk;
	private long maxDiskThroughput;
	private long maxDiskIOPS;
	private long maxDataDisk;
	private long saps;
	private boolean isAccelatedNetwork;
	private boolean isHANACerified;
	private boolean isNWCertified;
	private boolean isBICertified;
	private String chipset;
	
	public long getVmNumber() {
		return vmNumber;
	}
	public void setVmNumber(long vmNumber) {
		this.vmNumber = vmNumber;
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
	public long getTempDisk() {
		return tempDisk;
	}
	public void setTempDisk(long tempDisk) {
		this.tempDisk = tempDisk;
	}
	public long getMaxDiskThroughput() {
		return maxDiskThroughput;
	}
	public void setMaxDiskThroughput(long maxDiskThroughput) {
		this.maxDiskThroughput = maxDiskThroughput;
	}
	public long getMaxDiskIOPS() {
		return maxDiskIOPS;
	}
	public void setMaxDiskIOPS(long maxDiskIOPS) {
		this.maxDiskIOPS = maxDiskIOPS;
	}
	public long getMaxDataDisk() {
		return maxDataDisk;
	}
	public void setMaxDataDisk(long maxDataDisk) {
		this.maxDataDisk = maxDataDisk;
	}
	public long getSaps() {
		return saps;
	}
	public void setSaps(long saps) {
		this.saps = saps;
	}
	public boolean isAccelatedNetwork() {
		return isAccelatedNetwork;
	}
	public void setAccelatedNetwork(boolean isAccelatedNetwork) {
		this.isAccelatedNetwork = isAccelatedNetwork;
	}
	public boolean isHANACerified() {
		return isHANACerified;
	}
	public void setHANACerified(boolean isHANACerified) {
		this.isHANACerified = isHANACerified;
	}
	public boolean isNWCertified() {
		return isNWCertified;
	}
	public void setNWCertified(boolean isNWCertified) {
		this.isNWCertified = isNWCertified;
	}
	public String getChipset() {
		return chipset;
	}
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	@Override
	public String toString() {
		return "MetaData [vmNumber=" + vmNumber + ", vmName=" + vmName + ", vcpu=" + vcpu + ", memory=" + memory
				+ ", tempDisk=" + tempDisk + ", maxDiskThroughput=" + maxDiskThroughput + ", maxDiskIOPS=" + maxDiskIOPS
				+ ", maxDataDisk=" + maxDataDisk + ", saps=" + saps + ", isAccelatedNetwork=" + isAccelatedNetwork
				+ ", isHANACerified=" + isHANACerified + ", isNWCertified=" + isNWCertified + ", chipset=" + chipset
				+ "]";
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getVmType() {
		return vmType;
	}
	public void setVmType(String vmType) {
		this.vmType = vmType;
	}
	public String getVmName() {
		return vmName;
	}
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}
	public String getArmSkuName() {
		return armSkuName;
	}
	public void setArmSkuName(String armSkuName) {
		this.armSkuName = armSkuName;
	}
	public String getVmfamily() {
		return vmfamily;
	}
	public void setVmfamily(String vmfamily) {
		this.vmfamily = vmfamily;
	}
	public boolean isBICertified() {
		return isBICertified;
	}
	public void setBICertified(boolean isBICertified) {
		this.isBICertified = isBICertified;
	}
	
	
}