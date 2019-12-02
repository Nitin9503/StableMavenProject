package com.torenzo.qa.pomtest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TransactionOrderPage;
import com.torenzo.qa.pages.UserDetailsPage;
import com.torenzo.qa.util.TestUtil;

public class LogoutPageTest extends TestBase{

	public HomePage homePage;
	public LoginPage loginPage;	
	public TestUtil testUtil;
	public UserDetailsPage userDetailsPage;
	
	public LogoutPageTest() throws IOException {
		super();
		
	}
	
	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();
	
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		 userDetailsPage = new UserDetailsPage(driver);
		 testUtil = new TestUtil(driver);
	}
	
	@Test(priority=1)
	public void LoginIntoAppTest() throws IOException, InterruptedException{		 
		 loginPage.validatelaunchLink();		 
		loginPage.clickOnOpenExistStoreButton();
		Thread.sleep(3000);
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,3,0), testUtil.readDataFromExcellString(0,4,0));		
		loginPage.clickOnSubmitLoginButton();
		loginPage.clickOnClockInButton();
    	loginPage.clickOnroleNameButton();			
	    homePage = loginPage.clickOnPermissionPupup();				
			
	}
	
	@Test(priority=2)
	public void LogoutVerifyTest() throws IOException, InterruptedException{	
				
	    homePage.clickUserDetailsButton(); 
		Assert.assertEquals(userDetailsPage.getTextUserDetails(), testUtil.readDataFromExcellString(3,1,0), "User Details window is not found upon clicking on User Details");		
		testUtil.writeStringValue(3,1,2);
		testUtil.scrollTillText("Logout");
	    userDetailsPage.clickOnLogout();
	    boolean titleOfLoginWindow = loginPage.titleOfLoginPage();			
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Logout");
		testUtil.writeStringValue(0, 2, 2);
		loginPage.clickOnCancelButtonOnTitle();
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found , Cancel button not respond");	
	}
	
	@Test(priority=3)
	public void LoginVerifyTest() throws IOException, InterruptedException{		 	 
		loginPage.clickOnOpenExistStoreButton();
		Thread.sleep(3000);
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,3,0), testUtil.readDataFromExcellString(0,4,0));		
		loginPage.clickOnSubmitLoginButton();
		loginPage.clickOnClockInButton();
    	loginPage.clickOnroleNameButton();						
	    Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found after logout and login(login not succefully)");		
	
	
	}
	

	
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec(".\\src\\main\\java\\com\\TestData\\command.bat");		
		Thread.sleep(6000);
	
	}

}
