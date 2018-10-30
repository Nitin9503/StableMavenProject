/*package com.torenzo.qa.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.AddItemToOrderPage;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;

public class AddItemToOrderTest extends TestBase{
	
	
	public AddItemToOrderTest(){
		super();
	}
	
	LoginPage loginPage;
	
	TransactionOrderPageTest orderPageTest;
	 GuestPageTest  guestPageTest;
	 AddItemToOrderPage addItemToOrderPage;
	@BeforeTest()
	public void setUp() throws MalformedURLException{
		initilization();
		loginPage = new LoginPage();
		 //loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 driver.findElement(By.xpath(prop.getProperty("Live-User"))).click();
		    driver.findElement(By.id(prop.getProperty("Submit"))).click();	
			driver.findElement(By.id(prop.getProperty("Clock-In"))).click();
			 driver.findElement(By.id("role_name")).click();
			 loginPage.Navigation();
	}
	
	
	@Test(priority = 12)
	public void ClickOnAddGuestButtonTest()
	{
		      guestPageTest = new GuestPageTest();
				 guestPageTest.ClickOnAddGuestButtonTest();
	
	}
	@Test(priority = 13)
	public void AdditemTOrderTest() throws InterruptedException
	{
		       addItemToOrderPage = new  AddItemToOrderPage();
				guestPageTest.GuestWindowTitleTest();
				guestPageTest.verifyGuestAddedTest();
				addItemToOrderPage.addItem();
		
		
	}
	
	

}
*/