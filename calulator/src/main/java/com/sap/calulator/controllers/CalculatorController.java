package com.sap.calulator.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.calulator.requests.CalculateBestAppRequest;
//import com.sap.calulator.requests.CalculateBestVMRequest;
import com.sap.calulator.responses.CalculateBestAppResponse;
import com.sap.calulator.services.CalculatorService;

@RestController
public class CalculatorController {

	private Logger logger;
	private CalculatorService calculatorService;
	
	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.logger=LoggerFactory.getLogger(this.getClass());
		this.calculatorService=calculatorService;
	}
	
	
	@PostMapping(value = "/calculateApp")
	public Map<String, Object> returnBestApp(@RequestBody CalculateBestAppRequest request){
		logger.info("CONTROLLER_LAYER REQUEST {}",request.toString());
		Map<String, Object> response=new HashMap<String, Object>();
		
		try {
			response.put("STATUS", "SUCCESS");
			
			response.put("DATA", calculatorService.returnAppResponse(request.getVcpu(), request.getMemory(),
					request.getArmRegionName(),request.getPriceType(), request.getReservationTerm(), request.getUsage()));
		} catch (Exception e) {
			logger.error("CONTROLLER_LAYER {} {}",request.toString(),e.getMessage());
			response.put("STATUS", "FAILED");
			response.put("MESSAGE", e.getMessage());
		}
		return response;
	}
	
	@PostMapping(value = "/calculateHanaDB")
	public Map<String, Object> returnBestHanaDb(@RequestBody CalculateBestAppRequest request){
		logger.info("CONTROLLER_LAYER REQUEST {}",request.toString());
		Map<String, Object> response=new HashMap<String, Object>();
		
		try {
			response.put("STATUS", "SUCCESS");
			response.put("DATA", calculatorService.returnHanaDBResponse(request.getMemory(), request.getArmRegionName(),
					request.getPriceType(), request.getReservationTerm(),request.getUsage()));
		} catch (Exception e) {
			logger.error("CONTROLLER_LAYER {} {}",request.toString(),e.getMessage());
			response.put("STATUS", "FAILED");
			response.put("MESSAGE", e.getMessage());
		}
		return response;
	}
	
	@PostMapping(value = "/calculateStorage")
	public Map<String, Object> returnBestStorage(@RequestBody CalculateBestAppRequest request){
		logger.info("CONTROLLER_LAYER REQUEST {}",request.toString());
		Map<String, Object> response=new HashMap<String, Object>();
		
		try {
			response.put("STATUS", "SUCCESS");
			response.put("DATA", calculatorService.returnHanaDBResponse(request.getMemory(), request.getArmRegionName(),
					request.getPriceType(), request.getReservationTerm(),request.getUsage()));
		} catch (Exception e) {
			logger.error("CONTROLLER_LAYER {} {}",request.toString(),e.getMessage());
			response.put("STATUS", "FAILED");
			response.put("MESSAGE", e.getMessage());
		}
		return response;
	}
	
	/**
	@PostMapping(value = "/calculateVM")
	public Map<String, Object> returnBestVM(@RequestBody CalculateBestVMRequest request){
		logger.info("CONTROLLER_LAYER REQUEST {}",request.toString());
		Map<String, Object> response=new HashMap<String, Object>();
		
		try {
			response.put("STATUS", "SUCCESS");
			response.put("DATA", calculatorService.returnResponse(request.getVcpu(), request.getMemory()));
		} catch (Exception e) {
			logger.error("CONTROLLER_LAYER {} {}",request.toString(),e.getMessage());
			response.put("STATUS", "FAILED");
			response.put("MESSAGE", e.getMessage());
		}
		return response;
	}**/
	
	/**
	@PostMapping(value = "/calculateDB")
	public Map<String, Object> returnBestDB(@RequestBody CalculateBestVMRequest request){
		logger.info("CONTROLLER_LAYER REQUEST {}",request.toString());
		Map<String, Object> response=new HashMap<String, Object>();
		
		try {
			response.put("STATUS", "SUCCESS");
			response.put("DATA", calculatorService.returnResponse(request.getVcpu(), request.getMemory()));
		} catch (Exception e) {
			logger.error("CONTROLLER_LAYER {} {}",request.toString(),e.getMessage());
			response.put("STATUS", "FAILED");
			response.put("MESSAGE", e.getMessage());
		}
		return response;
	}**/
}
