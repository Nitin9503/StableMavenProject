package com.torenzo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import java.io.IOException;
import java.util.List;
public class GuestPage extends TestBase{

	
	public GuestPage(AndroidDriver<AndroidElement> driver) throws IOException {
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	 @AndroidFindBy(xpath ="//android.widget.TextView[@text='Edit Guest']")
		public WebElement titleOfGuestPage;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_two")
		public WebElement addTwoGuestClick;
	
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_three")
		public WebElement addThreeGuestClick;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_four")
		public WebElement addFourGuestClick;
	
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_one")
		public WebElement addOneGuestClick;
	

	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/cancel_add_guest")
		public WebElement cancelAddGuestClick;
	 

	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_done")
		public WebElement addGuestDoneClick;
	 
	 
	 @AndroidFindBy(xpath="//android.widget.TextView[@text='Party Size']")
		public WebElement titleOfPartySizeInTable;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/party_size_number_display")
		public WebElement partySizeNumberDisplay;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_guest_number_display")
		public WebElement addGuestNumberDisplay;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/done_employee_list")
		public WebElement doneEmployeeList;

	 
	 
	 public boolean verifytitleOfGuestWindow(){
		
		return titleOfGuestPage.isDisplayed();
		
	}
	
	
	 public boolean verifytitleOfPartySizeInTable(){
			
			return titleOfPartySizeInTable.isDisplayed();
			
		}
	
	 public void clickAddGuestOne(){
			
		 addOneGuestClick.click();
			
		}
	 public OrderPage clickOnDoneEmployeeList() throws InterruptedException, IOException{
			
		 doneEmployeeList.click();
		 return new OrderPage(driver);	
		}
	 
	 public void clickAddGuestTwo(){
			
		 addTwoGuestClick.click();
			
		}
	 public void clickAddGuestThree(){
			
		 addThreeGuestClick.click();
			
		}
	 public void clickAddGuestFour(){
			
		 addFourGuestClick.click();
			
		}
	 public OrderPage clickAddGuestDoneClick() throws InterruptedException, IOException{
			
		 addGuestDoneClick.click();
		 return new OrderPage(driver);
			
		}
	 
	 public String getTextGuestCountAddedFromGuestWindow(){
			
		 return addGuestNumberDisplay.getText();
			
		}
	 
	 
	 public String gteTextCountAddedFromPartyWindow(){
			
		 return partySizeNumberDisplay.getText();
			
		}
	
	
	
	/*public void PassGuest(){
		
		driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).click();
		String guest = driver.findElement(By.id("com.torenzo.torenzocafe:id/add_guest_two")).getText();
		System.out.println("guestCountFromWindow  = " +guestCountFromWindow );
		int str = Integer.parseInt(guest);
		guestCountFromWindow  = 1 + str;
	  	System.out.println("guestCountFromWindow = " +guestCountFromWindow);
	  	
	 	driver.findElement(By.id(obj.getProperty("AddGuestDone"))).click();
	}
    public void verifyGuestAdded(){
		
    	List<WebElement> guestCountFromOrder = driver.findElements(By.id("guest_name"));
    	System.out.println("guestCountFromOrder = " +guestCountFromOrder.size());
    	if(guestCountFromWindow  == guestCountFromOrder.size() )
    	{
    		System.out.println("Guest is added succfully");
    	}
    	else{
    		System.out.println("Guest is not added ");
    	}
    	
	}
    public AddItemToOrderPage Navigation()
    {
    
   	 return new AddItemToOrderPage();
    }*/
	
	
}
