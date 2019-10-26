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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.AdminSettingPage;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TableStructurePage;
import com.torenzo.qa.pages.TableViewPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.util.ScrollMethod;
import com.torenzo.qa.util.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HomePageTest extends TestBase{
	
	public  HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;	
    public TestUtil testUtil;
	public HomePageTest() throws IOException{
		super();
	}
		
	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		 testUtil = new TestUtil();
	}

	@Test(priority=1)
	public void verfiyHomePageTest() throws IOException, InterruptedException{	
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 loginPage.validatelaunchLink();		 
		loginPage.clickOnOpenExistStoreButton();
		Thread.sleep(3000);
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,3,0), testUtil.readDataFromExcellString(0,4,0));		
		loginPage.clickOnSubmitLoginButton();
		loginPage.clickOnClockInButton();
    	loginPage.clickOnroleNameButton();
		Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");				
	    homePage = loginPage.clickOnPermissionPupup();				
	     homePage.titleOfhomePage();					
		System.out.println("Heelo pass==>"+homePage.titleOfhomePage());		
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found (login not succefully)");		
		testUtil.writeStringValue(1, 1, 2);
	}
	


	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		
		driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec("E:\\Appium1\\StableMavenProject\\src\\main\\java\\com\\TestData\\command.bat");
		
		Thread.sleep(6000);
	
	}
}

