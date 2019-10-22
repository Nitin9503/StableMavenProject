package com.torenzo.qa.testcases;

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
	}
	
	
/*	@Test(priority=1)
	public void loginVerifyTestInvalidData1() throws InterruptedException, IOException{
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 loginPage.validatelaunchLink();		 
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
		loginPage.clickOnOpenExistStoreButton();			
		loginPage.passCreadentilas();
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();	
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
		loginPage.clickOnSubmitLoginButton();		
		boolean clockInButton = loginPage.validateClockInButton();	
		Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
		loginPage.clickOnClockInButton();		
    	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
		loginPage.clickOnroleNameButton();
		
	}
	
	@Test(priority=1)
	public void loginVerifyTestInvalidData2() throws InterruptedException, IOException{
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 loginPage.validatelaunchLink();		 
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
		loginPage.clickOnOpenExistStoreButton();			
		loginPage.passCreadentilas();
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();	
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
		loginPage.clickOnSubmitLoginButton();		
		boolean clockInButton = loginPage.validateClockInButton();	
		Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
		loginPage.clickOnClockInButton();		
    	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
		loginPage.clickOnroleNameButton();
		
	}
	
	@Test(priority=1)
	public void loginVerifyTestInvalidData3() throws InterruptedException, IOException{
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 loginPage.validatelaunchLink();		 
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
		loginPage.clickOnOpenExistStoreButton();			
		loginPage.passCreadentilas();
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();	
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
		loginPage.clickOnSubmitLoginButton();		
		boolean clockInButton = loginPage.validateClockInButton();	
		Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
		loginPage.clickOnClockInButton();		
    	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
		loginPage.clickOnroleNameButton();
		
	}
	*/
	
	
	@Test(priority=1)
	public void loginVerifyTest() throws InterruptedException, IOException{
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 loginPage.validatelaunchLink();		 
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
		TestUtil.writeStringValue(0, 1, 2);
		loginPage.clickOnOpenExistStoreButton();			
		loginPage.passCreadentilas();
		TestUtil.writeStringValue(0, 1, 3);
		TestUtil.writeStringValue(0, 1, 4);
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();			
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
		TestUtil.writeStringValue(0, 2, 2);
		loginPage.clickOnSubmitLoginButton();	
		TestUtil.writeStringValue(0, 2, 5);
		boolean clockInButton = loginPage.validateClockInButton();	
		Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
		loginPage.clickOnClockInButton();		
    	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
		TestUtil.writeStringValue(0, 2, 6);
    	loginPage.clickOnroleNameButton();
		
	}
	
	
	
	@AfterClass
	public void tearDown(){
		
	//	driver.quit();
	}
	

}
