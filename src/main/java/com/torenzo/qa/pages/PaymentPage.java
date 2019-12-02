package com.torenzo.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.Loginapp;
import com.torenzo.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage extends TestBase {

	public PaymentPage(AndroidDriver<AndroidElement> driver) throws InterruptedException, IOException {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/split_receipt")
	public WebElement splitReceiptClick;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='PayBill']")
	public WebElement payBillClick;

	@AndroidFindBy(id = "name")
	public List<WebElement> totalReceipt;

	@AndroidFindBy(id = "order_id")
	public WebElement orderNoFromReceipt;

	@AndroidFindBy(id = "invoice_no")
	public WebElement invoiceNoFromReceipt;

	@AndroidFindBy(id = "date")
	public WebElement dateFromReceipt;
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/total_value")
	public WebElement orderTotalOnReceipt;
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/home_layout")
	public WebElement homeButton;
	
	@AndroidFindBy(id = "com.torenzo.torenzocafe:id/discount_popUp")
	public WebElement discountpopUp;
	
	
	

	public String getTextDateFromReceipt() {

		return dateFromReceipt.getText();
	}
	
	public double orderTotalFromReceipt() {

		return Double.valueOf(orderTotalOnReceipt.getText().substring(1));
	}

	public String getTextInvoiceNoFromReceipt() {
		return invoiceNoFromReceipt.getText().substring(8);
	}

	public String getTextorderNoFromReceipt() {

		return orderNoFromReceipt.getText().substring(7);

	}

	public String verifyPaymentPagetitle() {

		return payBillClick.getText();

	}

	public PayingPaymentPage clickOnPayBill() throws InterruptedException, IOException {

		payBillClick.click();
		return new PayingPaymentPage(driver);

	}

	public SplitReceiptPage ClickOnSplitReceiptClick() throws IOException {

		splitReceiptClick.click();
		return new SplitReceiptPage(driver);

	}

	public int totolReceiptCount() {
		System.out.println("Total receipt generated ==" + totalReceipt.size());
	      for(WebElement element :totalReceipt){
	    	  element.click();
	      }
		return totalReceipt.size();

	}
	
	public void clickOnHomeButtonFromPaymentPage(){
		homeButton.click();
		
	}
	
	
	

}
