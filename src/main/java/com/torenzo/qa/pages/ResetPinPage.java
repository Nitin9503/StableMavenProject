package com.torenzo.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.TestBase;

public class ResetPinPage extends TestBase{

	public ResetPinPage(AndroidDriver<AndroidElement> driver) throws IOException, InterruptedException{
		  this.driver = driver;
		   PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	   }
	/*@AndroidFindBy(xpath="//android.widget.TextView[@text='User Details']")
	WebElement userDetailsText;*/
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/user_details")
	public WebElement userDetailsButton;

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/lock")
	public WebElement lockOption;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/txt_back")
	public WebElement resetBack;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Reset Pin']")
	public WebElement ResetPin;
	
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='Order']")
	@AndroidFindBy (xpath ="//android.widget.TextView[@text='User Details']")
	public WebElement UserDetailsTitle;
	
	
	@AndroidFindBy (xpath ="//android.widget.TextView[@text='Torenzo Cafe']")
	public WebElement resetPinTorenzoTitle;
	
	@AndroidFindBy (id ="com.torenzo.torenzocafe:id/current_pin")
	public WebElement currentPin;
	
	@AndroidFindBy (id ="com.torenzo.torenzocafe:id/new_pin")
	public WebElement newpin;
	
	@AndroidFindBy (id ="com.torenzo.torenzocafe:id/confirm_pin")
	public WebElement confirmnewPin;
	
	@AndroidFindBy (id ="com.torenzo.torenzocafe:id/reset_pin")
	public WebElement resetButton;
	
	@AndroidFindBy (xpath ="//android.widget.TextView[@text()='This is required field.']") 
	public WebElement errorMessage;
	
	@AndroidFindBy (id ="com.torenzo.torenzocafe:id/req_2")//for first=1 sec=2, third=3
	public WebElement errorMessages;
	
	@AndroidFindBy (id ="android:id/message")
	public WebElement alertMessage;
	
	@AndroidFindBy (id ="com.torenzo.torenzocafe:id/add_guest_one") //1=one, 2=two, 3=three......
	public WebElement numbers;
	
	@AndroidFindBy (id ="android:id/button1")
	public WebElement okButton; 
	
	@AndroidFindBy (xpath ="//android.widget.TextView[@text()='Your Pin was successfully changed.']")
	public WebElement alertMessage1;
	
	
	public void userDetailClick(){
		userDetailsButton.click();
		
	}
	public void resetClickOption(){
		ResetPin.click();
	}
	
	public String getUserDetailsTitle(){
		return UserDetailsTitle.getText();
		
	}
	public String getResetPinTorenzoTitle(){
		return resetPinTorenzoTitle.getText().substring(0, 11);
		
	}
	public void backButtonClick(){
		resetBack.click();
		
	}
	
	public void enterCurrentPin(String CurrPin){
		currentPin.sendKeys(CurrPin);
	
	}
	
	public void enterNewPin(String NewPIn){
		newpin.sendKeys(NewPIn);
		
	}
	
	public void enterConfirmedNewPin(String ConfNewPIn){
		confirmnewPin.sendKeys(ConfNewPIn);
		
	}
	
	public String getErrormessage(){
		return errorMessage.getText();
		
	}
	
	public void clickOnRestButton(){
		resetButton.click();
	
	}
	
	
	
	}

	
	
	
	

