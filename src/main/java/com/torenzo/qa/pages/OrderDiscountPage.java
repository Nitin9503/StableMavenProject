package com.torenzo.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.torenzo.qa.base.TestBase;

public class OrderDiscountPage extends TestBase {
	
	public OrderDiscountPage(AndroidDriver<AndroidElement> driver) throws InterruptedException, IOException{	
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/cancel_dialog")
	public WebElement cancelDiscount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Apply Discount']")
	public WebElement discountWindowTitle;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/done_guest")
	public WebElement doneDiscount;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/receipt_subtotal")
	public WebElement receiptTotalOnDicount;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/new_guest_text")
	public WebElement percentage;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/select_from_existing_text")
	public WebElement amount;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/edit_number_item")
	public WebElement getDiscount;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/cancel_digit")
	public WebElement cancelDigit;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/five_percentage")
	public WebElement fivePercentage;
	
	@AndroidFindBy(id="android.widget.Button")
	public List<WebElement> discountInAmount;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/add_guest_two")
	public WebElement addTwo;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/remove_discount")
	public WebElement removeDiscount;
	
	@AndroidFindBy(id="com.torenzo.torenzocafe:id/remove_discount_and_add_new")
	public WebElement removeAndAddNewDiscount;
	
	
	public String getTitleDicount(){
		return discountWindowTitle.getText();
	}
	
	public double getTotalOnDicount(){
		return Double.valueOf(receiptTotalOnDicount.getText().substring(20));
	}
	
	public void passAmount(String str){
		getDiscount.sendKeys(str);
	}
	
	
	
}
