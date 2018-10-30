package com.torenzo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TransactionOrderPage extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/cancel_new_order_select")
	public WebElement cancelButtonFromTransaction;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/new_order_type_name")
	public WebElement optionOfOrders;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Bar-Tab']")
	public WebElement barTabButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Dine-In']")
	public WebElement dineInButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Take-Out']")
	public WebElement takeOutButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Drive-through']")
	public WebElement drivethroughButton;
		 
	
	
	public TransactionOrderPage(AndroidDriver<WebElement> driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	public void clickOnCancelButtonFromTransaction(){
		cancelButtonFromTransaction.click();
		
	}
	public boolean getTextCancelButtonFromTransaction(){
		
		return cancelButtonFromTransaction.isDisplayed();
		
	}
	
	public OrderPage clickOnbarTabButton() throws InterruptedException {
		Thread.sleep(2000);
		barTabButton.click();
		return new OrderPage(driver);
		
	}
	
	public TableStructurePage clickOndineInButton() throws InterruptedException, IOException{
		Thread.sleep(2000);
		dineInButton.click();
		return new TableStructurePage(driver);
	}
	
	public OrderPage clickOntakeOutButton() throws InterruptedException{
		Thread.sleep(2000);
		takeOutButton.click();
		return new OrderPage(driver);
	}
	public OrderPage clickOndrivethroughButton() throws InterruptedException{
		Thread.sleep(5000);
		drivethroughButton.click();
		return new OrderPage(driver);
	}
	

	
}
