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

public class PayingPaymentPage extends TestBase{

	 public PayingPaymentPage(AndroidDriver<AndroidElement> driver) throws InterruptedException, IOException{
		  this.driver = driver;
		   PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	   }

	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/add_payment")
		public WebElement addPaymentClick;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/edit_number_item")
		public WebElement EditTotalAmt;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/cash")
		public WebElement cashClick;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/card")
		public WebElement cardClick;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/done_guest")
		public WebElement doneClcik;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/cancel_dialog")
		public WebElement cancelClickFromPayment;
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/nckot")
		public WebElement nckotClcick;
	 
	 
	 @AndroidFindBy(id ="com.torenzo.torenzocafe:id/payment_value")
		public WebElement paymentValue;
	
		@AndroidFindBy(xpath ="//android.widget.TextView[@text='Payment']")
		public WebElement paymentWindowTitle;
	 
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/print_receipt_and_close")
		public WebElement printReceiptandcloseButton;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/close_table_without_receipt")
		public WebElement closeTableWithoutReceiptButton;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/continue_without_closing_table")
		public WebElement continueWithoutClosingtableButton;
		
		@AndroidFindBy(id ="com.torenzo.torenzocafe:id/cancel")
		public WebElement cancelFromCloseTableButton;
		
		
		public void continueWithoutClosingtableButton(){
			continueWithoutClosingtableButton.click();
		}
		
		public void closeTableWithoutReceiptButton(){
			closeTableWithoutReceiptButton.click();
		}
		
		public boolean titleOfPaymentWindow(){
			
	       return paymentWindowTitle.isDisplayed();
		}
	     
		public void clickOnDoneFromPaymentWindow(){
			doneClcik.click();
		}
	
		public String getTextEditTotalAmt(){
			return EditTotalAmt.getText();
		}
		
		public String getTextpaymentValue() throws InterruptedException{
			Thread.sleep(2000);
			return paymentValue.getText().substring(1);
		}
		
		public void ClickOnaddPayment(){
			addPaymentClick.click();
		}
		
}
