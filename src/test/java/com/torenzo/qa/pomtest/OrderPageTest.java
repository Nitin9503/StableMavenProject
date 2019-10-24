package com.torenzo.qa.pomtest;

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
import com.torenzo.qa.util.TestUtil;

public class OrderPageTest extends TestBase {
	
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public TransactionOrderPage transactionOrderPage;
	public TestUtil testUtil;
	public OrderPageTest() throws IOException{		
		super();
	}
	
	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
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
	    homePage = loginPage.clickOnPermissionPupup();				
			
	}
	
	@Test(priority = 2)
	public void addItemToOrder() throws InterruptedException, IOException{	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");
		int guestCount =orderPage.totolGuestCount();		
		System.out.println("Total guest for the order==>" +guestCount);			      
		orderPage.selectGuestandAddItem();
		orderPage.totalItemValue();
		System.out.println("Order Total from hub =>" +Double.valueOf(homePage.getTextFromOrderTotal()));
		Assert.assertEquals(orderPage.totalItemValue(), Double.valueOf(homePage.getTextFromOrderTotal()),  "Item total and Total of order is not matched");
		testUtil.writeStringValue(1, 2, 2);
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		
		driver.closeApp();

		Thread.sleep(5000);
	
	}

}




		/*	try{
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
		
			@Test(priority = 3)
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
				
			}*/
      

	
	
	
	
