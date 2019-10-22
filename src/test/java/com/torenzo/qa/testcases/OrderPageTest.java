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
	
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public TransactionOrderPage transactionOrderPage;
	
	
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
	}
	
	
	@Test(priority = 2)
	  public void clickOnCreateNewOrder() throws InterruptedException, IOException{
				
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
		
		}
	
	@Test(priority = 3)
	public void addItemToOrder() throws InterruptedException, IOException{
	
	
		int guestCount =orderPage.totolGuestCount();
		
		System.out.println("Total guest for the order" +guestCount);
			      
		orderPage.selectGuestandAddItem();			
		System.out.println("guestCountFromWindow=>" +homePage.getTextFromOrderTotal());
		//addition of total added item and order total.
		
		
		
     
		
	}
	
	@Test(priority = 3)
	public void paymentVerifyTest() throws InterruptedException, IOException{
	

		
		
		
     
		
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
      

	
	
	
	
