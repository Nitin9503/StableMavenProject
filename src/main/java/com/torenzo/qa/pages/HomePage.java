package com.torenzo.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;

public class HomePage extends TestBase{
	
     

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Order']")
	public WebElement homePageTitle;
	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='All Items']")
	public WebElement allCategoryItemButton;

	@AndroidFindBy(id="com.torenzo.torenzocafe:id/grid_fill")
	public WebElement allItemFirstView;

	@AndroidFindBy(id="com.torenzo.torenzocafe:id/square_line")
	public WebElement allItemFirstViewInList;

	@AndroidFindBy(id="com.torenzo.torenzocafe:id/grid_outline")
	public WebElement categoryViseList;

	@AndroidFindBy(id="com.torenzo.torenzocafe:id/user_details")
	public WebElement userDetailsButton;

	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/order_total_upside")
	public WebElement orderTotalUpsideButton;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/printer")
	public WebElement printerButton;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/table_structure_img")
	public WebElement tableStructureButton;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/track_order")
	public WebElement trackOrder;
	
	@AndroidFindBy(xpath ="com.torenzo.torenzocafe:id/schedular")
	public WebElement schedularButton;
	
	@AndroidFindBy(xpath ="com.torenzo.torenzocafe:id/torenzo_meet_icon")
	public WebElement torenzoMeetIcon;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/order_list_layout")
	public WebElement orderListLayoutButton;
		
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/menu")
	public WebElement adminMenuButton;
	
	@AndroidFindBy(id ="new_order_create_btn_layout")
	public WebElement newOrderCreateBtn;
		
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/all")
	public WebElement allButtonFromHome;
	
	 public HomePage(AndroidDriver<AndroidElement> driver) throws IOException, InterruptedException{
		  this.driver = driver;
		   PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	   }

	 

	public String titleOfhomePage() throws InterruptedException{
		Thread.sleep(9050);
	
		return homePageTitle.getText();
	}
	
	public void clickAllCategoryItemButton() throws InterruptedException{
		Thread.sleep(9000);
		allCategoryItemButton.click();
	}
	
	public void clickUserDetailsButton(){
		userDetailsButton.click();
	}
	
	
	public void ClickOrderListLayoutButton(){
		orderListLayoutButton.click();
	}
	public String getTextFromOrderTotal(){
		return orderTotalUpsideButton.getText().substring(1);
	}
	
	public PaymentPage clickOnOrderTotalUpsideButton() throws InterruptedException, IOException{
		 orderTotalUpsideButton.click();
		 return new PaymentPage(driver);
	}
	
	public TransactionOrderPage clickNewOrderCreateBtn() throws InterruptedException, IOException{
		newOrderCreateBtn.click();
		return new TransactionOrderPage(driver);
		
	}
	
	public boolean validatetableStructureButton(){
		return tableStructureButton.isDisplayed();

		
	}
	public void  clickOnTableStructureButton(){
		
		tableStructureButton.click();
		
	}
}
