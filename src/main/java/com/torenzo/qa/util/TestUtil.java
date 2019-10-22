package com.torenzo.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.torenzo.qa.base.TestBase;


public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT_TIME = 50;
	
	
	
	public static String readDataFromExcellString(int sheetName,
			int row_number, int colomn_number) throws IOException,
			InterruptedException {
		XSSFSheet sheet = workbook.getSheetAt(sheetName);
		// System.out.println("===========>"+sheet.getRow(row_number).getCell(colomn_number).getStringCellValue());
		return sheet.getRow(row_number).getCell(colomn_number)
				.getStringCellValue();
	}
	
	
	public static void writeStringValue(int sheetName, int row_number,
			int colomn_number) throws IOException {	
		if (OSname.equalsIgnoreCase("Win")) {
			 src = new File(".\\src\\main\\java\\com\\TestData\\TorenzoTestData.xlsx");			
		} else if (OSname.equalsIgnoreCase("Mac")) {
			 src = new File("./src/main/java/com/TestData/TorenzoTestData.xlsx");	
		}
		
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetName);
		sheet.getRow(row_number).createCell(colomn_number).setCellValue("PASS");
		
		if (OSname.equalsIgnoreCase("Win")) {
			 src = new File(".\\src\\main\\java\\com\\TestData\\TorenzoTestData.xlsx");
			
		} else if (OSname.equalsIgnoreCase("Mac")) {
			 src = new File("./src/main/java/com/TestData/TorenzoTestData.xlsx");	
				
		}
		FileOutputStream fos = new FileOutputStream(
				".\\src\\main\\java\\com\\TestData\\TorenzoTestData.xlsx");
		workbook.write(fos);
		fos.close();
		// System.out.println("Mobile number ===>"+String.valueOf(sheet.getRow(row_number).getCell(colomn_number).getNumericCellValue()));

		// return
		// String.valueOf(sheet.getRow(row_number).getCell(colomn_number).getNumericCellValue());
		
	}
	
	
	

}




