package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Constants;
import com.example.demo.model.Resource;
import com.example.demo.service.CloudService;
import com.example.demo.service.CloudServiceFactory;
import com.example.demo.util.CommonUtil;
import com.example.demo.util.CsvGenerator;

@RestController
@RequestMapping("/api/v1/resource")
public class CsvController {

	@Autowired
	private CloudServiceFactory cloudServiceFactory;

	@Autowired
	private CsvGenerator csvGenerator;

	public ResponseEntity<String> getResources(@RequestParam String provider) throws Exception {
		CloudService cloudService = cloudServiceFactory.getService(provider);

		List<Resource> list = cloudService.getResource();

		String filePath = CommonUtil.getCsvFilePath(Constants.CSV_FILE_NAME);
		csvGenerator.genrateCsv(list, filePath);
		return ResponseEntity.ok("CSV file generated at : " + filePath);

	}

}
