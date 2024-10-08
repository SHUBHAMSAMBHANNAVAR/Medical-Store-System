package com.medicalApp_pages;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class Medical_readData {
	static Workbook WB;
	static Sheet sheet;

	public static Object[][] ReadData(String sheetName) throws IOException, InvalidFormatException {
		// Open the Excel file
		try (FileInputStream file = new FileInputStream("./test-data/MedicalStore_InputValues.xls")) {

			Workbook workbook = WorkbookFactory.create(file);

			// Get the specified sheet
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				throw new IllegalArgumentException("Sheet not found: " + sheetName);
			}

			// Determine the number of rows and columns
			int numRows = sheet.getLastRowNum() + 1; // Add 1 for zero-based indexing
			int numCols = sheet.getRow(0).getLastCellNum();

			// Create a two-dimensional array to store the data
			Object[][] data = new Object[numRows][numCols];

			// Create a DataFormatter for efficient cell value retrieval
			DataFormatter formatter = new DataFormatter();

			// Iterate through rows and columns, handling potential null cells
			for (int i = 1; i < numRows; i++) {
				Row row = sheet.getRow(i);
				if (row == null) {
					// Handle empty rows by filling with nulls
					for (int j = 0; j < numCols; j++) {
						data[i][j] = null;
					}
					continue;
				}

				for (int j = 0; j < numCols; j++) {
					Cell cell = row.getCell(j);
					if (cell != null) {
						data[i][j] = formatter.formatCellValue(cell);
					} else {
						data[i][j] = null; // Set null for missing cells
					}
				}
			}
			return data;
		}
	}
}

