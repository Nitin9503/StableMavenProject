package com.torenzo.qa.pomtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TransactionOrderPageTest extends TestBase{

	/*TransactionOrderPage transactionOrderPage;
	HomePage homePage;
	LoginPage loginPage;
	OrderPage orderPage;*/
	public TransactionOrderPageTest() throws IOException{
		super();
		
	}
/*	@BeforeTest
    public void setUp() throws InterruptedException, IOException
    {
		initilization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
		
    }*/
	
	@Test(priority = 11)
	public void loginApp() throws IOException, InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 loginPage.validatelaunchLink();		 
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
		loginPage.clickOnOpenExistStoreButton();
	}
		@Test(priority = 12)
        public void verifyTitleOfLogin(){
	  
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
		loginPage.clickOnSubmitLoginButton();
		boolean clockInButton = loginPage.validateClockInButton();
		Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
		loginPage.clickOnClockInButton();
     	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
		loginPage.clickOnroleNameButton();
		
       }
		
		@Test(priority = 13)
		public void verifyPermissionPopup() throws IOException, InterruptedException{
		Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");
		homePage = loginPage.clickOnPermissionPupup();		
		}
		
		@Test(priority = 14)
		public void clickOnCreateNewOrder() throws InterruptedException, IOException{
			homePage.titleOfhomePage();
			
			System.out.println("Heelo pass==>"+homePage.titleOfhomePage());		
			Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (login not succefully)");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			transactionOrderPage = homePage.clickNewOrderCreateBtn();
			try{
			if(transactionOrderPage.getTextCancelButtonFromTransaction()){			
				transactionOrderPage.clickOnbarTabButton();		
			}
			}catch(Exception e){
				System.out.println("Normal order is created");
			}
			System.out.println("Normal order is created = " +orderPage.getTextorderNumberFromOrderPage());		
			Assert.assertTrue(orderPage.getTextFromFirstGuest(), "Order is not created as geust isn not added");
		}
		

	
	
		
    }