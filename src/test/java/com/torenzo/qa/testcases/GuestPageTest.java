/*package com.torenzo.qa.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;

public class GuestPageTest extends TestBase {
	
	public GuestPageTest(){
		super();
	}
	
	
	LoginPage loginPage;
	OrderPage orderPage;
	GuestPage guestPage;
	TransactionOrderPageTest orderPageTest;
	@BeforeTest()
	public void setUp() throws MalformedURLException{
		initilization();
		loginPage = new LoginPage(driver);
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
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage();
		orderPageTest = new TransactionOrderPageTest();
		orderPageTest.orderTypewindowTitleTest(driver);
		orderPageTest.verifyCreatedOrderTest(driver);
		orderPageTest.AddGuestButtonTest(driver);
		guestPage.ClickOnAddGuest(driver);
	
	}
	@Test(priority = 13)
	public void GuestWindowTitleTest()
	{
		
		boolean flag= guestPage.GuestWindow();
		if(flag==true)
		{
			System.out.println("Guest Window is Displayed");
			
			
		}
		else
		{
			System.out.println("Guest Window is not Displayed");
			
		}
		guestPage.PassGuest();
	 	
	 	guestPage.verifyGuestAdded();
	
	
	}
	@Test(priority = 14)
	public void verifyGuestAddedTest()
	{
		guestPage.verifyGuestAdded();
	}
	@Test(priority = 15)
	public void navigateToGuest()
	{
		guestPage.Navigation();
		
	}

}
*/