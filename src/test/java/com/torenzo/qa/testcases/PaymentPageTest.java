package com.torenzo.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.torenzo.qa.util.StaticVariable.comapre;
import static com.torenzo.qa.util.StaticVariable.EditTotalAmt;
import static com.torenzo.qa.util.StaticVariable.paymentValue;
import com.torenzo.qa.base.TestBase;
import com.torenzo.qa.pages.GuestPage;
import com.torenzo.qa.pages.HomePage;
import com.torenzo.qa.pages.LoginPage;
import com.torenzo.qa.pages.OrderPage;
import com.torenzo.qa.pages.PayingPaymentPage;
import com.torenzo.qa.pages.PaymentPage;
import com.torenzo.qa.pages.SplitReceiptPage;
import com.torenzo.qa.pages.TransactionOrderPage;

public class PaymentPageTest extends TestBase {
	
	TransactionOrderPage transactionOrderPage;
	HomePage homePage;
	LoginPage loginPage;
	OrderPage orderPage;
	GuestPage guestPage;
	PaymentPage paymentPage; 
	SplitReceiptPage splitReceiptPage;
	PayingPaymentPage payingPaymentPage;
	
	public PaymentPageTest(){
		super();
	}
	
	@BeforeClass
    public void setUp() throws IOException
    {
		
		System.out.println("Launching the app");
		initilization();
		System.out.println("Launching the app1");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		paymentPage = new PaymentPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
	    splitReceiptPage = new SplitReceiptPage(driver);
	    payingPaymentPage = new PayingPaymentPage(driver);
		System.out.println("Launching the app2");
		
    }
	
	@Test(priority = 0)
	public void loginApp() throws IOException, InterruptedException{
		
		System.out.println("Launching the app");
		Thread.sleep(8000);	 
		loginPage.validatelaunchLink();		
		System.out.println("Launching the app");
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
	     Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");				
	     homePage = loginPage.clickOnPermissionPupup();				
		 homePage.titleOfhomePage();					
			System.out.println("Heelo pass==>"+homePage.titleOfhomePage());		
			Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (login not succefully)");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
				comapre = orderPage.totolGuestCount();
				System.out.println("comapre=>" +comapre);	
				
				if(comapre == guestCountFromWindow){
					System.out.println("Matched");	
				}
				else{
					System.out.println("not Matched");	
				}		
				
				orderPage.selectGuestandAddItem();			
				System.out.println("getTextFromOrderTotal=>" +homePage.getTextFromOrderTotal());
				System.out.println("comapre=>" +comapre);		
		        paymentPage = homePage.clickOnOrderTotalUpsideButton();
		        Assert.assertEquals( paymentPage.verifyPaymentPagetitle(), "PayBill", "Payment Page is not found upon clicking on TotalUpsideButton from Order");
		
				
			}
			
			@Test(priority = 3)
			public void getPaymentDone() throws InterruptedException, IOException{
				splitReceiptPage = paymentPage.ClickOnSplitReceiptClick();
				
				Assert.assertTrue(splitReceiptPage.verifySplitReceiptPage(), "Receipt page is not found upon clicking on Split receipt button");
				
				if (comapre<=1)
				{
					System.out.println("Spliting receipt for single guest");
					splitReceiptPage.clickOnSingleRecipt();
				}
				else
				{
					System.out.println("Spliting receipt for split per guest");
					splitReceiptPage.clickOnSplitPerGuestRecipt();	 	
				}
				
				System.out.println("receipt count is =>" +paymentPage.totolReceiptCount());
				
			Assert.assertEquals(paymentPage.totolReceiptCount(), comapre, "Receipt is not splited as per guest");
			System.out.println("paymentPage.totalReceipt is =>" +paymentPage.totalReceipt.size());
			
			for( WebElement  we : paymentPage.totalReceipt){
				
				we.click();
				payingPaymentPage  = paymentPage.clickOnPayBill();
     			Assert.assertTrue(payingPaymentPage.titleOfPaymentWindow(), "Payment window is not opened upon clicking on Paybill button");
     			EditTotalAmt =payingPaymentPage.getTextEditTotalAmt();
     			EditTotalAmt =EditTotalAmt.substring(0, EditTotalAmt.length()-1);
     			payingPaymentPage.ClickOnaddPayment();
     			paymentValue = payingPaymentPage.getTextpaymentValue();
     			System.out.println("EditTotalAmt is =>" +EditTotalAmt);
     			System.out.println("paymentValue =>" +paymentValue);
     			Assert.assertEquals(EditTotalAmt, paymentValue, "Both value is not matched with each other from Payment Window");
     			payingPaymentPage.clickOnDoneFromPaymentWindow();
     			payingPaymentPage.closeTableWithoutReceiptButton();
     			
     			try{
     				payingPaymentPage.continueWithoutClosingtableButton();
     			}catch(Exception e){
     				 System.out.println("Order is Paid");
     			}
				
			}
		
				Assert.assertEquals(homePage.titleOfhomePage(), "Order", "Home page is not found (after paying order");
			
		
			}
			
			
	
	
	
}
