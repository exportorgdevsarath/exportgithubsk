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
			return;
		} catch (FileConversionException e) {
			System.out.print("Error code : "+e.getErrorCode());
			setResponseExceptionError(response, e);
			return;
		} catch (OutOfMemoryError outOfMemoryError) {
			//CloudLogger.logError("Error processing CSV file: errorcode " +outOfMemoryError.getMessage());
			response.appendHeader("X-Failure-Code", "1003");
			response.setStatusCode(429, "OutOfMemoryError processing CSV file: " + outOfMemoryError.getMessage());
			return;
		} catch (Exception e) {
			//CloudLogger.logError("Error processing CSV file: errorcode " +e.getMessage());
			response.appendHeader("X-Failure-Code", "500");
			response.setStatusCode(429, "Error processing CSV file: " + e.getMessage());
			return;
		}
	}
	
	private void setResponseExceptionError(com.google.cloud.functions.HttpResponse response, FileConversionException e) {
		System.out.print("setResponseExceptionError Error code : "+e.getErrorCode());
		switch (e.getErrorCode()) {
			case 429:
				System.out.print("setResponseExceptionError Error code : 429");
				response.appendHeader("X-Failure-Code", "429");
				response.setStatusCode(429, "The export reached the maximum number of rows in an excel sheet");
				return;
			case 1001:
				System.out.print("setResponseExceptionError Error code : 1001");
				response.appendHeader("X-Failure-Code", "1001");
				response.setStatusCode(503, "Export excel conversion failed with Interuption exception");
				return;
			case 1002:
				System.out.print("setResponseExceptionError Error code : 1002");
				response.appendHeader("X-Failure-Code", "1002");
				response.setStatusCode(429, "Export excel conversion failed with Excel write IO exception");
				return;
			default:
				System.out.print("setResponseExceptionError Error code : default");
				response.appendHeader("X-Failure-Code", "500");
				response.setStatusCode(429, "Cloud Function execution has failed");
				return;
		}
		//CloudLogger.logError("Error processing CSV file: errorcode " +e.getErrorCode());
		//CloudLogger.logError("Error processing CSV file: error msg " +e.getMessage());
		//System.out.print("setResponseExceptionError header :"+response.getHeaders().get("X-Failure-Code"));
	}
}
