package com.sap.calulator.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sap.calulator.entities.VmData;
import com.sap.calulator.repositories.VmDataRepository;
import com.sap.calulator.responses.CalculateBestAppResponse;

@Service
public class CalculatorService {

	private Logger logger;
	//private MetaDataRepository metaDataRepository;
	private VmDataRepository vmDataRepository;
	// Declaring the static map
    private static Map<String,Double> MAP=new HashMap<String, Double>();
    
    private RestTemplate restTemplate;
    
    
	@Autowired
	public CalculatorService(VmDataRepository vmDataRepository,RestTemplate restTemplate) {
		this.logger=LoggerFactory.getLogger(this.getClass());
		//this.metaDataRepository=metaDataRepository;
		this.vmDataRepository = vmDataRepository;
		this.restTemplate = restTemplate;
	}
	
	
public CalculateBestAppResponse returnAppResponse(long vcpu, long memory,String armRegionName, String priceType, String reservationTerm, double usage) throws Exception {
		
		logger.info("SERVICE_LAYER returnAppResponse {} {}",vcpu,memory);
		PriceService priceService = new PriceService(restTemplate);
		List<VmData> metaDataList= vmDataRepository.findAllByVcpuAndMemoryOrderBySapsDesc(vcpu, memory);
		//Remove this to call the rest API to get the price
		
		/**MAP.put("E8Sv3",175.72);
		MAP.put("E8Asv4",166.94);
		MAP.put("E8Dsv4",191.08);
		MAP.put("E8DSv5",193.14);
		MAP.put("E8adsv5",176.47);**/
		
		for(int i=0; i<metaDataList.size(); i++) {
			//String armRegionName, String armSkuName, String priceType,String reservationTerm
			String armSkuName = ((VmData)metaDataList.get(i)).getVmType();
			double priceVal = priceService.getVmPrice(armRegionName,armSkuName , priceType, reservationTerm, usage);
			MAP.put(((VmData)metaDataList.get(i)).getVmName(),priceVal);
		}
	    
		if(!metaDataList.isEmpty()) {
			logger.info("DATABASE_RESPONSE {}",metaDataList.toString());
			CalculateBestAppResponse response=new CalculateBestAppResponse();

			if(metaDataList.size()>1) {
				//if more than 1 type of VM available get the lowest price one
				List<VmData> sameSapsVms= new ArrayList<VmData>();
				
				for (VmData metaData : metaDataList) {
					
					if(metaData.getSaps()==metaDataList.get(0).getSaps()) {
						sameSapsVms.add(metaData);
					}
				}
				
				double initialPrice=MAP.get(sameSapsVms.get(0).getVmName());
				int pointer=0;
				
				for (int i = 0; i < sameSapsVms.size(); i++) {
					if(MAP.containsKey(sameSapsVms.get(i).getVmName()) && MAP.get(sameSapsVms.get(i).getVmName())<initialPrice) {
						initialPrice=MAP.get(sameSapsVms.get(i).getVmName());
						pointer=i;
					}
				}
				
				response.setMemory(sameSapsVms.get(pointer).getMemory());
				response.setPrice(initialPrice);
				response.setSaps(sameSapsVms.get(pointer).getSaps());
				response.setVcpu(sameSapsVms.get(pointer).getVcpu());
				response.setVMName(sameSapsVms.get(pointer).getVmName());
				
			}else {
				//if there is only 1 type of VM
				response.setMemory(metaDataList.get(0).getMemory());
				response.setPrice(0.00);
				response.setSaps(metaDataList.get(0).getSaps());
				response.setVcpu(metaDataList.get(0).getVcpu());
				response.setVMName(metaDataList.get(0).getVmName());
			}
			
			
			return response;
			
		}else {
			
			// check the CPU utilization 
			logger.error("SERVICE_LAYER DATABSE LIST IS EMPTY");
			throw new Exception();
		}
		
	}

