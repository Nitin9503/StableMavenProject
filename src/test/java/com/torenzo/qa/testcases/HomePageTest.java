package com.torenzo.qa.testcases;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.util.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeTest
	public void loginApp() throws MalformedURLException
    {
        
    }
	@Test(groups = { "Car" }, priority = 1)
	public void clickOnCreateOrder() throws InterruptedException{
		homePage = new HomePage(driver);
		homePage.clickNewOrderCreateBtn();
		
		
		
		
	}
	

	
	
}







/*loginPage =new LoginPage(driver);	
homePage =new HomePage(driver);	
 loginPage.clickOnOpenExistStoreButton();
 boolean titleOfLoginWindow = loginPage.titleOfLoginPage();
	Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
	loginPage.clickOnSubmitLoginButton();
	boolean clockInButton = loginPage.validateClockInButton();
	Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
	loginPage.clickOnClockInButton();
 	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
	loginPage.clickOnroleNameButton();
	Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");
	homePage = loginPage.clickOnPermissionPupup();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Heelo pass1==");
	homePage.clickAllCategoryItemButton();
	System.out.println("Heelo pass2==");
	System.out.println("Heelo pass==."+homePage.titleOfhomePage());
	System.out.println("Heelo pass2==");
	Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (login not succefully)");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Heelo pass");*/