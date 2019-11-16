package com.torenzo.qa.pages;

import static com.torenzo.qa.util.StaticVariable.addedGuestToOrder;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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
		
		@AndroidFindBy(xpath ="//android.widget.TextView[@text='Party Size']")
		public WebElement partSize;
	
		@AndroidFindBy(className ="android.widget.Button")
		public List<WebElement> tables;
		  
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/waiter_list_recycler_view")
		public List<WebElement> waiterList;
		
		@AndroidFindBy(className ="android.widget.Button")
		public List<WebElement> enterGuest;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/party_size_number_display")
		public WebElement getGuest;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/phone_number_delete")
		public WebElement deleteGuest;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/done_employee_list")
		public WebElement doneGuest;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/cancel_guestby_phone_number")
		public WebElement cancelGuest;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/transfer")
		public WebElement transfer;
		
		@AndroidFindBy(xpath ="//android.widget.TextView[@text='Table options']")
		public WebElement tableOptions;
		
		 @AndroidFindBy(id ="android:id/alertTitle")
			public WebElement guestAlert; 
		 
		 @AndroidFindBy(id ="android:id/button1")
			public WebElement alertOk; 
		 
		 @AndroidFindBy(id ="android:id/message")
			public WebElement alertGuest;  
		 
		 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_two")
			public WebElement addTwoGuest; 		 
		
		public String titleOfTableStructure() throws InterruptedException{
			return cancelTableStructureBtn.getText();			
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
		
		public boolean titleOfGuestWindow(){		
			return partSize.isDisplayed();
		}
		
		public String getGuest(){		
			return getGuest.getText();
		}
		
		public String titleOnBusy(){		
			return tableOptions.getText();
		}
		
		/*public void passGuest(int i){
			for(WebElement guest : enterGuest){
				
				guest.click();
			}
			 //enterGuest.get(i).click();;
		}*/
		
		
		
		public String getTextAlertTitle(){
			return guestAlert.getText();
		}
		
		public String getTextMessage(){
			System.out.println(alertGuest.getText());
			return alertGuest.getText();
		}
	
		
		public void searchFromEmptyTable(){
			System.out.println("tables.size();==" +tables.size());			
			for(WebElement table : tables){
				System.out.println("table.getText()==" +table.getText());
				table.click();			
			try{
					if(titleOfGuestWindow()){
						 System.out.println("table is free and adding guest");
		                 break;	
												
					}
			}catch(Exception e){
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				System.out.println("Table is busy1");	
				
			}				
				   System.out.println("helllooo");  
				}							
			}			
		}
		
	
	/*
		public void checkForEmptyTable(){
		    System.out.println("Searching for empty Table");
		   for (int t=1; t<=40;t++)
		   {
			   System.out.println("value of t is" +t);
		       System.out.println("increment ");   	 
		       driver.findElement(By.xpath("//android.widget.Button[@index="+t+"]")).click();      
		     
		        try{
			           if(validateTableOptionText())
			                 {
			        	            System.out.println(" Busy "); 
			        	            driver.pressKey(new KeyEvent(AndroidKey.BACK));
									System.out.println("Table is busy1");	
				
			                  }
		            }catch(Exception e)
		
		              	{
		            	
		                 System.out.println("table is free and adding guest");
		                 break;	
		
		              	}
		        t++;
		             }
		   
		}*/



		/*  Boolean partySizeWindowTitle = guestPage.verifytitleOfPartySizeInTable();
  	  Assert.assertTrue(partySizeWindowTitle, "Party Size window not found in table structure");
       	addedGuestToOrder = driver.findElement(By.id("add_guest_three")).getText();
       	driver.findElement(By.id("add_guest_three")).click();
           driver.findElement(By.id(obj.getProperty("DoneEmployeeList"))).click();
          break;	*/
	
	

