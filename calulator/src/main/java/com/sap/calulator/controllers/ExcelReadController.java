package com.sap.calulator.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sap.calulator.services.ExcelReadService;


@RestController
public class ExcelReadController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ExcelReadService excelReadService;

	@PostMapping("/read/excel")
	public Map<String, Object> handlePost(@RequestParam(name = "file") MultipartFile file) {
		return excelReadService.readExcel(file);
	}
}
