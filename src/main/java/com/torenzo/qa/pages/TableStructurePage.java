package com.torenzo.qa.pages;

import static com.torenzo.qa.util.StaticVariable.addedGuestToOrder;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TableStructurePage extends TestBase {

		public TableStructurePage(AndroidDriver<AndroidElement> driver) throws IOException {
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
			
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/cancel_table_structure_btn")
		public WebElement cancelTableStructureBtn;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/table_guest_list")
		public WebElement reservationButtonClick;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/check_reservation_btn")
		public WebElement checkReservationBtn;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/floor_select_btn")
		public WebElement floorSelectBtn;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/refresh_tables")
		public WebElement refreshTablesButton;
			
		@AndroidFindBy(xpath ="//android.widget.TextView[@text='Table options']")
		public WebElement tableOptionText;
		
		
 
		public boolean titleOfTableStructure() throws InterruptedException{
			Thread.sleep(2000);
			return cancelTableStructureBtn.isDisplayed();
			
		}
		
		public void checkReservationBtn(){
			checkReservationBtn.click();
			
		}
	    
		public void floorSelectBtn(){
			floorSelectBtn.click();
			
		}
		
		public void refreshTablesButton(){
			refreshTablesButton.click();
			
		}
		
		public boolean validateTableOptionText(){
			return tableOptionText.isDisplayed();
			
		}
		
		public void checkForEmptyTable(){
		    System.out.println("Searching for empty Table");
		   for (int t=21; t<=40;t++)
	       {
	    	   System.out.println("value of t is" +t);
	           System.out.println("increment ");   	 
		       driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();      
		        try{
			           if(validateTableOptionText())
			                 {
			        	            System.out.println(" Busy "); 
        	            
			        	            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			                   //   	driver.pressKeyCode(AndroidKeyCode.BACK);
				
			                  }
		            }catch(Exception e)
		
	                  	{
		            	
		                 System.out.println("table is free and adding guest");
		                 break;	

	                  	}
		        t++;
		             }
		   
	   }
		
	   
		/*  Boolean partySizeWindowTitle = guestPage.verifytitleOfPartySizeInTable();
  	  Assert.assertTrue(partySizeWindowTitle, "Party Size window not found in table structure");
       	addedGuestToOrder = driver.findElement(By.id("add_guest_three")).getText();
       	driver.findElement(By.id("add_guest_three")).click();
           driver.findElement(By.id(obj.getProperty("DoneEmployeeList"))).click();
          break;	*/
	
	
}
