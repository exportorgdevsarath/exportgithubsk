package com.vb.csvtoexcel;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.cloud.functions.HttpFunction;

@Component
public class CSVToExcelFunction implements HttpFunction {
	@Bean
	public CSVToExcelConvertor csvToExcelConverter() {
		return new CSVToExcelConvertor();
	}
	@Bean
	public CloudStorageService cloudStorageService() {
		return new CloudStorageService();
	}
	
	@Override
	public void service(com.google.cloud.functions.HttpRequest request,
			com.google.cloud.functions.HttpResponse response) throws Exception {
		String csvFileName = request.getFirstQueryParameter("csvFileName").orElse("");
		String bucketName = request.getFirstQueryParameter("bucketName").orElse("");
		String excelFileName = request.getFirstQueryParameter("excelFileName").orElse("");
		
		if (StringUtils.isEmpty(csvFileName) || StringUtils.isEmpty(bucketName) || StringUtils.isEmpty(excelFileName)) {
			throw new Exception("Input query params 'csvFileName' or 'csvFileName' or 'bucketName' are missing");
		}
		CSVToExcelConvertor csvToExcelConverter = csvToExcelConverter();
		try {
			csvToExcelConverter.convertCSVToExcel(bucketName, csvFileName, excelFileName);
			response.setStatusCode(200, "CSV file successfully converted to Excel and written to Cloud Storage.");
		} catch (FileConversionException e) {
			System.out.println("Error processing CSV file: errorcode " +e.getErrorCode());
			System.out.println("Error processing CSV file: error msg " +e.getMessage());
			if (429 == e.getErrorCode()) {
				response.setStatusCode(429, "Maximum Limit is reached");
			} else if (1001 == e.getErrorCode()) {
				response.setStatusCode(1001, "Maximum Limit is reached");
			}  else if (1002 == e.getErrorCode()) {
				response.setStatusCode(1002, "Maximum Limit is reached");
			}  else {
				response.setStatusCode(500, "Maximum Limit is reached");
			}
		} catch (OutOfMemoryError outOfMemoryError) {
			response.setStatusCode(1003, "OutOfMemoryError processing CSV file: " + outOfMemoryError.getMessage());
		} catch (Exception e) {
			response.setStatusCode(500, "Error processing CSV file: " + e.getMessage());
		}
	}
}