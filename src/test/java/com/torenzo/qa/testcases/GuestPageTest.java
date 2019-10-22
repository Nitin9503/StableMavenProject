package com.torenzo.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.TransactionOrderPage;

public class GuestPageTest extends TestBase {
	
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public TransactionOrderPage transactionOrderPage;
	public GuestPage guestPage;
	
	public GuestPageTest() throws IOException {
		super();
	}
	
	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
		guestPage = new GuestPage(driver);
	}
	
	
	@Test(priority = 1)
	  public void loginAndCreateNewOrder() throws InterruptedException, IOException{
				
		loginPage.validatelaunchLink();		 
	    loginPage.clickOnOpenExistStoreButton();			
		loginPage.passCreadentilas();
		loginPage.clickOnSubmitLoginButton();
		loginPage.clickOnClockInButton();
    	loginPage.clickOnroleNameButton();			    	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);	
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println( orderPage.getTextorderNumberFromOrderPage() +"-"+"Number order is created");
			System.out.println("Order is created through TakeOut");
			transactionOrderPage = homePage.clickNewOrderCreateBtn();
		}


	@Test(priority = 2)
	public void clickOnGuestButtonVerifyWindow() throws InterruptedException, IOException {

		Assert.assertTrue(orderPage.getTextFromFirstGuest(), "Order is not created as geust isn not added");
		System.out.println("Normal order is created = " + orderPage.getTextorderNumberFromOrderPage());
		orderPage.clickOnAddGuestBtn();
		Assert.assertTrue(guestPage.verifytitleOfGuestWindow(),
				"Guest window is not displayed upon clicking on guest button");
		guestPage.clickAddGuestTwo();
		System.out.println("Normal order is created = " + guestPage.getTextGuestCountAddedFromGuestWindow());
		guestPage.clickAddGuestDoneClick();
	}

	@Test(priority = 3)
	public void verifyGuestAddedTest() throws InterruptedException {
		int str = Integer.parseInt(guestPage.getTextGuestCountAddedFromGuestWindow());
		int guestCountFromWindow = 1 + str;
		System.out.println("guestCountFromWindow=>" + guestCountFromWindow);
		int comapre = orderPage.totolGuestCount();
		//String totalguest = guestPage.getTextGuestCountAddedFromGuestWindow();
		Assert.assertEquals(guestCountFromWindow, comapre, "Guest count not matched from order page with guest window");	
		}

	

}
