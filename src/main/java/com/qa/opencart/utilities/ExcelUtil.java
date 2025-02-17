package com.qa.opencart.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static final String TEST_DATA_FILE_PATH = "./src/test/resources/testdata/OpenCart_TestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getData(String sheetName) {

		Object[][] data = null;
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_FILE_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName.trim());
			System.out.println(sheet);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}

}
