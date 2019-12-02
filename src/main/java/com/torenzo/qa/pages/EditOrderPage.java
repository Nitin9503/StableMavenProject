package com.torenzo.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.torenzo.qa.base.TestBase;

public class EditOrderPage extends TestBase {
	String invoice= "";
	

	public EditOrderPage(AndroidDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver ), this);
	}

	@AndroidFindBy(id= "com.torenzo.torenzocafe:id/cancel_order_list")
	public WebElement cancelEditWindow;
	
	@AndroidFindBy(id= "com.torenzo.torenzocafe:id/done")
	public WebElement doneEditWindow;
	
	@AndroidFindBy(id= "com.torenzo.torenzocafe:id/search")
	public WebElement search;

	@AndroidFindBy(id= "com.torenzo.torenzocafe:id/textView")
	public WebElement textSearch;
	
	@AndroidFindBy(id= "com.torenzo.torenzocafe:id/date")
	List<WebElement> dates;
	
	@AndroidFindBy(id= "com.torenzo.torenzocafe:id/invoice_no")
	List<WebElement> invoiceNumbers;
	
	
	public String getTextEditWindow(){
		return search.getText();
	}
	
	public String getTextDate(){
		return textSearch.getText();
	}
	
	public String getTextCancel(){
		return cancelEditWindow.getText();
	}

	public String getTextFromInvoice(){
		
			for (WebElement invoiceNumber : invoiceNumbers){
				System.out.println("invoiceNumber==>" +invoiceNumber.getText());			
					invoiceNumber.click();			
					invoice =invoiceNumber.getText();
			}
			  return invoice;
		}
   


}
