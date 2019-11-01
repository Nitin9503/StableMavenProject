package com.torenzo.qa.pomtest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class GuestPageTest extends TestBase {
	
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public TransactionOrderPage transactionOrderPage;
	public GuestPage guestPage;
	public TestUtil testUtil;
	
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
		 testUtil = new TestUtil(driver);
	}
	
	@Test(priority=1)
	public void verfiyHomePageTest() throws InterruptedException, IOException{	
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
	public void addGuestToOrder() throws InterruptedException, IOException{	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");
		orderPage.clickOnAddGuestBtn();
		Assert.assertTrue(guestPage.verifytitleOfGuestWindow(),
				"Guest window is not displayed upon clicking on guest button");
		testUtil.writeStringValue(4, 1, 2);
		guestPage.clickAddGuestTwo();
		System.out.println("Guest to order = " + guestPage.getTextGuestCountAddedFromGuestWindow());
		int str = Integer.parseInt(guestPage.getTextGuestCountAddedFromGuestWindow());
		int guestCountFromWindow = 1 + str;
		System.out.println("guestCountFromWindow=>" + guestCountFromWindow);
		guestPage.clickAddGuestDoneClick();
	//	orderPage.guestClick();
		testUtil.longPress(orderPage.guestClick());
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found aftre adding the guest to order");	
		int comapre = orderPage.totolGuestCount();
		//String totalguest = guestPage.getTextGuestCountAddedFromGuestWindow();
		Assert.assertEquals(guestCountFromWindow, comapre, "Guest count not matched from order page with guest window");
		testUtil.writeStringValue(4, 2, 2);
		int guestCount =orderPage.totolGuestCount();		
		System.out.println("Total guest for the order==>" +guestCount);		
		
	}
	
	@Test(priority = 3)
	public void addOneGuestTest() throws InterruptedException, IOException{		
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");
		orderPage.clickOnAddGuestBtn();
		guestPage.clickAddGuestOne();
		System.out.println("Guest to order = " + guestPage.getTextGuestCountAddedFromGuestWindow());
		int str = Integer.parseInt(guestPage.getTextGuestCountAddedFromGuestWindow());
		int guestCountFromWindow = 1 + str;
		System.out.println("guestCountFromWindow=>" + guestCountFromWindow);
		guestPage.clickAddGuestDoneClick();
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found aftre adding the guest to order");	
		int comapre = orderPage.totolGuestCount();
		//String totalguest = guestPage.getTextGuestCountAddedFromGuestWindow();
		Assert.assertEquals(guestCountFromWindow, comapre, "Guest count not matched from order page with guest window");
		testUtil.writeStringValue(4, 5, 2);	
	}
	
	@Test(priority = 4)
	public void addNightinGuestTest() throws InterruptedException, IOException{	
	
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");
		orderPage.clickOnAddGuestBtn();
		guestPage.clickAddGuestOne();
		guestPage.clickAddGuestNine();
		System.out.println("Guest to order = " + guestPage.getTextGuestCountAddedFromGuestWindow());
		int str = Integer.parseInt(guestPage.getTextGuestCountAddedFromGuestWindow());
		int guestCountFromWindow = 1 + str;
		System.out.println("guestCountFromWindow=>" + guestCountFromWindow);
		guestPage.clickAddGuestDoneClick();
		Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found aftre adding the guest to order");	
		int comapre = orderPage.totolGuestCount();
		//String totalguest = guestPage.getTextGuestCountAddedFromGuestWindow();
		Assert.assertEquals(guestCountFromWindow, comapre, "Guest count not matched from order page with guest window");
		testUtil.writeStringValue(4, 6, 2);
		
	}
	
		@Test(priority = 5)
		public void cancelGuestWindowTest() throws InterruptedException, IOException{	
			transactionOrderPage = homePage.clickNewOrderCreateBtn();	
			System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");
			orderPage.clickOnAddGuestBtn();		
			guestPage.ClickOnCancelGuestWindow();
			Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found aftre canceling the guest window");	
			testUtil.writeStringValue(4, 3, 2);				
		}
		
		@Test(priority = 6)
		public void zeroGuestWindowTest() throws InterruptedException, IOException{	
			orderPage.clickOnAddGuestBtn();		
			guestPage.clickAddGuestZero();	
			guestPage.clickAddGuestDoneClick();
			Assert.assertEquals(guestPage.guestAlert(), testUtil.readDataFromExcellString(4,4,0), "Alert message is not displayed upon adding zero guest");	
			testUtil.writeStringValue(4, 4, 2);	
			guestPage.oKOnAleret();
		}
		

		@Test(priority = 7)
		public void addMoreGuestTest() throws InterruptedException, IOException{	
			guestPage.removeGuest();
			guestPage.clickAddGuestTwo();
			guestPage.clickAddGuestZero();
			guestPage.clickAddGuestDoneClick();
			Assert.assertEquals(guestPage.alertGuest(), testUtil.readDataFromExcellString(4,7,0), "Alert message is not displayed upon adding 20 guest");	
			testUtil.writeStringValue(4, 7, 2);	
			guestPage.oKOnAleret();
			
		}
	
		@Test(priority = 8)
		public void deleteGuestWindowTest() throws InterruptedException, IOException{	
			guestPage.removeGuest();
			guestPage.clickAddGuestThree();	
			System.out.println("Guest= " + guestPage.getTextGuestCountAddedFromGuestWindow());
			int guest = Integer.parseInt(guestPage.getTextGuestCountAddedFromGuestWindow());
			System.out.println("guestCountFromWindow=>" + guest);
			guestPage.deleteGuestFromGuestWindow();
			Assert.assertTrue(guestPage.getTextGuestCountAddedFromGuestWindow().isEmpty(), "Guest value is not removed from guest edit box after pressing on Arrow");	
			testUtil.writeStringValue(4, 8, 2);	
			guestPage.ClickOnCancelGuestWindow();
		}
		
		@Test(priority = 8)
		public void deleteGuestFromOrderTest() throws InterruptedException, IOException{	
			guestPage.removeGuest();
			guestPage.clickAddGuestThree();	
			System.out.println("Guest= " + guestPage.getTextGuestCountAddedFromGuestWindow());
			int guest = Integer.parseInt(guestPage.getTextGuestCountAddedFromGuestWindow());
			System.out.println("guestCountFromWindow=>" + guest);
			guestPage.deleteGuestFromGuestWindow();
			Assert.assertTrue(guestPage.getTextGuestCountAddedFromGuestWindow().isEmpty(), "Guest value is not removed from guest edit box after pressing on Arrow");	
			testUtil.writeStringValue(4, 8, 2);	
			guestPage.ClickOnCancelGuestWindow();
		}
		
		
	@AfterClass
	public void tearDown() throws InterruptedException, IOException {	
/*		driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec(".\\src\\main\\java\\com\\TestData\\command.bat");		
		Thread.sleep(6000);*/
	
	}
	
	
	
	
}



/*	@Test(priority = 1)
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
			
		orderPage.selectGuestandAddItem();
		orderPage.totalItemValue();
		System.out.println("Order Total from hub =>" +Double.valueOf(homePage.getTextFromOrderTotal()));
		Assert.assertEquals(orderPage.totalItemValue(), Double.valueOf(homePage.getTextFromOrderTotal()),  "Item total and Total of order is not matched");
		testUtil.writeStringValue(1, 2, 2);
	}



	

}*/
