package com.torenzo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminSettingPage extends TestBase {
	
	
	public AdminSettingPage(AndroidDriver<AndroidElement>driver) throws IOException {
	this.driver=driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/admin_settings")
	public WebElement adminSettings;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/printer_setting")
	public WebElement printerSetting;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/purchase_master")
	public WebElement purchaseMaster;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/scrap_master")
	public WebElement scrapMaster;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/edit_order")
	public WebElement editOrder;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/nonkot_order")
	public WebElement nonkotOrder;
	
	
	

	
	
	
	
	
	public boolean verifyAdminSettingPanel(){
		
		return adminSettings.isDisplayed();
		  
	}
	
	public TableViewPage clickOnadminSettings(){
		
	adminSettings.click();
	return new TableViewPage(driver) ;
	
		  
	}
	
     public void clickOnNonkotOrder(){
		
    	 nonkotOrder.click();
		  
	}


     public void clickOnEditOrder(){
		
    	 editOrder.click();
		  
	}
     
	public boolean verifyTableViewDisplay(){
	 	
		return driver.findElement(By.xpath("//android.widget.TextView[@text='TableView Display']")).isDisplayed();
		
	}

}
