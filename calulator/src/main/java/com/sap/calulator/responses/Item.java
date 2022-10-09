package com.sap.calulator.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
	
	@JsonProperty("currencyCode")
	private String currencyCode;
	@JsonProperty("tierMinimumUnits")
	private Double tierMinimumUnits;
	@JsonProperty("retailPrice")
	private Double retailPrice;
	@JsonProperty("unitPrice")
	private Double unitPrice;
	@JsonProperty("armRegionName")
	private String armRegionName;
	@JsonProperty("location")
	private String location;
	@JsonProperty("effectiveStartDate")
	private String effectiveStartDate;
	@JsonProperty("meterId")
	private String meterId;
	@JsonProperty("meterName")
	private String meterName;
	@JsonProperty("productId")
	private String productId;
	@JsonProperty("skuId")
	private String skuId;
	@JsonProperty("availabilityId")
	private Object availabilityId;
	@JsonProperty("productName")
	private String productName;
	@JsonProperty("skuName")
	private String skuName;
	@JsonProperty("serviceName")
	private String serviceName;
	@JsonProperty("serviceId")
	private String serviceId;
	@JsonProperty("serviceFamily")
	private String serviceFamily;
	@JsonProperty("unitOfMeasure")
	private String unitOfMeasure;
	@JsonProperty("type")
	private String type;
	@JsonProperty("isPrimaryMeterRegion")
	private Boolean isPrimaryMeterRegion;
	@JsonProperty("armSkuName")
	private String armSkuName;
	@JsonProperty("reservationTerm")
	private String reservationTerm;
	
	public String getReservationTerm() {
		return reservationTerm;
	}

	public void setReservationTerm(String reservationTerm) {
		this.reservationTerm = reservationTerm;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getTierMinimumUnits() {
		return tierMinimumUnits;
	}

	public void setTierMinimumUnits(Double tierMinimumUnits) {
		this.tierMinimumUnits = tierMinimumUnits;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getArmRegionName() {
		return armRegionName;
	}

	public void setArmRegionName(String armRegionName) {
		this.armRegionName = armRegionName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getMeterName() {
		return meterName;
	}

	public void setMeterName(String meterName) {
		this.meterName = meterName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Object getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(Object availabilityId) {
		this.availabilityId = availabilityId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceFamily() {
		return serviceFamily;
	}

	public void setServiceFamily(String serviceFamily) {
		this.serviceFamily = serviceFamily;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsPrimaryMeterRegion() {
		return isPrimaryMeterRegion;
	}

	public void setIsPrimaryMeterRegion(Boolean isPrimaryMeterRegion) {
		this.isPrimaryMeterRegion = isPrimaryMeterRegion;
	}

	public String getArmSkuName() {
		return armSkuName;
	}

	public void setArmSkuName(String armSkuName) {
		this.armSkuName = armSkuName;
	}


}
