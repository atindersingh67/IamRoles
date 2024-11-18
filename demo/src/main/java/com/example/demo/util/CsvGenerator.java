package com.example.demo.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Resource;
import com.opencsv.CSVWriter;

@Component
public class CsvGenerator {

	public void genrateCsv(List<Resource> list, String filePath) throws IOException {
		try (CSVWriter writer = new CSVWriter(new FileWriter(filePath.toString()))) {
			writer.writeNext(new String[] {"Resource type", "Resource Name", "Resource ID", "Creation Date"});
			for (Resource line : list) {
				writer.writeNext(new String[] {line.getResourceType(), line.getResourceName(), line.getResourceId(), line.getCreationDate()});
			}
		}

	}

}
