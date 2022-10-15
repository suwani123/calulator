package com.sap.calulator.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelReadService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public Map<String, Object> readExcel(MultipartFile file) {
		Map<String, Object> response = new HashMap<String, Object>();
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
							double cpu = currentRow.getCell(10).getNumericCellValue();
							double ram = currentRow.getCell(10).getNumericCellValue();
							logger.info("Env = {} | Instance Type = {} | DbSize = {} | Saps = {} | Cores = {} | Cpu = {} | Ram = {} ", 
									env, instanceType, dbSize, saps, cores, cpu, ram);
							
							
						}
					}
				}
				response.put("STATUS", "SUCCESS");
				response.put("MESSAGE", "Excel read success");
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
