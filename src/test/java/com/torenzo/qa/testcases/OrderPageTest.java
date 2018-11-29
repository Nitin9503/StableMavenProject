package com.torenzo.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

public class OrderPageTest extends TestBase {
	public OrderPageTest(){
		
		super();
	}
	TransactionOrderPage transactionOrderPage;
	HomePage homePage;
	LoginPage loginPage;
	OrderPage orderPage;
	GuestPage guestPage;
	PaymentPage paymentPage; 

	
	@BeforeClass
    public void setUp() throws IOException, InterruptedException
    {
		initilization();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		paymentPage = new PaymentPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
		
    }
	
	@Test(priority = 0)
	public void loginApp() throws IOException, InterruptedException{
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 
		 loginPage.validatelaunchLink();		 
		Assert.assertTrue(loginPage.validatelaunchLink(), "Login Option Window not Found (App not launched)");		
		loginPage.clickOnOpenExistStoreButton();	  
		boolean titleOfLoginWindow = loginPage.titleOfLoginPage();
		Assert.assertTrue(titleOfLoginWindow, "Login page is not found upon clicking on Open Existing Store");
		loginPage.clickOnSubmitLoginButton();
		boolean clockInButton = loginPage.validateClockInButton();
		Assert.assertTrue(clockInButton, "Clock In Button is not dispalyed upon submitting user with valid creadentials (Check n/w or server)");
		loginPage.clickOnClockInButton();
     	Assert.assertTrue(loginPage.validateTitileClockIn(), "Clock In titile page is not dispalyed upon clickiing on Clock in button");
		loginPage.clickOnroleNameButton();
		
	}
	
	@Test(priority = 1)
	  public void clickOnCreateNewOrder() throws InterruptedException{
	/*  Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");				
	  homePage = loginPage.clickOnPermissionPupup();				
		homePage.titleOfhomePage();					
			System.out.println("Heelo pass==>"+homePage.titleOfhomePage());		
			Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (login not succefully)");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		Thread.sleep(5000);	
		transactionOrderPage = homePage.clickNewOrderCreateBtn();
		
			try{
			if(transactionOrderPage.getTextCancelButtonFromTransaction()){
				
				transactionOrderPage.clickOnbarTabButton();
				Assert.assertTrue(orderPage.getTextFromFirstGuest(), "Order is not created as geust isn not added");
				System.out.println("Normal order is created = " +orderPage.getTextorderNumberFromOrderPage());
			}
			}catch(Exception e){
				System.out.println("Normal order is created");
				Assert.assertTrue(orderPage.getTextFromFirstGuest(), "Order is not created as geust isn not added");
				System.out.println("Normal order is created = " +orderPage.getTextorderNumberFromOrderPage());
				
		
			}
		}
		
			@Test(priority = 2)
			public void addItemToOrder() throws InterruptedException, IOException{
			
				orderPage.clickOnAddGuestBtn();
				Assert.assertTrue(guestPage.verifytitleOfGuestWindow(), "Guest Window Not found upon clicking on Add guest button from order");
				guestPage.clickAddGuestTwo();
				guestPage.getTextGuestCountAddedFromGuestWindow();
				System.out.println("Guest selected =>" +guestPage.getTextGuestCountAddedFromGuestWindow());
				
				int str = Integer.parseInt(guestPage.getTextGuestCountAddedFromGuestWindow());
				int guestCountFromWindow  = 1 + str;
				System.out.println("guestCountFromWindow=>" +guestCountFromWindow);			
				guestPage.clickAddGuestDoneClick();
				int comapre =orderPage.totolGuestCount();
				if(comapre == guestCountFromWindow){
					System.out.println("Matched");	
				}
				else{
					System.out.println(" not Matched");	
				}		      
				orderPage.selectGuestandAddItem();			
				System.out.println("guestCountFromWindow=>" +homePage.getTextFromOrderTotal());
				
		        paymentPage = homePage.clickOnOrderTotalUpsideButton();
				
			}
           @AfterClass
           public void tearDown(){
        	   System.out.println("app getting close");
        	   driver.quit();
           }
	
	}
	
	
	
	
