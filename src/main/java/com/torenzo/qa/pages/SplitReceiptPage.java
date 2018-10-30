package com.torenzo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SplitReceiptPage extends TestBase {
	
	
	
	public SplitReceiptPage(AndroidDriver<AndroidElement> driver) throws IOException{
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Single Receipt']")
	public WebElement singleReceiptClick;
	
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/split_per_guest_layout")
	public WebElement splitPerGuestClick;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/split_equally_for_all_layout")
	public WebElement splitEquallyForAllClick;

	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/split_evently")
	public WebElement splitEventlyClick;
	
	@AndroidFindBy(xpath ="//android.widget.LinearLayout[contains(@resource-id,'card_view') and @index='1']")
	public WebElement clickOnTwo;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='2']")
	public WebElement getTextoFTwo;
	
	@AndroidFindBy(id ="com.torenzo.torenzocafe:id/doneClick")
	public WebElement doneClick;
	
	
	
	 
	public String getTextoFTwo(){
		return getTextoFTwo.getText();	
	}
	
	public boolean verifySplitReceiptPage(){
		
		 return driver.findElement(By.xpath("//android.widget.TextView[@text='Split Receipt Options']")).isDisplayed();
	}
	
	public void clickOnSingleRecipt(){
		singleReceiptClick.click();	
	}
	
	public void clickOnsplitEquallyForAll(){
		splitEquallyForAllClick.click();	
	}
	
	
	public void spliteByTwo(){
		System.out.println("clickOnTwo" +clickOnTwo);
		clickOnTwo.click();	
	}
	
	public String getTextspliteByTwo(){
		return clickOnTwo.getText();
	}
	
	public void doneClickFromSplite(){
		doneClick.click();	
	}
	
     public void clickOnSplitPerGuestRecipt(){
    	 splitPerGuestClick.click();
	}
	
     public void clickOnsplitEventlyClick(){
    	 splitEventlyClick.click();
	}
     
     
}
