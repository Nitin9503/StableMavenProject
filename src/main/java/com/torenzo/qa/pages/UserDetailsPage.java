package com.torenzo.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.TestBase;

public class UserDetailsPage extends TestBase {

	public UserDetailsPage(AndroidDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='User Details']")
	WebElement userDetailsText;
	
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/view_profile")
	public WebElement viewProfile;
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/till_mgmt")
	public WebElement tillMgnt;
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/reset_pwd")
	public WebElement resetPwd;
	
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/reset_pin")
	public WebElement resetPin;
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/break_out")
	public WebElement breakOut;
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/clock_out")
	public WebElement clockOut;
	
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/lock")
	public WebElement lock;
	
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/logout")
	public WebElement logout;

	
	// android.widget.ScrollView index = 1
	
	public String getTextUserDetails(){
		return userDetailsText.getText();
	}
	
	
	public void clickOnViewProfile(){
		viewProfile.click();
	}
	
	public void clickOnTillMgnte(){
		tillMgnt.click();
	}
	
	public void clickOnResetPwd(){
		resetPwd.click();
	}
	
	public void clickOnResetPin(){
		resetPin.click();
	}
	
	public void clickOnBreakOut(){
		breakOut.click();
	}
	
	public void clickOnClockOut(){
		clockOut.click();
	}
	
	public void clickOnLock(){
		lock.click();
	}
	
	public void clickOnLogout(){
		logout.click();
	}
	
	
	
}
