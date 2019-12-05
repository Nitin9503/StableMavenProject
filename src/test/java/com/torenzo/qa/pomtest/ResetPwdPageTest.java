package com.torenzo.qa.pomtest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.ResetPasswordPage;
import com.torenzo.qa.pages.ResetPinPage;
import com.torenzo.qa.pages.UserDetailsPage;
import com.torenzo.qa.util.TestUtil;

public class ResetPwdPageTest extends TestBase{

	
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public ResetPinPage resetPinPage;
	public ResetPasswordPage resetPasswordPage;
	public UserDetailsPage userDetailsPage;
	public TestUtil testUtil;
	
	public ResetPwdPageTest() throws IOException {
		super();
	
	}

	@BeforeClass
	public void launchApp() throws InterruptedException, IOException {

		initilization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		resetPinPage = new ResetPinPage(driver);
		resetPasswordPage =new ResetPasswordPage(driver);
		userDetailsPage = new UserDetailsPage(driver);
		testUtil = new TestUtil(driver);
		
	 }
	
	@Test(priority=0)
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
	
	@Test(priority=1)
	public void verifyResetPsdWindow() throws IOException, InterruptedException{
		resetPinPage.userDetailClick();
    	System.out.println("user detail text ---->"+testUtil.readDataFromExcellString(3, 1, 0));
    	assertEquals(resetPinPage.getUserDetailsTitle(), testUtil.readDataFromExcellString(3, 1, 0), "Required User Details Title not showing" );
    	resetPasswordPage.resetPwdOption.click();	
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	Assert.assertEquals(resetPinPage.getResetPinTorenzoTitle(), testUtil.readDataFromExcellString(3, 3, 0), "User is not navigated on Reset password Window after clicking on Reset Password Option.");
	}
	
	
	@Test(priority=2)
	public void ResetPwdWithInvalidPwd() throws IOException, InterruptedException{
		resetPasswordPage.enterCurrentPwd(testUtil.readDataFromExcellString(3, 16, 0));
		resetPasswordPage.enterNewPwd(testUtil.readDataFromExcellString(3, 17, 0));
		resetPasswordPage.enterNewConfPwd(testUtil.readDataFromExcellString(3, 18, 0));
		resetPasswordPage.resetPwdButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Switching to Alert        
	    Alert alert = driver.switchTo().alert();		
	    		
	    // Capturing alert message.    
	    String alertMessage= driver.switchTo().alert().getText().substring(6);		
	    		
	    // Displaying alert message		
	    System.out.println(alertMessage);	
	    Thread.sleep(1000);
	    		
	    // Accepting alert		
	    alert.accept();	
	     Assert.assertEquals(alertMessage, testUtil.readDataFromExcellString(3, 20, 0));
	     testUtil.writeStringValue(3, 19, 2);
	     
		
		
	}
	@Test(priority=3)
	public void ResetPwdWithValidPwd() throws IOException, InterruptedException{
		resetPasswordPage.currentPwd.clear();
		resetPasswordPage.enterCurrentPwd(testUtil.readDataFromExcellString(3, 21, 0));
		resetPasswordPage.newPwd.clear();
		resetPasswordPage.enterNewPwd(testUtil.readDataFromExcellString(3, 22, 0));
		resetPasswordPage.confirmPwd.clear();
		resetPasswordPage.enterNewConfPwd(testUtil.readDataFromExcellString(3, 23, 0));
		resetPasswordPage.resetPwdButton.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Switching to Alert        
	    Alert alert = driver.switchTo().alert();		
	    		
	    // Capturing alert message.    
	    String alertMessage= driver.switchTo().alert().getText().substring(6);		
	    		
	    // Displaying alert message		
	    System.out.println(alertMessage);	
	    Thread.sleep(1000);
	    		
	    // Accepting alert		
	    alert.accept();	
	    Assert.assertEquals(alertMessage, testUtil.readDataFromExcellString(3, 24, 0));
	    testUtil.writeStringValue(3, 24, 2);
		 
	}
	@Test(priority=4)
	public void ResetPwdAndLogin() throws IOException, InterruptedException{
		resetPasswordPage.clickOnBackButton();
		assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(3, 25, 0), "It is not navigated on Home page after clicking on back button" );
		testUtil.writeStringValue(3, 25, 2);
		resetPinPage.userDetailClick();
		testUtil.scrollTillText("Logout");	
		userDetailsPage.clickOnLogout();
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();			
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Logout");
		testUtil.writeStringValue(3, 26, 2);
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,3,0), testUtil.readDataFromExcellString(3, 23, 0));
		loginPage.clickOnSubmitLoginButton();
		String clockinText=loginPage.clockInButton.getText();
		System.out.println(clockinText);
		Assert.assertEquals("Clock-In", clockinText, "updated password not match");
		testUtil.writeStringValue(3, 27, 2);
		
	}
	
	
}
