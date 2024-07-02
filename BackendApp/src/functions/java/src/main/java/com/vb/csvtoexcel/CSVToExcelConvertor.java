package com.vb.csvtoexcel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.context.annotation.Bean;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVToExcelConvertor {
	
	private static final int MAX_ROWS_PER_SHEET = 1048576; // Excel's maximum row limit
	private static final int BATCH_SIZE = 100000; // Process 10,000 records per batch
	private static final String SHEET_1 = "Sheet1";
	
	@Bean
	public CloudStorageService cloudStorageService() {
		return new CloudStorageService();
	}
	
	public void convertCSVToExcel(String bucketName, String csvFileName, String excelFileName)
			throws IOException, CsvValidationException, FileConversionException, Exception {
		CloudStorageService cloudStorageService = cloudStorageService();
		try (InputStream csvInputStream = cloudStorageService.readCsvFile(bucketName, csvFileName);
				CSVReader csvReader = new CSVReader(new InputStreamReader(csvInputStream));
				Workbook workbook = new SXSSFWorkbook()) {
			ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
			List<Future<List<String[]>>> futures = new ArrayList<>();
			String[] nextLine;
			List<String[]> batch = new ArrayList<>();
			while ((nextLine = csvReader.readNext()) != null) {
				batch.add(nextLine);
				if (batch.size() == BATCH_SIZE) {
					List<String[]> batchCopy = new ArrayList<>(batch);
					Future<List<String[]>> future = executorService.submit(() -> batchCopy);
					futures.add(future);
					batch.clear();
				}
			}
			// Process remaining rows
			if (!batch.isEmpty()) {
				List<String[]> batchCopy = new ArrayList<>(batch);
				Future<List<String[]>> future = executorService.submit(() -> batchCopy);
				futures.add(future);
			}
			Sheet sheet = workbook.createSheet(SHEET_1);
			int rowNum = 0;
			for (Future<List<String[]>> future : futures) {
				try {
					List<String[]> rows = future.get();
					for (String[] rowData : rows) {
						if (rowNum == MAX_ROWS_PER_SHEET) {
							CloudLogger.logError("Max row limit reached ");
							throw new FileConversionException(429, "MAXLIMIT_EXCEED_EXCEPTION");
						}
						Row row = sheet.createRow(rowNum++);
						for (int colNum = 0; colNum < rowData.length; colNum++) {
							Cell cell = row.createCell(colNum);
							cell.setCellValue(rowData[colNum]);
						}
					}
				} catch (InterruptedException | ExecutionException e) {
					throw new FileConversionException(1001);
                } catch (FileConversionException e) {
					throw e;
				} catch (Exception e) {
					throw new FileConversionException(500);
				}
			}
			executorService.shutdown();
			try (OutputStream outputStream = cloudStorageService.getExcelOutputStream(bucketName, excelFileName)) {
				workbook.write(outputStream);
			} catch (IOException e) {
				throw new FileConversionException(1002);
			}
			workbook.close();
		}
	}
}
