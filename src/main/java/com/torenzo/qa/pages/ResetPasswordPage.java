package com.torenzo.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.TestBase;

public class ResetPasswordPage extends TestBase{

	public ResetPasswordPage(AndroidDriver<AndroidElement>driver) throws IOException {
	this.driver=driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
		
	}

	@AndroidFindBy (id="com.torenzo.torenzocafe:id/txt_back")
	public WebElement BackButton;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Torenzo Cafe']")
	public WebElement resetPwdTitle;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/reset_pwd")
	public WebElement resetPwdOption;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/current_pwd")
	public WebElement currentPwd;
	
	@AndroidFindBy (id="com.torenzo.torenzocafe:id/new_pwd")
	public WebElement newPwd;
	
	@AndroidFindBy (id="com.torenzo.torenzocafe:id/confirm_pwd")
	public WebElement confirmPwd;
	
	@AndroidFindBy (id="com.torenzo.torenzocafe:id/reset_pwd")
	public WebElement resetPwdButton;
	
	/*@AndroidFindBy (id="com.torenzo.torenzocafe:id/confirm_pwd")
	public WebElement confirmPwd;*/
	
	public String getResetPwdWindowtitle(){
		return resetPwdTitle.getText();
	
	}
	public void enterCurrentPwd(String curPwd){
		currentPwd.sendKeys(curPwd);
		
	}
	public void enterNewPwd(String newPawd){
		newPwd.sendKeys(newPawd);
	}
	
	public void enterNewConfPwd(String confPwd){
		confirmPwd.sendKeys(confPwd);
	}
	
	public void clickOnResetPwdButton(){
		resetPwdButton.click();
	}
	public void clickOnBackButton(){
		BackButton.click();
	}
	
	
	
	
}
