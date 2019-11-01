package com.torenzo.qa.pomtest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.torenzo.qa.util.StaticVariable.comapre;
import static com.torenzo.qa.util.StaticVariable.EditTotalAmt;
import static com.torenzo.qa.util.StaticVariable.paymentValue;

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

public class PaymentPageTest extends TestBase {

	
	public TransactionOrderPage transactionOrderPage;
	public HomePage homePage;
	public LoginPage loginPage;
	public OrderPage orderPage;
	public GuestPage guestPage;
	public PaymentPage paymentPage;
	public SplitReceiptPage splitReceiptPage;
	public PayingPaymentPage payingPaymentPage;
	public TestUtil testUtil;
	public PaymentPageTest() throws IOException{
		super();
	}

	@BeforeClass
	public void launchApp() throws InterruptedException, IOException{	
		initilization();
	  	//Runtime.getRuntime().exec("E:\\Appium1\\StableMavenProject\\src\\main\\java\\com\\TestData\\command.bat");
		orderPage = new OrderPage(driver);
		guestPage = new GuestPage(driver);
		paymentPage = new PaymentPage(driver);
		transactionOrderPage = new TransactionOrderPage(driver); 
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		transactionOrderPage = new TransactionOrderPage(driver);
		splitReceiptPage = new SplitReceiptPage(driver);
		payingPaymentPage = new PayingPaymentPage(driver);	
		 testUtil = new TestUtil(driver);
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
		Assert.assertTrue(loginPage.validatePermissionPopup(), "Permission popup is not found");				
	    homePage = loginPage.clickOnPermissionPupup();				
			
	}
	
	@Test(priority = 2)
	   public void paymentPageTest() throws InterruptedException, IOException{	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		transactionOrderPage = homePage.clickNewOrderCreateBtn();	
		System.out.println(orderPage.getTextorderNumberFromOrderPage() +"-"+ "Number order is created");		      
		orderPage.selectGuestandAddItem();
		orderPage.totalItemValue();
		System.out.println("Order Total from hub =>" +Double.valueOf(homePage.getTextFromOrderTotal()));
		double totalFromHome = Double.valueOf(homePage.getTextFromOrderTotal());
		homePage.clickOnOrderTotalUpsideButton();
		Assert.assertEquals(testUtil.readDataFromExcellString(2,1,0), paymentPage.verifyPaymentPagetitle(), "Clicking on order total from order window we are not navigated to receipt window");		
		testUtil.writeStringValue(2, 1, 2);		 
		paymentPage.orderTotalFromReceipt();	
		Assert.assertEquals(totalFromHome, 	paymentPage.orderTotalFromReceipt(), "Order total from order creation and receipt total is not matched");
		testUtil.writeStringValue(2, 2, 2);
		
	}
	
	@Test(priority=3)
	public void verifyPaymentTest() throws InterruptedException, IOException{
			paymentPage.totolReceiptCount();
			payingPaymentPage  = paymentPage.clickOnPayBill();		
			Assert.assertTrue(payingPaymentPage.titleOfPaymentWindow(), "Payment window is not opened upon clicking on Paybill button");
			testUtil.writeStringValue(2, 3, 2);
			EditTotalAmt =payingPaymentPage.getTextEditTotalAmt();
			String str = String.format("%1.2f", EditTotalAmt);
			EditTotalAmt = Double.valueOf(str);
			System.out.println("EditTotalAmt=======>" +EditTotalAmt);	
			payingPaymentPage.ClickOnaddPayment();
			paymentValue = payingPaymentPage.getTextpaymentValue();
			System.out.println("EditTotalAmt is =>" +EditTotalAmt);
			System.out.println("paymentValue =>" +paymentValue);
			Assert.assertEquals(EditTotalAmt, paymentValue, "Both value is not matched with each other from Payment Window");
			testUtil.writeStringValue(2, 4, 2);
			payingPaymentPage.clickOnDoneFromPaymentWindow();
		    Assert.assertEquals(payingPaymentPage.verifyPrintOptionWindow(), testUtil.readDataFromExcellString(2,5,0), "Print option is not displayed upon clicking on done from payment window");		
		    testUtil.writeStringValue(2, 5, 2);
		    payingPaymentPage.closeTableWithoutReceiptButton();
		    Assert.assertEquals(homePage.titleOfhomePage(), testUtil.readDataFromExcellString(1,1,0), "Home page is not found (after paying order");		
		    testUtil.writeStringValue(2, 6, 2);
	}

	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		
		driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec(".\\src\\main\\java\\com\\TestData\\command.bat");		
		Thread.sleep(6000);
	
	}
	
	

}

























		/*
			@Test(priority = 3)
			   public void addGuestAndItemToGuest() throws InterruptedException, IOException{
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
			
			@Test(priority = 4)
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
			
			 @AfterClass
	           public void tearDown(){
				 driver.quit();
	           }
		*/
	
	
	

