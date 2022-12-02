package com.sap.calulator.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sap.calulator.responses.CalculateBestAppResponse;
import com.sap.calulator.responses.CalculateBestHanaStorageResponse;

@Service
public class ExcelReadService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private CalculatorService calculatorService;
	private PriceService priceService;
	
	@Autowired
	public ExcelReadService(CalculatorService calculatorService,PriceService priceService) {
		this.calculatorService = calculatorService;
		this.priceService = priceService;
	}
	
	
	public Map<String, Object> readExcel(MultipartFile file) {
		Map<String, Object> response = new HashMap<String, Object>();
		StringBuilder sb= new StringBuilder();
		String fileName = file.getOriginalFilename();
		if (fileName.substring(fileName.length() - 5, fileName.length()).equals(".xlsx")) {
			try (InputStream excelIs = file.getInputStream()) {
				try(Workbook wb = WorkbookFactory.create(excelIs)){
					Sheet sheet = wb.getSheetAt(0);
					Iterator<Row> rowIt = sheet.rowIterator();
					while (rowIt.hasNext()) {
						Row currentRow = rowIt.next();
						if(currentRow.getRowNum()>2 && currentRow.getRowNum() < 13) {
							String swComp = currentRow.getCell(0).getStringCellValue();
							String name = currentRow.getCell(1).getStringCellValue();
							String env = currentRow.getCell(2).getStringCellValue();
							String instanceType = currentRow.getCell(3).getStringCellValue();
							String sid = currentRow.getCell(4).getStringCellValue();
							String os = currentRow.getCell(5).getStringCellValue();
							String db = currentRow.getCell(6).getStringCellValue();
							double dbSize = currentRow.getCell(7).getNumericCellValue();
							double saps = currentRow.getCell(8).getNumericCellValue();
							double cores = currentRow.getCell(9).getNumericCellValue();
							
							
							double ram = currentRow.getCell(11).getNumericCellValue();
							double disk = currentRow.getCell(12).getNumericCellValue();
							String region = currentRow.getCell(18).getStringCellValue();
							String priceModel = currentRow.getCell(19).getStringCellValue();
							String duration = currentRow.getCell(20).getStringCellValue();
							double utilization = currentRow.getCell(21).getNumericCellValue();
							
							//double noOfVMs = currentRow.getCell(18).getNumericCellValue();
							//String vMName = currentRow.getCell(19).getStringCellValue();
							
							Iterator<Cell> cellItr = currentRow.iterator();
							String excelRaw = "";
							  while(cellItr.hasNext()){
								  
								  Cell cell = cellItr.next();  
								  
								  switch (cell.getCellType())               
								  { 
								  
								  case STRING:    //field that represents string cell type 
									  excelRaw = excelRaw + cell.getStringCellValue() + ",";								   
								  break;  
								  case NUMERIC:    //field that represents number cell type  
									  excelRaw = excelRaw + cell.getNumericCellValue() + ",";
								  break;
								  case BLANK:
									  excelRaw = excelRaw +  ",";
									  break;
								  case FORMULA:
									  excelRaw = excelRaw + cell.getNumericCellValue() + ",";
									  break;
								  default: 
									  
								  }  
								  						    
							  }
							  
							  excelRaw = excelRaw + "SLES-SAP,BYOL";


							
							
							
							/**logger.info("Env = {} | Instance Type = {} | DbSize = {} | Saps = {} | Cores = {} | Cpu = {} | Ram = {} ", 
									env, instanceType, dbSize, saps, cores, ram, ram); **/
							
							//long vcpu, long memory,String armRegionName, String priceType, String reservationTerm, double usage
							
							if(instanceType!=null && instanceType.equalsIgnoreCase("APP")) {
								CalculateBestAppResponse respApp = calculatorService.returnAppResponse((new Double(cores)).longValue(), (new Double(ram)).longValue(), region, priceModel, duration, utilization );
								if(respApp!=null) {
									//System.out.println("APP getPrice: " + "getVMName: " + respApp.getVMName() + " getVcpu: " + respApp.getVcpu() + " getMomery: " + respApp.getMemory() + " getSaps: " + respApp.getSaps() +" price:" + respApp.getPrice());
									excelRaw = excelRaw +","+ respApp.getVMName()+",1,"+ respApp.getVcpu()+","+ respApp.getMemory()+ ","+respApp.getSaps();
								}
								double appStorage = (priceService.getHanaStoragePrice(region, "P6"))*2;
								//System.out.println("App Storage: Type0:" + "P6" + " Count0:1 " + "Type1:" + "P6" +" Count1 Price: " + appStorage + ","+ respApp.getSaps() );
								excelRaw = excelRaw +",P6,1,P6,1,,,,,,,,,,,,"+ respApp.getPrice()+","+appStorage;
							}
							else if(instanceType!=null && instanceType.equalsIgnoreCase("DB")) {
								
								CalculateBestAppResponse respApp = calculatorService.returnHanaDBResponse((new Double(ram)).longValue(), region, priceModel, duration, utilization );
								if(respApp!=null) {
									//System.out.println("DB getPrice: " + "getVMName: " + respApp.getVMName() + " getVcpu: " + respApp.getVcpu() + " getMomery: " + respApp.getMemory() + " getSaps: " + respApp.getSaps() +" price:" + respApp.getPrice());
									excelRaw = excelRaw  +","+ respApp.getVMName()+",1,"+respApp.getVcpu()+","+ respApp.getMemory()+","+ respApp.getSaps();
								}
								CalculateBestHanaStorageResponse storageResponse = calculatorService.returnHanaStorageResponse(respApp.getVMName(), respApp.getMemory(), region);
								//System.out.println("DB Storage: " + storageResponse.toString());
								excelRaw = excelRaw +","+storageResponse.toRecord()+",,,"+respApp.getPrice()+","+storageResponse.toValue();
								
								
							}
							
							sb.append(excelRaw);
							sb.append(System.lineSeparator());
													
							
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.put("STATUS", "SUCCESS");
				response.put("MESSAGE", sb.toString());
				System.out.println("excel data : " + sb.toString());
			} catch (IOException e) {
				response.put("STATUS", "FAILED");
				response.put("MESSAGE", "Failed to process");
			}
		} else {
			response.put("STATUS", "FAILED");
			response.put("MESSAGE", "The file should be a .xlsx");
		}
		return response;
	}
}