	public CalculateBestAppResponse returnHanaDBResponse(long memory,String armRegionName, String priceType, String reservationTerm, double usage) throws Exception {
		
		PriceService priceService = new PriceService(restTemplate);
	
		logger.info("SERVICE_LAYER {} {}",memory);
		List<VmData> metaDataList= vmDataRepository.findAllByMemoryAndIsHANACerifiedAndVmNameStartingWithOrderBySapsDesc(memory, true, "M");
		/**Remove this to call the rest API to get the price
		MAP.put("M64s",1974.89);
		MAP.put("M64Sv2",1919.67);
		MAP.put("M64Dsv2",1982.19);**/
		
		for(int i=0; i<metaDataList.size(); i++) {
			//String armRegionName, String armSkuName, String priceType,String reservationTerm
			String armSkuName = ((VmData)metaDataList.get(i)).getVmType();
			double priceVal = priceService.getVmPrice(armRegionName,armSkuName , priceType, reservationTerm, usage);
			MAP.put(((VmData)metaDataList.get(i)).getVmName(),priceVal);
		}
		
	    
	if(!metaDataList.isEmpty()) {
		logger.info("DATABASE_RESPONSE {}",metaDataList.toString());
		CalculateBestAppResponse response=new CalculateBestAppResponse();

		if(metaDataList.size()>1) {
			//if more than 1 type of VM available get the lowest price one
			//List<VmData> sameSapsVms= new ArrayList<VmData>();
			
			/**for (VmData metaData : metaDataList) {
				
				if(metaData.getSaps()==metaDataList.get(0).getSaps()) {
					sameSapsVms.add(metaData);
				}
			}**/
			
			double initialPrice=MAP.get(metaDataList.get(0).getVmName());
			int pointer=0;
			
			for (int i = 0; i < metaDataList.size(); i++) {
				if(MAP.containsKey(metaDataList.get(i).getVmName()) && MAP.get(metaDataList.get(i).getVmName())<initialPrice) {
					initialPrice=MAP.get(metaDataList.get(i).getVmName());
					pointer=i;
				}
			}
			
			response.setMemory(metaDataList.get(pointer).getMemory());
			response.setPrice(initialPrice);
			response.setSaps(metaDataList.get(pointer).getSaps());
			response.setVcpu(metaDataList.get(pointer).getVcpu());
			response.setVMName(metaDataList.get(pointer).getVmName());
			
		}else {
			//if there is only 1 type of VM
			response.setMemory(metaDataList.get(0).getMemory());
			response.setPrice(MAP.get(metaDataList.get(0).getVmName()));
			response.setSaps(metaDataList.get(0).getSaps());
			response.setVcpu(metaDataList.get(0).getVcpu());
			response.setVMName(metaDataList.get(0).getVmName());
		}
		
		
		return response;
		
	}else {
		logger.error("SERVICE_LAYER DATABSE LIST IS EMPTY");
		throw new Exception();
	}
	
}
	
	/**
	public CalculateBestVMResponse returnResponse(long vcpu, long memory) throws Exception {
		
		logger.info("SERVICE_LAYER {} {}",vcpu,memory);
		List<MetaData> metaDataList= metaDataRepository.findAllByVcpuAndMemoryOrderBySapsDesc(vcpu, memory);
		//Remove this to call the rest API to get the price
		MAP.put("E8Sv3",175.72);
		MAP.put("E8Asv4",166.94);
		MAP.put("E8Dsv4",191.08);
		MAP.put("E8DSv5",193.14);
		MAP.put("E8adsv5",176.47);
	    
		if(!metaDataList.isEmpty()) {
			logger.info("DATABASE_RESPONSE {}",metaDataList.toString());
			CalculateBestVMResponse response=new CalculateBestVMResponse();

			if(metaDataList.size()>1) {
				//if more than 1 type of VM available get the lowest price one
				List<MetaData> sameSapsVms= new ArrayList<MetaData>();
				
				for (MetaData metaData : metaDataList) {
					
					if(metaData.getSaps()==metaDataList.get(0).getSaps()) {
						sameSapsVms.add(metaData);
					}
				}
				
				double initialPrice=MAP.get(sameSapsVms.get(0).getVmName());
				int pointer=0;
				
				for (int i = 0; i < sameSapsVms.size(); i++) {
					if(MAP.containsKey(sameSapsVms.get(i).getVmName()) && MAP.get(sameSapsVms.get(i).getVmName())<initialPrice) {
						initialPrice=MAP.get(sameSapsVms.get(i).getVmName());
						pointer=i;
					}
				}
				
				response.setMemory(sameSapsVms.get(pointer).getMemory());
				response.setPrice(initialPrice);
				response.setSaps(sameSapsVms.get(pointer).getSaps());
				response.setVcpu(sameSapsVms.get(pointer).getVcpu());
				response.setVMName(sameSapsVms.get(pointer).getVmName());
				
			}else {
				//if there is only 1 type of VM
				response.setMemory(metaDataList.get(0).getMemory());
				response.setPrice(0.00);
				response.setSaps(metaDataList.get(0).getSaps());
				response.setVcpu(metaDataList.get(0).getVcpu());
				response.setVMName(metaDataList.get(0).getVmName());
			}
			
			
			return response;
			
		}else {
			logger.error("SERVICE_LAYER DATABSE LIST IS EMPTY");
			throw new Exception();
		}
		
	} **/
	
}
