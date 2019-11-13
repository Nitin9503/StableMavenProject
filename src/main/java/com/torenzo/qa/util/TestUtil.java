package com.torenzo.qa.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.torenzo.qa.base.TestBase;


public class TestUtil extends TestBase {

	public TestUtil(AndroidDriver driver) throws IOException {
		super();
		this.driver=driver;
	}
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT_TIME = 50;
		
	public void scrollTillText(String text){
		
		  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
		
	}
	
	public void swapRightToLeft(WebElement src , WebElement dest){
		TouchAction action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(src)).withDuration(ofSeconds(4))).moveTo(element(dest)).release().perform();
	}
	
	public String decimalFormate(String str){
		DecimalFormat dcf = new DecimalFormat("#0.00");
		return dcf.format(str);
	}
	public void longPress(WebElement element1){
		
		TouchAction action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(element1)).withDuration(ofSeconds(2))).release().perform();
	
	}
	

	public  String readDataFromExcellString(int sheetName,
			int row_number, int colomn_number) throws IOException,
			InterruptedException {
		
		XSSFSheet sheet = workbook.getSheetAt(sheetName);
		System.out.println("===========>"+sheet.getRow(row_number).getCell(colomn_number).getStringCellValue());
		return sheet.getRow(row_number).getCell(colomn_number)
				.getStringCellValue();
	}

	public  void writeStringValue(int sheetName, int row_number,
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




