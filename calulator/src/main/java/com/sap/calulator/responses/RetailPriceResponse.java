package com.sap.calulator.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetailPriceResponse {
	
	@JsonProperty("BillingCurrency")
	private String billingCurrency;
	@JsonProperty("CustomerEntityId")
	private String customerEntityId;
	@JsonProperty("CustomerEntityType")
	private String customerEntityType;
	@JsonProperty("Items")
	private List<Item> items = null;
	@JsonProperty("NextPageLink")
	private String nextPageLink;
	@JsonProperty("Count")
	private Integer count;

	public String getBillingCurrency() {
		return billingCurrency;
	}

	public void setBillingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
	}

	public String getCustomerEntityId() {
		return customerEntityId;
	}

	public void setCustomerEntityId(String customerEntityId) {
		this.customerEntityId = customerEntityId;
	}

	public String getCustomerEntityType() {
		return customerEntityType;
	}

	public void setCustomerEntityType(String customerEntityType) {
		this.customerEntityType = customerEntityType;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getNextPageLink() {
		return nextPageLink;
	}

	public void setNextPageLink(String nextPageLink) {
		this.nextPageLink = nextPageLink;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
