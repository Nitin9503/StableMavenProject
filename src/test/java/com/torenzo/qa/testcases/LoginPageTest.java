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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.util.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeTest
    public void setUp() throws MalformedURLException
    {
		initilization();
		loginPage = new LoginPage(driver);
		
    }
	
	@Test(priority = 0)
	public void loginApp() throws IOException, InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 loginPage.validatelaunchLink();		 
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
		loginPage.clickOnOpenExistStoreButton();
	}
		@Test(priority = 1)
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
		
		@Test(priority = 2)
		public void verifyPermissionPopup(){
		Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");
		
		homePage = loginPage.clickOnPermissionPupup();		

		}
	
	
		@AfterTest
	    public void tearDown() 
	    {
			driver.closeApp();
			
	    }
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	















	/*LoginPage loginPage=  new LoginPage();
	//HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeTest(alwaysRun=true)
	public void setUp() throws MalformedURLException{
		initilization();
		loginPage = new LoginPage();
		
	}	
	
	@Test(priority = 0)
	public void LoginPageTitleTest()
	{ 
		String title=loginPage.validateLoginPageTitle();
		
		  System.out.println("title==" +title);
		Assert.assertEquals(title, "Open Existing Restaurant/Store (Live Users)", "Login Page not Found");
		System.out.println("open");
		
	}
	@Test(priority = 1)
	public void TorenzologTest()
	{ 
	System.out.println("Hello2");
		boolean flag= loginPage.validateTorenzologo();
		 System.out.println("flag==" +flag);
		 Assert.assertTrue(flag);
		 System.out.println("Hello");
		
	}
	@Test(priority = 1)
	public void LoginTest()
	{ 
		
	    System.out.println("Hello2");
	  //loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    driver.findElement(By.xpath(prop.getProperty("Live-User"))).click();
	    driver.findElement(By.id(prop.getProperty("Submit"))).click();	
		driver.findElement(By.id(prop.getProperty("Clock-In"))).click();
		 driver.findElement(By.id("role_name")).click();
		 System.out.println("Hello");
		
	}
	
	@Test(priority = 2) 
	public void ClockInButtonTest()
	{
		
		 String buttonText=loginPage.clockinButton();
		  System.out.println("buttonText==" +buttonText);
		//  try{
		  Assert.assertEquals(buttonText, "Clock-In", "Clock-In button not appeard check connectivity or creadentials");
			System.out.println("clock button is displayed");
		
		  }catch(Exception e)
		  {
			  System.out.println("Provide proper creadentialas or check network connectivity"); 
		  }
		  
	}
	@Test(priority = 3)
	public void ClockInTypewindowTitleTest()
	{
		
		 String TitleText=loginPage.clockinTypeWindowTitle();
		  System.out.println("TitleText==" +TitleText);
		//  try{
		  Assert.assertEquals(TitleText, "Clock-In" , "Clock - IN type page is not displayed");
			System.out.println("Clock-In Title is displayed");
			 
		  }catch(Exception e)
		  {
			  System.out.println("Provide proper creadentialas or check network connectivity"); 
		  }
		  
	}

	@Test(priority = 4)
	public void permissionPopupTest()
	{
			String permissionpoputtitle = loginPage.permissionPopup();
			 System.out.println("permissionpoputtitle==" +permissionpoputtitle);
			Assert.assertEquals(permissionpoputtitle, "Allow Torenzo to access photos, media, and files on your device?", "permission popup not found");
		
	}
	@Test(priority = 5)
	public void navigateToHome()
	{
	loginPage.Navigation();
	System.out.println("Passed");
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.closeApp();
	}
	

}
*/