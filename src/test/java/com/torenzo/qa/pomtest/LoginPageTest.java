package com.torenzo.qa.pomtest;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

public class LoginPageTest extends TestBase{
	
	public TransactionOrderPage transactionOrderPage;
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public GuestPage guestPage;
	public PaymentPage paymentPage;
	public SplitReceiptPage splitReceiptPage;
	public PayingPaymentPage payingPaymentPage;
	public TableStructurePage tableStructurePage;
	public ScrollMethod scrollMethod;
	public AdminSettingPage adminSettingPage;
	public TableViewPage tableViewPage;
	 public TestUtil testUtil;

	public LoginPageTest() throws IOException {
		super();
		
	}
	
	
	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{
		
		initilization();
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		paymentPage = new PaymentPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		paymentPage = new PaymentPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver);
		splitReceiptPage = new SplitReceiptPage(driver);
		payingPaymentPage = new PayingPaymentPage(driver);
		tableStructurePage = new TableStructurePage(driver);
		scrollMethod = new ScrollMethod();
		adminSettingPage = new AdminSettingPage(driver);
		tableViewPage = new TableViewPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver);
		 testUtil = new TestUtil(driver);
	}
	@Test(priority=0)
		public void VerifyDemoUrlAndCancelClick() throws InterruptedException, IOException{
		 loginPage.validatelaunchLink();		 
			Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
			loginPage.clickOnOpenExistStoreButton();
			boolean titleOfLoginWindow = loginPage.titleOfLoginPage();			
			Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
			testUtil.writeStringValue(0, 2, 2);
			System.out.println( testUtil.readDataFromExcellString(0,7,1) +"-"+ testUtil.readDataFromExcellString(0,8,1) );
			loginPage.clickOnCancelButtonOnTitle();
			Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found , Cancel button not respond");		
	}
	
	@Test(priority=1)
	public void loginVerifyTestInvalidData1() throws InterruptedException, IOException{
		
		loginPage.clickOnOpenExistStoreButton();
		System.out.println( testUtil.readDataFromExcellString(0,7,1) +"-"+ testUtil.readDataFromExcellString(0,8,1) );
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,7,0), testUtil.readDataFromExcellString(0,8,0));
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();	
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
		loginPage.clickOnSubmitLoginButton();
		Assert.assertEquals(testUtil.readDataFromExcellString(0,9,0), loginPage.verifyAlertTitle(), "Validation popup is not displayed upon entering invalid creadentials");
		testUtil.writeStringValue(0, 9, 2);
		loginPage.clickOnOK();
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on OK from alert popup");
		testUtil.writeStringValue(0, 10, 2);
		
	}
	
	@Test(priority=2)
	public void loginVerifyTestInvalidData2() throws InterruptedException, IOException{
		
		System.out.println( testUtil.readDataFromExcellString(0,11,1) +"-"+ testUtil.readDataFromExcellString(0,12,1) );
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,11,0), "");
	    loginPage.clickOnSubmitLoginButton();
	    Assert.assertEquals(testUtil.readDataFromExcellString(0,9,0), loginPage.verifyAlertTitle(), "Validation popup is not displayed upon entering invalid creadentials");
	    testUtil.writeStringValue(0, 9, 2);
     	loginPage.clickOnOK();
		
	}
	
	@Test(priority=3)
	public void loginVerifyTestInvalidData3() throws InterruptedException, IOException{
		
		System.out.println( testUtil.readDataFromExcellString(0,13,1) +"-"+ testUtil.readDataFromExcellString(0,14,1) );
		loginPage.passCreadentilas("" , "");
	    loginPage.clickOnSubmitLoginButton();
	    System.out.println("No validation for after keeping both field as blank");
	}

	@Test(priority=4)
	public void loginVerifyTestInvalidData4() throws InterruptedException, IOException{
		System.out.println( testUtil.readDataFromExcellString(0,15,0) +"-"+ testUtil.readDataFromExcellString(0,16,0) );
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,15,0), testUtil.readDataFromExcellString(0,16,0));
	    loginPage.clickOnSubmitLoginButton();
	    Assert.assertEquals(testUtil.readDataFromExcellString(0,9,0), loginPage.verifyAlertTitle(), "Validation popup is not displayed upon entering invalid creadentials");
	    testUtil.writeStringValue(0, 9, 2);
     	loginPage.clickOnOK();
	}
	
	
	@Test(priority=5)
	public void loginVerifyTest() throws InterruptedException, IOException{
					
		loginPage.passCreadentilas(testUtil.readDataFromExcellString(0,3,0), testUtil.readDataFromExcellString(0,4,0));
		testUtil.writeStringValue(0, 3, 2);
		testUtil.writeStringValue(0, 4, 2);		
		loginPage.clickOnSubmitLoginButton();	
		testUtil.writeStringValue(0, 5, 2);
		boolean clockInButton = loginPage.validateClockInButton();	
		Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
		loginPage.clickOnClockInButton();		
        Assert.assertTrue(loginPage.validateTitleClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
    	testUtil.writeStringValue(0, 6, 2);
    	//loginPage.clickOnroleNameButton();
   
		
	}

    @Test(priority=6)
	public void cancelVerifyTest() throws IOException{
		loginPage.clickOnCancelButton();
		boolean loginTitle = loginPage.titleOfLoginPage();
		Assert.assertTrue(loginTitle, "login title not display while clicking upon cancel button");
		testUtil.writeStringValue(0, 17, 2);
    	loginPage.clickOnClockInButton();
		loginPage.clickOnroleNameButton();
		
		
	}
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		
		driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec(".\\src\\main\\java\\com\\TestData\\command.bat");		
		Thread.sleep(6000);
		
	}


}
