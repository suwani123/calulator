package com.sap.calulator.services;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.json.simple.JSONObject;

import com.sap.calulator.repositories.VmDataRepository;
import com.sap.calulator.responses.Item;
import com.sap.calulator.responses.RetailPriceResponse;

@Service
public class PriceService {
	
	private Logger logger;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public PriceService(RestTemplate restTemplate) {
		this.logger=LoggerFactory.getLogger(this.getClass());
		this.restTemplate = restTemplate;
		
	}
	
	
	public double getVmPrice(String armRegionName, String armSkuName, String priceType,String reservationTerm,double usage) throws Exception {
		
		logger.info("SERVICE_LAYER {} {}",armRegionName,armSkuName);
		StringBuilder buildUrl = new StringBuilder();
		buildUrl.append("https://prices.azure.com/api/retail/prices?$filter=serviceName eq 'Virtual Machines'");
		double vmRetailPrice = 0.0;
		if(armRegionName!=null) {
			buildUrl.append(" and armRegionName eq '");
			buildUrl.append(armRegionName);
			buildUrl.append("'");
		}
		if(armSkuName!=null) {
			buildUrl.append(" and armSkuName eq '");
			armSkuName = armSkuName.replace("(", "");
			armSkuName = armSkuName.replace(")", "");
			buildUrl.append(armSkuName);
			buildUrl.append("'");
		}
		if (priceType!=null) {
			buildUrl.append(" and priceType eq '");
			buildUrl.append(priceType);
			buildUrl.append("'");
			if (priceType.equalsIgnoreCase("Reservation")) {
				buildUrl.append(" and reservationTerm eq '");
				buildUrl.append(reservationTerm);
				buildUrl.append("'");
			}
			
		}
		String url = buildUrl.toString();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestObject = new HttpEntity<>(headers);
		ResponseEntity<RetailPriceResponse> responseBodyOptional = restTemplate.exchange(url, HttpMethod.GET,
				requestObject, RetailPriceResponse.class);
		RetailPriceResponse responseBody = responseBodyOptional.getBody();
		
		List<Item> items = responseBody.getItems();
		if (items!= null && items.size()>0) {
			Item item = items.get(0);
			
			if (priceType.equalsIgnoreCase("Reservation")) {
				String reservTerm = item.getReservationTerm();
				long reservTermValue =1;
				if(reservTerm!=null && reservTerm.length()>0) {
					reservTermValue = Long.parseLong(""+reservTerm.charAt(0));
				}
				vmRetailPrice = item.getRetailPrice()/ reservTermValue;
				vmRetailPrice = vmRetailPrice / 12;
			}
			else {
				vmRetailPrice = item.getRetailPrice()* 730;
				vmRetailPrice = vmRetailPrice * usage;
			}
			System.out.println("Retail SKU : "+ armSkuName + " Price : " + vmRetailPrice);
		}
	    
		
		return vmRetailPrice;
	}
	
public double getHanaStoragePrice(String armRegionName, String meterName) throws Exception {
		
		logger.info("getStoragePrice {} {}",armRegionName,meterName);
		StringBuilder buildUrl = new StringBuilder();
		buildUrl.append("https://prices.azure.com/api/retail/prices?$filter=serviceName eq 'Storage' ");
		double vmRetailPrice = 0.0;
		
		if(armRegionName!=null) {
			buildUrl.append(" and armRegionName eq '");
			buildUrl.append(armRegionName);
			buildUrl.append("'");
		}
		
		buildUrl.append(" and productName eq '");
		buildUrl.append("Premium SSD Managed Disks");
		buildUrl.append("'");
		
		if (meterName!=null) {
			buildUrl.append(" and meterName eq '");
			buildUrl.append(meterName);
			buildUrl.append(" LRS Disk");
			buildUrl.append("'");
						
		}
		String url = buildUrl.toString();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestObject = new HttpEntity<>(headers);
		ResponseEntity<RetailPriceResponse> responseBodyOptional = restTemplate.exchange(url, HttpMethod.GET,
				requestObject, RetailPriceResponse.class);
		RetailPriceResponse responseBody = responseBodyOptional.getBody();
		
		List<Item> items = responseBody.getItems();
		if (items!= null && items.size()>0) {
			Item item = items.get(0);
			
			vmRetailPrice = item.getRetailPrice();
			
			System.out.println("Retail productName : "+ meterName + " Price : " + vmRetailPrice);
		}
	    
		
		return vmRetailPrice;
	}

}
